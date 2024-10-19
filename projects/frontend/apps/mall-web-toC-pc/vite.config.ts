import { fileURLToPath, URL } from "node:url";

import { type UserConfig, type ConfigEnv, loadEnv, defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

// FIXME: https://github.com/vitejs/vite/issues/5370
// import { getRouteName } from "@ruan-cat/utils";

// 用tsx实现动态导入依赖包的方案 https://github.com/vitejs/vite/issues/5370#issuecomment-2417686698
// 缺点就是项目启动慢了很多
// import { tsImport } from "tsx/esm/api";
// const { getRouteName } = await tsImport("@ruan-cat/utils", import.meta.url);

import { getRouteName } from "./src/plugins/unplugin-vue-router";

// 引入插件
import AutoImport from "unplugin-auto-import/vite";
import Components from "unplugin-vue-components/vite";
import VueRouter from "unplugin-vue-router/vite";
import { type Options } from "unplugin-vue-router";
import { VueRouterAutoImports } from "unplugin-vue-router";
import { ElementPlusResolver } from "unplugin-vue-components/resolvers";
import ElementPlus from "unplugin-element-plus/vite";
import vueDevTools from "vite-plugin-vue-devtools";

// https://vitejs.dev/config/
export default defineConfig(function ({ mode }: ConfigEnv): UserConfig {
	const env = loadEnv(mode, process.cwd());

	return {
		server: {
			port: Number(env.VITE_APP_PORT),
		},

		plugins: [
			// https://uvr.esm.is/introduction.html#installation
			VueRouter({
				dts: "./types/typed-router.d.ts",
				routesFolder: [
					{
						/**
						 * 在我们项目中，页面放在 views 文件夹下。
						 *
						 * 文档建议是写在pages内
						 * src: "src/pages",
						 */
						src: "src/views",
						// 下面的配置暂时不使用
						// override globals
						// exclude: (excluded) => excluded,
						// filePatterns: (filePatterns) => filePatterns,
						// extensions: (extensions) => extensions,
					},
				],
				getRouteName,
			}),

			vue(),

			// 配置插件
			AutoImport({
				imports: [VueRouterAutoImports],
				ignore: ["vue-router"],
				resolvers: [ElementPlusResolver()],
				dts: "./types/auto-imports.d.ts",
			}),

			Components({
				resolvers: [
					// 配置额，elementPlus采取sass样式配色系统
					ElementPlusResolver({ importStyle: "sass" }),
				],
				dts: "./types/components.d.ts",
			}),

			/**
			 * 开发调试插件
			 * @description
			 * vueDevTools 必须在 createHtmlPlugin 的前面导入
			 *
			 * @see https://github.com/vuejs/devtools-next/issues/278#issuecomment-2021745201
			 */
			vueDevTools(),

			// 按需定制主题配置
			ElementPlus({
				useSource: true,
			}),
		],
		resolve: {
			alias: {
				"@": fileURLToPath(new URL("./src", import.meta.url)),
			},
		},
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
	};
});
