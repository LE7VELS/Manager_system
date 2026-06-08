import request from '@/utils/request'

//查询员工列表数据
export const queryPageApi = (
  name: any,
  gender: any,
  begin: any,
  end: any,
  page: any,
  pageSize: any,
) =>
  request.get(
    `/emps?name=${name}&gender=${gender}&begin=${begin}&end=${end}&page=${page}&pageSize=${pageSize}`,
  )

//新增
export const addApi = (emp: any) => request.post('/emps', emp)

//根据ID查询
export const queryInfoApi = (id: number) => request.get(`/emps/${id}`)

//修改
export const updateApi = (emp: any) => request.put('/emps', emp)

//删除
export const deleteApi = (ids: any) => request.delete(`/emps?ids=${ids}`)

//查询所有员工
export const queryAllApi = () => request.get(`/emps/list`)
