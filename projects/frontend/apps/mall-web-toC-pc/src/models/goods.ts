export interface Good {
	// 商品id
	id: number;
	// 商品名称
	name: string;
	// 商品价格
	price: number;
	// 商品图片
	image: string;
	// 商品描述
	desc: string;
	// 商品类型
	type: string;
	// 商品库存
	stock: number;
	// 商品销量
	sales: number;
	// 商品评分
	rating: number;
	// 商品评价数
	ratingCount: number;
	// 商品收藏数
	collectCount: number;
	// 商品评论数
	commentCount: number;
	// 商品分享数
	shareCount: number;
	// 商品是否收藏
	isCollect: boolean;
	// 商品是否加入购物车
	isCart: boolean;
}
export interface GoodsProductAPI {
	code: string;
	msg: string;

	result: Good[];
}
