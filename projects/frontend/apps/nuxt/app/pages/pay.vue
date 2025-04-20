<script setup lang="ts">
import { useRoute, useRouter } from "vue-router";
import { ref, onMounted } from "vue";
import { ElMessage } from "element-plus";
import { useCountDown } from "~/composables/useCountDown";
import { getOrderAPI } from "~/apis/order";

// 组合式函数获取支付倒计时
const { formatTime, start } = useCountDown();

// 路由相关
const route = useRoute();
const router = useRouter();

// 订单数据
const orderInfo = ref({
	id: "",
	createTime: "",
	payType: 1,
	orderState: 0,
	payLatestTime: "",
	countdown: 0,
	payMoney: 0,
	skus: [],
});

// 支付地址
const payUrl = ref("");

// 支付状态：1为支付宝，2为微信
const payStatus = ref<1 | 2>(1);

// 获取订单数据
const getOrderInfo = async () => {
	const res = await getOrderAPI(route.query.id as string);
	orderInfo.value = res.data.result;
	// 计算倒计时时间
	if (res.data.result.countdown > 0) {
		start(res.data.result.countdown);
	} else {
		ElMessage.warning("订单支付已超时");
	}
};

// 构建支付URL
const handlePay = () => {
	// 基础接口URL
	const baseURL = "http://pcapi-xiaotuxian-front.itheima.net";
	// 回调地址
	const redirectUrl = encodeURIComponent(window.location.origin + "/pay-result");
	// 根据支付方式构建支付URL
	const payAPI = payStatus.value === 1 ? "/pay/aliPay" : "/pay/wxPay";
	// 构建完整支付URL
	payUrl.value = `${baseURL}${payAPI}?orderId=${orderInfo.value.id}&redirect=${redirectUrl}`;
	// 在新窗口打开支付链接
	window.open(payUrl.value, "_blank");
};

// 处理支付方式切换
const changePayType = (type: 1 | 2) => {
	payStatus.value = type;
};

// 返回购物车
const goBackCart = () => {
	router.push("/cart");
};

// 返回我的订单
const goMyOrders = () => {
	router.push("/member/order");
};

// 初始化时获取订单数据
onMounted(() => {
	getOrderInfo();
});
</script>

<template>
	<div class="xtx-pay-page">
		<div class="container">
			<!-- 付款信息 -->
			<div class="pay-info">
				<span class="icon iconfont icon-queren2"></span>
				<div class="tip">
					<p>订单提交成功！请尽快完成支付。</p>
					<p>
						支付还剩 <span>{{ formatTime }}</span
						>, 支付超时后订单将自动取消
					</p>
				</div>
				<div class="amount">
					<span>应付总额：</span>
					<span>¥{{ orderInfo.payMoney?.toFixed(2) }}</span>
				</div>
			</div>
			<!-- 付款方式 -->
			<div class="pay-type">
				<h3>支付方式</h3>
				<div class="pay-way">
					<p @click="changePayType(1)" :class="{ active: payStatus === 1 }">
						<span>支付宝支付</span>
					</p>
					<p @click="changePayType(2)" :class="{ active: payStatus === 2 }">
						<span>微信支付</span>
					</p>
				</div>
			</div>
			<!-- 操作按钮 -->
			<div class="pay-btn">
				<el-button @click="goBackCart" type="default" size="large">返回购物车</el-button>
				<el-button @click="handlePay" type="primary" size="large">立即支付</el-button>
			</div>
			<!-- 其他按钮 -->
			<div class="pay-action">
				<el-button @click="goMyOrders" type="primary" plain size="large">查看我的订单</el-button>
				<el-button @click="$router.push('/')" type="default" size="large">继续逛逛</el-button>
			</div>
		</div>
	</div>
</template>

<style scoped lang="scss">
.xtx-pay-page {
	margin-top: 20px;
}

.pay-info {
	background: #fff;
	display: flex;
	align-items: center;
	height: 240px;
	padding: 0 80px;

	.icon {
		font-size: 80px;
		color: #1dc779;
	}

	.tip {
		padding-left: 10px;
		flex: 1;

		p {
			&:first-child {
				font-size: 20px;
				margin-bottom: 5px;
			}

			&:last-child {
				color: #999;
				font-size: 16px;
			}
		}
	}

	.amount {
		span {
			&:first-child {
				font-size: 16px;
				color: #999;
			}

			&:last-child {
				color: $priceColor;
				font-size: 20px;
			}
		}
	}
}

.pay-type {
	margin-top: 20px;
	background-color: #fff;
	padding-bottom: 40px;

	h3 {
		font-weight: normal;
		font-size: 16px;
		padding: 20px 80px 0;
	}

	.pay-way {
		display: flex;
		padding: 20px 80px;

		p {
			display: flex;
			flex: 1;
			height: 40px;
			align-items: center;
			border: 1px solid #e4e4e4;
			text-align: center;
			margin-right: 20px;
			cursor: pointer;
			transition: all 0.2s;

			&.active,
			&:hover {
				border-color: $xtxColor;
			}

			&.active {
				border-color: $xtxColor;
				position: relative;

				&::after {
					content: "";
					position: absolute;
					right: 0;
					bottom: 0;
					width: 20px;
					height: 20px;
					background-color: $xtxColor;
					background-image: url("https://yjy-oss-files.oss-cn-zhangjiakou.aliyuncs.com/tuxian/assets/images/selected.png");
					background-size: contain;
				}
			}

			span {
				text-align: center;
				margin: 0 auto;
			}
		}
	}
}

.pay-btn {
	text-align: right;
	padding: 10px 80px;

	.el-button {
		margin-left: 20px;
	}
}

.pay-action {
	text-align: right;
	padding: 10px 80px;

	.el-button {
		margin-left: 20px;
	}
}
</style>
