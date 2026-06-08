import request from '@/utils/request'

//列表查询
export const queryAllApi = () => request.get('/depts')

//添加部门
export const addDeptApi = (data: any) => request.post('/depts', data)

//根据ID查询
export const queryInfoApi = (id: number) => request.get(`/depts/${id}`)

//修改部门
export const updateDeptApi = (data: any) => request.put('/depts', data)

//删除部门
export const deleteDeptApi = (id: number) => request.delete(`/depts?id=${id}`)
