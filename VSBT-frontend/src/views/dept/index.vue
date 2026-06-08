<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { queryAllApi, addDeptApi, queryInfoApi, updateDeptApi, deleteDeptApi } from '@/api/dept'
import type { FormInstance, FormRules } from 'element-plus'
import { ElMessage, ElMessageBox } from 'element-plus'

// 部门信息
interface Dept {
  id: number
  name: string
  createTime: string
  updateTime: string
}

// 新增部门
interface DeptForm {
  id?: number
  name: string
}

// 部门列表
const deptList = ref<Dept[]>([])
const formTitle = ref<string>('') // 添加部门表单标题
const deptForm = ref<DeptForm>({
  name: '',
}) // 表单
const showDialog = ref(false) // 是否显示弹窗
const formLabelWidth = ref('120px') // 添加部门表单标签宽度
const deptFormRef = ref<FormInstance>() // 添加部门表单实例

const add = (): void => {
  formTitle.value = '新增部门'
  showDialog.value = true
  deptForm.value = {
    name: '',
  }
} // 新增部门
const resetForm = (): void => {
  deptFormRef.value?.resetFields()
} // 重置表单

// 表单验证规则
const formRules: FormRules = {
  name: [
    { required: true, message: '请输入部门名称', trigger: 'blur' },
    { min: 2, max: 10, message: '长度在 2 到 10 个字符', trigger: 'blur' },
  ],
}

// 添加部门 or 修改部门 (表单确定按钮)
const save = async (): Promise<void> => {
  if (!deptFormRef.value) return

  const valid = await deptFormRef.value.validate()

  if (!valid) return

  let result: any = null

  if (deptForm.value.id) {
    result = await updateDeptApi(deptForm.value) // 修改
  } else {
    result = await addDeptApi(deptForm.value) // 添加
  }

  if (result.code) {
    ElMessage.success('操作成功')

    showDialog.value = false

    resetForm()

    queryAll()
  } else {
    ElMessage.error(result.msg)
  }
}

// 动态加载数据-查询部门
const queryAll = async (): Promise<void> => {
  const result = await queryAllApi()

  deptList.value = result.data
}

// 钩子函数
onMounted(() => {
  queryAll()
})

// 编辑部门 - 根据ID查询回显数据
const handleEdit = async (id: number) => {
  console.log(`Edit item with ID ${id}`)
  formTitle.value = '编辑部门'
  showDialog.value = true
  deptForm.value = {
    name: '',
  }

  const result: any = await queryInfoApi(id)

  if (result.code) {
    deptForm.value = result.data
  }
}

// 删除部门 - 根据ID删除部门
const handleDelete = (id: number) => {
  console.log(`Delete item with ID ${id}`)
  // 弹窗确认
  ElMessageBox.confirm('此操作将永久删除该部门, 是否继续?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning',
  })
    .then(async () => {
      // 删除
      const result: any = await deleteDeptApi(id)
      if (result.code) {
        ElMessage.success('删除成功')
        queryAll()
      }
    })
    .catch(() => {
      ElMessage({
        type: 'info',
        message: '取消删除',
      })
    })
}
</script>

<template>
  <h1>部门管理</h1>

  <!-- 按钮靠页面右侧显示 -->
  <el-button type="primary" @click="add()" style="float: right"> + 新增部门</el-button>
  <br /><br />

  <el-table :data="deptList" border style="width: 100%">
    <el-table-column type="index" label="序号" width="100" align="center" />
    <el-table-column prop="name" label="部门名称" width="300" align="center" />
    <el-table-column prop="updateTime" label="最后修改时间" width="300" align="center" />
    <el-table-column fixed="right" label="操作" align="center">
      <template #default="scope">
        <el-button size="default" type="primary" round @click="handleEdit(scope.row.id)"
          ><el-icon><EditPen /></el-icon>
          修改
        </el-button>
        <el-button size="default" type="danger" round @click="handleDelete(scope.row.id)"
          ><el-icon><Delete /></el-icon>删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>

  <!-- 新增部门的对话框 -->
  <el-dialog v-model="showDialog" :title="formTitle" width="30%" @close="resetForm">
    <el-form :model="deptForm" :rules="formRules" ref="deptFormRef">
      <el-form-item label="部门名称" prop="name" label-width="80px">
        <el-input v-model="deptForm.name" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>

    <template #footer>
      <span class="dialog-footer">
        <el-button @click="showDialog = false">取消</el-button>
        <el-button type="primary" @click="save">确定</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<style scoped></style>
