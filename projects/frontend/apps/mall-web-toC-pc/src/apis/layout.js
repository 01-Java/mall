import request from '@/utils/request'

// 获取商品分类信息
export const getCategoryAPI = () => {
	return request({
		url: '/home/category/head'
	})
}
