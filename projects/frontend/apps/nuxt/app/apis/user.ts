import request from "@/utils/request";

interface LoginParams {
	account: string;
	password: string;
}

/** 登录请求 */
export function loginAPI({ account, password }: LoginParams) {
	return request({
		url: "/login",
		method: "POST",
		data: {
			account,
			password,
		},
	});
}

interface LikeListParams {
	limit?: number;
}

/** 获取猜你喜欢数据 */
export function getLikeListAPI({ limit = 4 }: LikeListParams = {}) {
	return request({
		url: "/goods/relevant",
		params: {
			limit,
		},
	});
}
