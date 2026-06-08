import request from '@/utils/request'

//分页条件查询
export const queryPageApi = (begin: any, end: any, name: any, page: any, pageSize: any) =>
  request.get(`/clazzs?begin=${begin}&end=${end}&name=${name}&page=${page}&pageSize=${pageSize}`)

//新增班级
export const addApi = (clazz: any) => request.post('/clazzs', clazz)

//根据ID查询班级
export const queryInfoApi = (id: any) => request.get(`/clazzs/${id}`)

//更新班级
export const updateApi = (clazz: any) => request.put(`/clazzs`, clazz)

//删除班级
export const deleteApi = (id: any) => request.delete(`/clazzs/${id}`)

//查询全部班级信息
export const queryAllApi = () => request.get('/clazzs/list')
