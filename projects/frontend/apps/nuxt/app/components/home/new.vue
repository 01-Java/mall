<script setup lang="ts">
import { getNewGoodsAPI } from "@/apis/home";

const newGoodsList = ref([]);
const getNewGoods = async () => {
	const res = await getNewGoodsAPI();
	newGoodsList.value = res.result;
};
onMounted(() => getNewGoods());
</script>

<template>
	<HomePanel title="新鲜好物" subTitle="新鲜出炉 品质靠谱">
		<template #main>
			<!-- 下面是插槽主体内容模版 -->
			<ul class="goods-list">
				<li v-for="item in newGoodsList" :key="item.id">
					<NuxtLink :to="`/detail/${item.id}`">
						<img :src="item.picture" alt="" />
						<p class="name">{{ item.name }}</p>
						<p class="price">&yen;{{ item.price }}</p>
					</NuxtLink>
				</li>
			</ul>
		</template>
	</HomePanel>
</template>

<style scoped lang="scss">
.goods-list {
	display: flex;
	justify-content: space-between;
	height: 406px;

	li {
		width: 306px;
		height: 406px;
		background: #f0f9f4;
		transition: all 0.5s;

		&:hover {
			transform: translate3d(0, -3px, 0);
			box-shadow: 0 3px 8px rgb(0 0 0 / 20%);
		}

		img {
			width: 306px;
			height: 306px;
		}

		p {
			font-size: 22px;
			padding-top: 12px;
			text-align: center;
			text-overflow: ellipsis;
			overflow: hidden;
			white-space: nowrap;
		}

		.price {
			color: $priceColor;
		}
	}
}
</style>
