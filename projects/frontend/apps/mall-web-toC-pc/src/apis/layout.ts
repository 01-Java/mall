import { ApifoxModel_HomeCategoryHead } from "@/models/homeCategoryHead";

// 获取商品分类信息
export const getCategoryAPI = () => {
	return request<any, ApifoxModel_HomeCategoryHead>({
		url: "/home/category/head",
	});
};
