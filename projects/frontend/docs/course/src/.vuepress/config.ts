import { defineUserConfig } from "vuepress";

import theme from "./theme.js";

export default defineUserConfig({
	base: "/",

	lang: "zh-CN",
	title: "商城项目文档",
	description: "01星球-Java再启航小组-商城项目文档",

	theme,

	// 和 PWA 一起启用
	// shouldPrefetch: false,
});
