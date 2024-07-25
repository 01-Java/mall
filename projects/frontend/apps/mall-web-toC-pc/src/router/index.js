import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
	history: createWebHistory(import.meta.env.BASE_URL),
	routes: [
		{
			path: "/",
			component: () => import("@/views/Layout/index.vue"),
			children: [
				{
					path: "",
					component: () => import("@/views/Home/index.vue"),
				},
				{
					path: "category/:id",
					component: () => import("@/views/Category/index.vue"),
				},
				{
					path: "category/sub/:id",
					component: () => import("@/views/SubCategory/index.vue"),
				},
				{
					path: "detail/:id",
					component: () => import("@/views/Detail/index.vue"),
				},
				{
					path: "cartlist",
					component: () => import("@/views/CartList/index.vue"),
				},
				{
					path: "checkout",
					component: () => import("@/views/Checkout/index.vue"),
				},
				{
					path: "pay",
					component: () => import("@/views/Pay/index.vue"),
				},
				{
					path: "paycallback", // 注意路径，必须是paycallback
					component: () => import("@/views/Pay/PayBack.vue"),
				},
				{
					path: "member",
					component: () => import("@/views/Member/index.vue"),
					children: [
						{
							path: "",
							component: () => import("@/views/Member/components/UserInfo.vue"),
						},
						{
							path: "order",
							component: () => import("@/views/Member/components/UserOrder.vue"),
						},
					],
				},
			],
		},
		{
			path: "/login",
			component: () => import("@/views/Login/index.vue"),
		},
	],
});

export default router;
