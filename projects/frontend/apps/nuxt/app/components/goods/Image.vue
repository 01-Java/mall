<script setup lang="ts">
interface Props {
	images?: string[];
	mainImage?: string;
}

const props = withDefaults(defineProps<Props>(), {
	images: () => [],
});

// 当前预览图
const activeIndex = ref(0);

// 图片列表
const imageList = computed(() => {
	return props.mainImage ? [props.mainImage, ...props.images] : [...props.images];
});

// 切换图片
const changePicture = (i: number) => {
	activeIndex.value = i;
};
</script>

<template>
	<div class="goods-image">
		<!-- 大图 -->
		<div class="middle" v-if="imageList[activeIndex]">
			<img :src="imageList[activeIndex]" alt="" />
		</div>
		<!-- 小图列表 -->
		<ul class="small">
			<li
				v-for="(img, i) in imageList"
				:key="img"
				:class="{ active: i === activeIndex }"
				@mouseenter="changePicture(i)"
			>
				<img :src="img" alt="" />
			</li>
		</ul>
	</div>
</template>

<style scoped lang="scss">
.goods-image {
	width: 480px;
	height: 400px;
	position: relative;
	display: flex;

	.middle {
		width: 400px;
		height: 400px;
		background: #f5f5f5;
	}

	.small {
		width: 80px;

		li {
			width: 68px;
			height: 68px;
			margin-left: 12px;
			margin-bottom: 15px;
			cursor: pointer;

			&:hover,
			&.active {
				border: 2px solid $xtxColor;
			}
		}
	}

	img {
		width: 100%;
		height: 100%;
	}
}
</style>
