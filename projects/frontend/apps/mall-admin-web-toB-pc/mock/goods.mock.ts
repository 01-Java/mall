// import { defineMock, type MockResponse } from "@/utils";
import { defineMock, type MockResponse } from "./defineMock";

// import type {
//   GoodsDetail,
//   GoodsPageResult,
//   GoodsQuery,
// } from "@/api/pms/goods/types";

/**
 * 获取商品分页列表
 *
 * @param queryParams
 */
export default defineMock({
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

// /**
//  * 获取商品详情
//  *
//  * @param id
//  */
// export function getSpuDetail(id: string): AxiosPromise<GoodsDetail> {
//   return request({
//     url: "/mall-pms/api/v1/spu/" + id + "/detail",
//     method: "get",
//   });
// }

// /**
//  * 添加商品
//  *
//  * @param data
//  */
// export function addSpu(data: object) {
//   return request({
//     url: "/mall-pms/api/v1/spu",
//     method: "post",
//     data: data,
//   });
// }

// /**
//  * 修改商品
//  *
//  * @param id
//  * @param data
//  */
// export function updateSpu(id: number, data: object) {
//   return request({
//     url: "/mall-pms/api/v1/spu/" + id,
//     method: "put",
//     data: data,
//   });
// }

// /**
//  * 删除商品
//  *
//  * @param ids
//  */
// export function deleteSpu(ids: string) {
//   return request({
//     url: "/mall-pms/api/v1/spu/" + ids,
//     method: "delete",
//   });
// }
