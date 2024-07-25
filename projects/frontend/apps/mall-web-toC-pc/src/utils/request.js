import axios from 'axios'
import { useUserStore } from '@/stores/index'
import { ElMessage } from 'element-plus'
import router from '@/router'

// 创建axios实例
const request = axios.create({
	baseURL: 'http://pcapi-xiaotuxian-front-devtest.itheima.net',
	timeout: 10000 // 请求超时时间
})

// axios请求拦截器
request.interceptors.request.use((config) => {
	// 1.从pinia获取token数据
	const userStore = useUserStore()
	const token = userStore.userInfo.token
	if (token) {
		config.headers.Authorization = `Bearer ${token}`
	}
	return config
}),
	(e) => Promise.reject(e)

// axios响应拦截器
request.interceptors.response.use(
	(res) => res.data,
	(e) => {
		// 统一响应错误
		const userStore = useUserStore()
		console.log(e)
		ElMessage.warning(e.response.data.message)
		// 401token失效处理
		// 1.清除用户数据
		// 2.跳转登录页
		if (e.response.status === 401) {
			userStore.clearUserInfo()
			router.push('/login')
		}
		return Promise.reject(e)
	}
)
export default request
