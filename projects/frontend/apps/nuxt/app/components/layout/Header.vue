<script setup lang="ts">
import { useUserStore } from "@/composables/states/use-user";

const userStore = useUserStore();
const categoryStore = useCategoryStore();
</script>

<template>
	<header class="app-header">
		<div class="container">
			<h1 class="logo">
				<NuxtLink to="/">小兔鲜</NuxtLink>
			</h1>
			<ul class="app-header-nav">
				<li class="home">
					<NuxtLink to="/">首页</NuxtLink>
				</li>
				<li v-for="item in categoryStore.categoryList" :key="item.id">
					<NuxtLink :to="`/category/${item.id}`">{{ item.name }}</NuxtLink>
				</li>
			</ul>
			<div class="search">
				<i class="iconfont icon-search"></i>
				<input type="text" placeholder="搜一搜" />
			</div>
			<!-- 购物车 -->
			<LayoutCart />
		</div>
	</header>
</template>

<style scoped lang="scss">
.app-header {
	background: #fff;

	.container {
		display: flex;
		align-items: center;
	}

	.logo {
		width: 200px;

		a {
			display: block;
			height: 132px;
			width: 100%;
			text-indent: -9999px;
			background: url("@/assets/images/logo.png") no-repeat center 18px / contain;
		}
	}

	.app-header-nav {
		width: 820px;
		display: flex;
		padding-left: 40px;
		position: relative;
		z-index: 998;

		li {
			margin-right: 40px;
			width: 38px;
			text-align: center;

			a {
				font-size: 16px;
				line-height: 32px;
				height: 32px;
				display: inline-block;

				&:hover {
					color: $xtxColor;
					border-bottom: 1px solid $xtxColor;
				}
			}

			.active {
				color: $xtxColor;
				border-bottom: 1px solid $xtxColor;
			}
		}
	}

	.search {
		width: 170px;
		height: 32px;
		position: relative;
		border-bottom: 1px solid #e7e7e7;
		line-height: 32px;

		.icon-search {
			font-size: 18px;
			margin-left: 5px;
		}

		input {
			width: 140px;
			padding-left: 5px;
			color: #666;
		}
	}
}
</style>
