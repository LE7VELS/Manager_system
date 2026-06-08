import router from '@/router'
import axios from 'axios'
import type { AxiosResponse, AxiosError } from 'axios'
import { ElMessage } from 'element-plus'

// 创建axios实例
const request = axios.create({
  baseURL: '/api',
  timeout: 600000,
})

//axios的请求 request 拦截器, 每次请求获取localStorage中的loginUser, 从中获取到token
// token放到请求头中, 在请求头token中携带到服务端
request.interceptors.request.use((config) => {
  let loginUser = JSON.parse(localStorage.getItem('loginUser') || '{}')
  console.log(localStorage.getItem('loginUser'))
  if (loginUser.token) {
    config.headers.token = loginUser.token
  }
  return config
})

// 响应拦截器
request.interceptors.response.use(
  (response: AxiosResponse) => {
    return response.data
  },
  (error: AxiosError) => {
    //如果响应的状态码为401, 则路由到登录页面
    console.log('401触发', error.config?.url)
    if (error.response?.status === 401) {
      ElMessage.error('登录失效, 请重新登录')
      router.push('/login')
    } else {
      ElMessage.success('接口访问异常')
    }
    return Promise.reject(error)
  },
)

export default request
