import { fileURLToPath, URL } from "node:url";

import { type UserConfig, type ConfigEnv, loadEnv, defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

// 引入插件
import AutoImport from "unplugin-auto-import/vite";
import Components from "unplugin-vue-components/vite";
import VueRouter from "unplugin-vue-router/vite";
import { type Options } from "unplugin-vue-router";
import { VueRouterAutoImports } from "unplugin-vue-router";
import { ElementPlusResolver } from "unplugin-vue-components/resolvers";
import ElementPlus from "unplugin-element-plus/vite";

type GetRouteName = NonNullable<Options["getRouteName"]>;

/**
 * 自主生成路由名称
 * @description
 * 对插件自动生成的路由名称，很不满意，不好看，容易引起阅读歧义。
 *
 * 故自定义。
 *
 * unplugin-vue-router 插件的 getRouteName 配置项
 */
const getRouteName: GetRouteName = function _getRouteName(node): ReturnType<GetRouteName> {
	// 如果是根节点 那么没有对应的文件夹名称 返回空字符串
	if (!node.parent) {
		return "";
	}

	/** 上一次递归产生的字符串 */
	const last = _getRouteName(node.parent);

	/**
	 * 路由名称链接符
	 * @description
	 * 如果上一次递归产生的字符串为空，则不需要链接符
	 */
	const connector = last === "" ? "" : "-";

	/** 当前节点的路由名称 */
	const current = node.value.rawSegment === "index" ? "" : `${connector}${node.value.rawSegment}`;

	// 返回上一次递归产生的字符串和当前节点的路由名称的拼接
	// 从后面逐步拼接
	return last + current;
};

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
						// src: "src/pages",
						// 在我们项目中，页面放在 views 文件夹下。
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
