<script setup>
import LayoutNav from "@/views/Layout/components/nav.vue";
import LayoutHeader from "@/views/Layout/components/header.vue";
import LayoutFooter from "@/views/Layout/components/footer.vue";
import LayoutFixed from "@/views/Layout/components/fixed.vue";
import { useCategoryStore } from "@/stores/index.js";

const categoryStore = useCategoryStore();
categoryStore.getCategory();
</script>
<template>
	<LayoutFixed></LayoutFixed>
	<LayoutNav></LayoutNav>
	<LayoutHeader></LayoutHeader>
	<!-- <RouterView :key="$route.fullPath"/> -->
	<RouterView />
	<LayoutFooter></LayoutFooter>
</template>
