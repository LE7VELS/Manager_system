import request from '@/utils/request'

//分页条件查询
export const queryPageApi = (clazzId: any, degree: any, name: any, page: any, pageSize: any) =>
  request.get(
    `/students?clazzId=${clazzId}&degree=${degree}&name=${name}&page=${page}&pageSize=${pageSize}`,
  )

//新增学生
export const addApi = (stu: any) => request.post('/students', stu)

//根据ID查询学生
export const queryInfoApi = (id: any) => request.get(`/students/${id}`)

//修改学生
export const updateApi = (stu: any) => request.put(`/students`, stu)

//删除学生
export const deleteApi = (ids: any) => request.delete(`/students/${ids}`)

//违纪处理
export const handleViolationApi = (id: any, score: any) =>
  request.put(`/students/violation/${id}/${score}`)
