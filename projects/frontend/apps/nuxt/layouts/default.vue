<script setup lang="ts">
import { useCategoryStore } from '~/stores/category'
const categoryStore = useCategoryStore()
</script>

<template>
  <div class="layout">
    <!-- 导航栏 -->
    <LayoutNav />
    <!-- 头部 -->
    <LayoutHeader />
    <!-- 主要内容区域 -->
    <slot />
    <!-- 底部 -->
    <LayoutFooter />
    <!-- 固定导航 -->
    <LayoutFixed />
  </div>
</template>

<style scoped lang="scss">
.layout {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}
</style> 