<script setup lang="ts">
import HomePanel from "./HomePanel.vue";
import { getHotGoodsAPI } from "@/apis/home";
import { ref } from "vue";

const hotGoodsList = ref([]);
const getHotGoods = async () => {
	const res = await getHotGoodsAPI();
	hotGoodsList.value = res.result;
};
getHotGoods();
</script>

<template>
	<HomePanel title="人气推荐" sub-title="人气爆款 不容错过">
		<template #main>
			<ul class="goods-list">
				<li v-for="item in hotGoodsList" :key="item.id">
					<RouterLink :to="`/detail/${item.id}`">
						<img v-img-lazy="item.picture" alt="" />
						<p class="name">{{ item.title }}</p>
						<p class="desc">{{ item.alt }}</p>
					</RouterLink>
				</li>
			</ul>
		</template>
	</HomePanel>
</template>

<style scoped lang="scss">
.goods-list {
	display: flex;
	justify-content: space-between;
	height: 426px;

	li {
		width: 306px;
		height: 406px;
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
		}

		.desc {
			color: #999;
			font-size: 18px;
		}
	}
}
</style>
