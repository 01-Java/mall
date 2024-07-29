import { defineMock, type MockResponse } from "@/utils";

import type { CaptchaResult, LoginData, LoginResult } from "./types";

/**
 * 登录API
 *
 * @param data {LoginData}
 * @returns
 */
export function loginApi_2(data: LoginData): AxiosPromise<LoginResult> {
  const formData = new FormData();
  formData.append("username", data.username);
  formData.append("password", data.password);
  formData.append("captchaId", data.captchaId as string);
  formData.append("captchaCode", data.captchaCode as string);
  formData.append("grant_type", "password");
  return request({
    url: "/youlai-auth/oauth2/token",
    method: "post",
    data: formData,
    headers: {
      "Content-Type": "multipart/form-data",
      Authorization: "Basic bWFsbC1hZG1pbjoxMjM0NTY=", // 客户端信息Base64明文：mall-admin:123456
    },
  });
}

export const loginApi = defineMock({
  url: "/youlai-auth/oauth2/token",
  method: "post",

  data: formData,
  headers: {
    "Content-Type": "multipart/form-data",
    Authorization: "Basic bWFsbC1hZG1pbjoxMjM0NTY=", // 客户端信息Base64明文：mall-admin:123456
  },
});

/**
 * 获取商品分页列表
 *
 * @param queryParams
 */
export const getSpuPage = defineMock({
  url: "/mall-pms/api/v1/spu/page",
  method: "GET",
  body(request) {
    return {
      status: 200,
      data: {
        total: 1,
        list: [
          {
            brandName: "Apple",
            categoryName: "手机",
            description: "iPhone 13 Pro Max 256GB",
            id: "1",
            name: "iPhone 13 Pro Max",
            originPrice: "9999",
            price: "9999",
            sales: 100,
            skuList: [],
            unit: "台",
            detail: "iPhone 13 Pro Max 256GB",
          },
        ],
      },
    } satisfies MockResponse<GoodsPageResult>;
  },
});
