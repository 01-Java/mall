/**
 * 期望实现自己的自动导入
 * 自己想全局导入一些依赖包 迁移vite的配置
 * @see https://nuxt.com/docs/api/kit/autoimports#examples
 */

import { defineNuxtModule, addImports, createResolver } from "@nuxt/kit";

export default defineNuxtModule({
	setup(options, nuxt) {
		["debounce", "throttle"].forEach((name) => addImports({ name, as: name, from: "lodash-es" }));

		["isConditionsEvery", "isConditionsSome"].forEach((name) =>
			addImports({ name, as: name, from: "@ruan-cat/utils" }),
		);

		["useAxios"].forEach((name) => addImports({ name, as: name, from: "@vueuse/integrations/useAxios" }));
	},
});
