// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
	compatibilityDate: "2024-11-01",
	devtools: { enabled: true },

	// 我们项目的根目录配置就是来自于src的，绝大多数项目的根目录都是src
	srcDir: "src",

	imports: {
		dirs: [
			/** @see https://nuxt.com/docs/guide/directory-structure/composables#how-files-are-scanned */
			"composables/**",
		],
	},

	vite: {
		server: {
			open: true,
		},
	},
});
