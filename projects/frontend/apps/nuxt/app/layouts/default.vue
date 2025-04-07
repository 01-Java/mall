<script setup lang="ts">
// 布局组件的逻辑
</script>

<template>
	<div class="app">
		<!-- 顶部导航 -->
		<LayoutTopnav />
		<!-- 头部组件 -->
		<LayoutHeader />
		<!-- 吸顶组件 -->
		<LayoutFixed />

		<!-- 页面主体 -->
		<main class="app-body">
			<slot />
		</main>

		<!-- 底部信息 -->
		<LayoutFooter />
	</div>
</template>

<style lang="scss">
// 移除 scoped，让样式可以影响子组件
.app {
	min-height: 100vh;
	display: flex;
	flex-direction: column;
}

.app-body {
	flex: 1;
	min-height: 600px;
	padding-top: 20px;
}

.container {
	width: 1240px;
	margin: 0 auto;
	position: relative;
}
</style>
