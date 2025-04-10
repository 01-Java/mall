// import { pwa } from './app/config/pwa'
// import { appDescription } from './app/constants/index'
import { resolve } from "path";

export default defineNuxtConfig({
	modules: [
		"@vueuse/nuxt",
		"@unocss/nuxt",
		"@pinia/nuxt",
		"@nuxtjs/color-mode",
		"@vite-pwa/nuxt",
		"@element-plus/nuxt",
	],

	devtools: {
		enabled: true,
	},

	app: {
		head: {
			viewport: "width=device-width,initial-scale=1",
			link: [
				{ rel: "icon", href: "/favicon.ico", sizes: "any" },
				{ rel: "icon", type: "image/svg+xml", href: "/nuxt.svg" },
				{ rel: "apple-touch-icon", href: "/apple-touch-icon.png" },
			],
			meta: [
				{ name: "viewport", content: "width=device-width, initial-scale=1" },
				// { name: 'description', content: appDescription },
				{ name: "apple-mobile-web-app-status-bar-style", content: "black-translucent" },
				{ name: "theme-color", media: "(prefers-color-scheme: light)", content: "white" },
				{ name: "theme-color", media: "(prefers-color-scheme: dark)", content: "#222222" },
			],
		},
	},

	css: [
		"@unocss/reset/tailwind.css",
		// '@/assets/styles/common.scss'
	],

	colorMode: {
		classSuffix: "",
	},

	future: {
		compatibilityVersion: 4,
	},

	experimental: {
		// when using generate, payload js assets included in sw precache manifest
		// but missing on offline, disabling extraction it until fixed
		payloadExtraction: false,
		renderJsonPayloads: true,
		typedPages: true,
	},

	compatibilityDate: "2024-08-14",

	nitro: {
		esbuild: {
			options: {
				target: "esnext",
			},
		},
		prerender: {
			crawlLinks: false,
			routes: ["/"],
			ignore: ["/hi"],
		},
	},

	// pwa,

	runtimeConfig: {
		public: {
			apiBase: process.env.NUXT_PUBLIC_API_BASE || "/api",
		},
	},

	imports: {
		dirs: ["stores", "composables/**"],
		presets: ["vue", "vue-router", "@vueuse/core"],
	},

	alias: {
		"@": resolve(__dirname, "./"),
		assets: resolve(__dirname, "./assets"),
		public: resolve(__dirname, "./public"),
	},

	// elementPlus: {
	//   importStyle: 'scss',
	//   themes: ['dark']
	// },
	// typescript: {
	//   tsConfig: {
	//     compilerOptions: {
	//       types: ['element-plus/global']
	//     }
	//   }
	// },
	// build: {
	//   transpile: ['element-plus/es']
	// }
});
