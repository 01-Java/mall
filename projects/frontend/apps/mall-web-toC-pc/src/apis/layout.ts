import { ApifoxModel_HomeCategoryHead } from "@/models/homeCategoryHead";
import { UseAxiosOptions } from "@vueuse/integrations";

// 获取商品分类信息
export const getCategoryAPI = () => {
	return request<any, ApifoxModel_HomeCategoryHead>({
		url: "/home/category/head",
	});
};

// 获取商品分类信息
// export function getCategoryAPI<T = ApifoxModel_HomeCategoryHead>(options?: UseAxiosOptions<T>) {
// 	return useAxios<T>("/home/category/head", request, options);
// }

// () => {
// 	return request<any, ApifoxModel_HomeCategoryHead>({
// 		url: "/home/category/head",
// 	});
// };
