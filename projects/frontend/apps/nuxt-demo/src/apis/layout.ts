import { type ApifoxModel_HomeCategoryHead } from "@/models/homeCategoryHead";
import { type UseAxiosOptions } from "@vueuse/integrations";

import axios from "axios";

// 获取商品分类信息
// export const getCategoryAPI = () => {
// 	return request<any, ApifoxModel_HomeCategoryHead>({
// 		url: "/home/category/head",
// 	});
// };

/** 获取商品分类信息 */
export function getCategoryAPI<T = ApifoxModel_HomeCategoryHead>(options?: UseAxiosOptions<T>) {
	// return useAxios<T>("/home/category/head", requestForUseAxios, options);
	// 成功 可以做接口请求
	return useAxios<T>(
		"/home/category/head",
		{
			baseURL: "https://pcapi-xiaotuxian-front-devtest.itheima.net",
		},
		axios,
		options,
	);
}

// () => {
// 	return request<any, ApifoxModel_HomeCategoryHead>({
// 		url: "/home/category/head",
// 	});
// };
