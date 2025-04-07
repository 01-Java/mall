<script setup lang="ts">
const userStore = useUserStore();
</script>

<template>
	<nav class="app-topnav">
		<div class="container">
			<ul>
				<template v-if="userStore.profile.token">
					<li>
						<a href="javascript:;"><i class="iconfont icon-user"></i>{{ userStore.profile.account }}</a>
					</li>
					<li><NuxtLink to="/member">个人中心</NuxtLink></li>
					<li><a href="javascript:;" @click="userStore.logout()">退出登录</a></li>
				</template>
				<template v-else>
					<li><NuxtLink to="/login">请先登录</NuxtLink></li>
					<li><NuxtLink to="/login">免费注册</NuxtLink></li>
				</template>
				<li><NuxtLink to="/member/order">我的订单</NuxtLink></li>
				<li><NuxtLink to="/member">会员中心</NuxtLink></li>
				<li><NuxtLink to="/">关于我们</NuxtLink></li>
				<li><a href="javascript:;">客户服务</a></li>
			</ul>
		</div>
	</nav>
</template>

<style scoped lang="scss">
.app-topnav {
	background: #333;

	.container {
		height: 53px;
		display: flex;
		justify-content: flex-end;
		align-items: center;

		ul {
			display: flex;
			align-items: center;

			li {
				a {
					padding: 0 15px;
					color: #cdcdcd;
					line-height: 1;
					display: inline-block;

					i {
						font-size: 14px;
						margin-right: 2px;
					}

					&:hover {
						color: $xtxColor;
					}
				}

				~ li {
					a {
						border-left: 2px solid #666;
					}
				}
			}
		}
	}
}
</style>
