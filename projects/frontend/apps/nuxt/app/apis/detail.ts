import request from "@/utils/request";
import type { ApifoxModel_goods } from "@/models/goods";
import type { UseAxiosOptions } from "@vueuse/integrations";
import { requestForUseAxios } from "@/utils/axios";

/** 获取商品详情 */
export function getDetailAPI<T = ApifoxModel_goods>(id: string, options?: UseAxiosOptions<T>) {
	return useAxios<T>("/goods", { params: { id } }, requestForUseAxios, options);
}

interface HotGoodsParams {
	id: string | number;
	type: number;
	limit?: number;
}

/** 获取热榜商品
 * @param id - 商品id
 * @param type - 1代表24小时热销榜 2代表周热销榜
 * @param limit - 获取个数
 */
export function fetchHotGoodsAPI({ id, type, limit = 3 }: HotGoodsParams) {
	return request({
		url: "/goods/hot",
		params: {
			id,
			type,
			limit,
		},
	});
}
