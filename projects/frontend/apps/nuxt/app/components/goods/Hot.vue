<script setup lang="ts">
import { fetchHotGoodsAPI } from "@/apis/detail";

interface Props {
	type: number;
	goodsId: string;
}

const props = defineProps<Props>();

// TODO: 补充正确的类型
const hotList = ref([]);

// 获取热门商品数据
const getHotList = async () => {
	const res = await fetchHotGoodsAPI({
		id: props.goodsId,
		type: props.type,
	});
	// @ts-ignore
	hotList.value = res.result;
};

onMounted(() => {
	getHotList();
});
</script>

<template>
	<div class="goods-hot">
		<h3>{{ type === 1 ? "24小时热榜" : "周热榜" }}</h3>
		<!-- 商品列表 -->
		<GoodsItem v-for="item in hotList" :key="item.id" :goods="item" />
	</div>
</template>

<style scoped lang="scss">
.goods-hot {
	h3 {
		height: 70px;
		background: $helpColor;
		color: #fff;
		font-size: 18px;
		line-height: 70px;
		padding-left: 25px;
		margin-bottom: 10px;
		font-weight: normal;
	}

	:deep(.goods-item) {
		background: #fff;
		width: 100%;
		margin-bottom: 10px;

		img {
			width: 120px;
			height: 120px;
		}

		p {
			margin: 0 10px;
		}

		.desc {
			height: 22px;
		}

		.price {
			margin-top: 5px;
		}
	}
}
</style>
