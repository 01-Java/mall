import axios from "axios";
import { useUserStore } from "@/stores/index";
import { ElMessage } from "element-plus";
import router from "@/router";

/**
 * 创建axios实例
 */
export function createAxiosInstance() {
	const instance = axios.create({
		// baseURL: "http://pcapi-xiaotuxian-front-devtest.itheima.net",
		baseURL: "https://pcapi-xiaotuxian-front-devtest.itheima.net",
		timeout: 10000, // 请求超时时间
	});

	return instance;
}

/**
 * 通用的，标准的请求实例
 */
const request = createAxiosInstance();

// axios 请求拦截器
request.interceptors.request.use(
	(config) => {
		// 1.从pinia获取token数据
		const userStore = useUserStore();
		// @ts-ignore
		const token = userStore.userInfo.token;
		if (token) {
			config.headers.Authorization = `Bearer ${token}`;
		}
		return config;
	},
	(e) => Promise.reject(e),
);

// axios 响应拦截器
request.interceptors.response.use(
	// 这里决定了 每一个接口返回值的数据 都默认完成data数据解包。
	(res) => res.data,
	// 其他配置也用 可能出现冲突
	// (res) => res,

	(e) => {
		// 统一响应错误
		const userStore = useUserStore();
		console.warn(" 出现请求错误 错误如下： ", e);
		ElMessage.warning(e.response.data.message);
		// 401token失效处理
		// 1.清除用户数据
		// 2.跳转登录页
		if (e.response.status === 401) {
			userStore.clearUserInfo();
			router.push("/login");
		}
		return Promise.reject(e);
	},
);

/**
 * 用于useAxios的axios实例
 * @description
 * useAxios 使用具体的示例时，其拦截器是默认使用返回原来的数据的。
 *
 * 并不会使用我们配置的拦截器。
 *
 * 因此本实例将默认保持返回值为原值。
 */
const requestForUseAxios = createAxiosInstance();

// axios 请求拦截器
requestForUseAxios.interceptors.request.use(
	(config) => {
		const userStore = useUserStore();
		// @ts-ignore
		const token = userStore.userInfo.token;
		if (token) {
			config.headers.Authorization = `Bearer ${token}`;
		}
		return config;
	},
	(e) => Promise.reject(e),
);

// axios 响应拦截器
requestForUseAxios.interceptors.response.use(
	(res) => res,
	(e) => {
		const userStore = useUserStore();
		console.warn(" 出现请求错误 错误如下： ", e);
		ElMessage.warning(e.response.data.message);
		if (e.response.status === 401) {
			userStore.clearUserInfo();
			router.push("/login");
		}
		return Promise.reject(e);
	},
);

// 先配置 再导出
export { requestForUseAxios };

export default request;
