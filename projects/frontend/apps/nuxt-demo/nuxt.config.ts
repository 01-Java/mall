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

	vite: {
		server: {
			open: true,
		},
	},
});
