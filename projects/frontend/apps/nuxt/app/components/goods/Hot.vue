<script setup lang="ts">
import { fetchHotGoodsAPI } from "@/apis/detail";

interface Props {
	// 接受type适配不同类型的热榜数据
	// 1代表24小时热销榜 2代表周热销榜
	type: 1 | 2;
}

const props = withDefaults(defineProps<Props>(), {
	type: 1,
});

// 使用Record<number, string>避免隐式any索引错误
const titleMap: Record<number, string> = {
	1: "24小时热榜",
	2: "周热榜",
};
const title = computed(() => titleMap[props.type]);

// 定义商品类型
interface GoodItem {
	id: string;
	name: string;
	desc: string;
	price: string | number;
	picture: string;
}

// 获取热榜数据
const goodList = ref<GoodItem[]>([]);
const route = useRoute();
const getHotList = async () => {
	try {
		const res = await fetchHotGoodsAPI({
			id: route.params.id as string,
			type: props.type,
		});
		// 确保响应数据符合期望格式
		goodList.value = res.data?.result || [];
	} catch (error) {
		console.error('获取热榜数据失败', error);
	}
};

onMounted(() => {
	getHotList();
});
</script>

<template>
	<div class="goods-hot">
		<h3>{{ title }}</h3>
		<!-- 商品区块 -->
		<div class="goods-list">
			<GoodsItem 
				v-for="item in goodList" 
				:key="item.id" 
				:good="item" 
				class="goods-item"
			/>
		</div>
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

	.goods-list {
		display: flex;
		flex-direction: column;
	}

	.goods-item {
		margin-bottom: 10px;
	}
}
</style>
