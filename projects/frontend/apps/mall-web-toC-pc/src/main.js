import "@/styles/common.scss";

import { createApp } from "vue";
import pinia from "./stores/index.js";

import App from "./App.vue";
import router from "./router";
// 自定义指令导入
import { lazyPlugin } from "./directives/lazyPlugin.js";

const app = createApp(App);

app.use(pinia);
app.use(router);

app.mount("#app");
// 全局指令注册
app.use(lazyPlugin);
