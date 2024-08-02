import { fileURLToPath, URL } from "node:url";

import { type UserConfig, type ConfigEnv, loadEnv, defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

// 引入插件
import AutoImport from "unplugin-auto-import/vite";
import Components from "unplugin-vue-components/vite";
import { ElementPlusResolver } from "unplugin-vue-components/resolvers";
import ElementPlus from "unplugin-element-plus/vite";

// https://vitejs.dev/config/
export default defineConfig(function ({ mode }: ConfigEnv): UserConfig {
	const env = loadEnv(mode, process.cwd());

	return {
		server: {
			port: Number(env.VITE_APP_PORT),
		},

		plugins: [
			vue(),
			// 配置插件
			AutoImport({
				resolvers: [ElementPlusResolver()],
			}),
			Components({
				resolvers: [
					// 配置额，elementPlus采取sass样式配色系统
					ElementPlusResolver({ importStyle: "sass" }),
				],
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
