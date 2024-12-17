// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
	compatibilityDate: "2024-11-01",
	devtools: { enabled: true },
	srcDir: "src",

	imports: {
		dirs: [
			/** @see https://nuxt.com/docs/guide/directory-structure/composables#how-files-are-scanned */
			"composables/**",
		],
	},

	modules: [
		"@element-plus/nuxt",
		/** @see https://nuxt.com/modules/vueuse */
		"@vueuse/nuxt",
	],
	elementPlus: {
		/** Options */
	},

	vite: {
		server: {
			open: true,
		},

		/**
		 * 处理nuxt导入全局scss变量的问题
		 *
		 * @description
		 * vite怎么做，nuxt就如何做
		 * 目前没看到nuxt有什么专门的配置
		 * @see https://juejin.cn/post/7443087944720384050#heading-4
		 *
		 * @description
		 * 按照 @element-plus/nuxt 的文档，给nuxt项目手动安装element-plus，现在全局样式得到导入了。
		 * @see https://nuxt.com/modules/element-plus#installation
		 */
		css: {
			preprocessorOptions: {
				scss: {
					// 自动导入定制化样式文件进行样式覆盖
					additionalData: `
							@use "@/styles/element/index.scss" as *;
							@use "@/styles/var.scss" as *;
						`,
				},
			},
		},
	},
});
