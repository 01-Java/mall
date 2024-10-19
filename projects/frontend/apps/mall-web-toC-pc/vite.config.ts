import { dirname, resolve } from "node:path";
import { fileURLToPath, URL } from "node:url";
import * as fs from "node:fs";

import { upperFirst } from "lodash-es";
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
import { VueRouterAutoImports } from "unplugin-vue-router";
import { ElementPlusResolver } from "unplugin-vue-components/resolvers";
import ElementPlus from "unplugin-element-plus/vite";
import vueDevTools from "vite-plugin-vue-devtools";
import { visualizer } from "rollup-plugin-visualizer";
import { createPlugin, getName } from "vite-plugin-autogeneration-import-file";

const { autoImport } = createPlugin();

const __filename = fileURLToPath(import.meta.url);
const __dirname = dirname(__filename);
function pathResolve(dir: string) {
	const resPath = resolve(__dirname, ".", dir);
	return resPath;
}

// https://vitejs.dev/config/
export default defineConfig(function ({ mode }: ConfigEnv): UserConfig {
	const env = loadEnv(mode, process.cwd());

	return {
		server: {
			port: Number(env.VITE_APP_PORT),
			open: true,
		},

		plugins: [
			/**
			 * 类型化路由插件
			 * @description
			 * 其定义位置必须在 `@vitejs/plugin-vue` 插件之前。
			 *
			 * @see https://uvr.esm.is/introduction.html#installation
			 */
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

			/**
			 * 打包体积分析插件
			 */
			visualizer({
				filename: "./dist/visualizer/index.html",
				title: "visualizer打包分析报告",
				template: "network",
			}),

			vue(),

			/**
			 * 自动生成类型声明文件插件
			 */
			autoImport([
				{
					pattern: ["**/*.vue"],

					// 监听的文件夹
					dir: pathResolve("src/components"),

					// 生成的文件
					// FIXME: 当不包含文件路径时，就出现错误 如果没有预先准备好文件夹，就会生成失败。
					toFile: pathResolve("types/components-instance.d.ts"),

					// 文件生成模板
					template: fs.readFileSync(pathResolve("template/components.template.d.ts"), "utf-8"),

					codeTemplates: [
						{
							key: "//typeCode",
							template: 'type {{name}}Instance = InstanceType<typeof import("{{path}}")["default"]>;\n  ',
						},
					],

					/**
					 * 组件名命名规则支持字符串模板和函数
					 * @description
					 * 设置首字母为大写
					 */
					name(fileName) {
						const resFileName = getName(fileName);
						const upperFirstFileName = upperFirst(resFileName);
						// console.log(" in name", upperFirstFileName);
						return upperFirstFileName;
					},
				},
			]),

			// 配置插件
			AutoImport({
				imports: [VueRouterAutoImports],
				ignore: ["vue-router"],

				dirs: [
					// "./src/apis", "./src/stores", "./src/composables", "./src/utils", "./src/plugins"
					"src/**/*",
				],
				dts: "./types/auto-imports.d.ts",
				resolvers: [ElementPlusResolver()],
			}),

			Components({
				version: 3,
				dirs: ["src/components", "src/views"],
				dts: "./types/components.d.ts",
				directoryAsNamespace: true,
				resolvers: [
					// 配置额，elementPlus采取sass样式配色系统
					ElementPlusResolver({ importStyle: "sass" }),
				],
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
