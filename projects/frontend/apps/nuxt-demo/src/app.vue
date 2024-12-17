<script setup lang="ts">
// import { RouterView } from "vue-router";

/**
 * 在nuxt内 要直接使用来自vueuse的 useTitle
 * @see https://nuxt.com/modules/vueuse#caveats
 */
import { useTitle } from "@vueuse/core";
import { settings } from "@/settings/index";

useTitle(settings.title);
</script>

<template>
	<section class="app-root">
		<!-- 不使用vite的基础根界面 -->
		<!-- <RouterView /> -->

		<!-- 
			在nuxt项目 用 NuxtPage 而不是 RouterView
			https://nuxt.com/docs/api/components/nuxt-page#props 
		-->
		<NuxtPage />
	</section>

	<!-- <div>
		<NuxtRouteAnnouncer />
		<NuxtWelcome />
	</div> -->
</template>

<style lang="scss">
.app-root {
}
</style>
