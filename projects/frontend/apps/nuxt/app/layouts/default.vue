<script setup lang="ts">
// 布局组件的逻辑
</script>

<template>
	<div class="mall-container">
		<LayoutNav />
		<LayoutHeader />
		<main class="main-content">
			<slot />
		</main>
		<LayoutFooter />
		<LayoutFixed />
		<LayoutCart />
	</div>
</template>

<style scoped lang="scss">
.mall-container {
	min-width: 1240px;
	display: flex;
	flex-direction: column;
	min-height: 100vh;
}

.main-content {
	flex: 1;
	padding-top: 0;
}

.container {
	width: 1240px;
	margin: 0 auto;
	position: relative;
}
</style>
