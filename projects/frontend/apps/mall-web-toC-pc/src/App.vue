<script setup lang="ts">
import { RouterView } from "vue-router";

import { useTitle } from "@vueuse/core";
import { settings } from "@/settings/index";

useTitle(settings.title);
</script>

<template>
	<RouterView />
</template>

<style scoped></style>
