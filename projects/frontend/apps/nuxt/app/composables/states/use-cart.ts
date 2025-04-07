import { defineStore } from "pinia";
import { ref, computed } from "vue";

interface CartItem {
	id: string;
	skuId: string;
	name: string;
	picture: string | string[];
	price: number;
	count: number;
	attrsText: string;
}

export const useCartStore = defineStore("cart", () => {
	const cartList = ref<CartItem[]>([]);

	const allCount = computed(() => {
		return cartList.value.reduce((sum, item) => sum + item.count, 0);
	});

	const allPrice = computed(() => {
		return cartList.value.reduce((sum, item) => sum + item.count * item.price, 0);
	});

	function addCart(item: CartItem) {
		const goods = cartList.value.find((good) => good.skuId === item.skuId);
		if (goods) {
			goods.count++;
		} else {
			cartList.value.push(item);
		}
	}

	function deleteCart(skuId: string) {
		const idx = cartList.value.findIndex((item) => item.skuId === skuId);
		cartList.value.splice(idx, 1);
	}

	return {
		cartList,
		allCount,
		allPrice,
		addCart,
		deleteCart,
	};
});
