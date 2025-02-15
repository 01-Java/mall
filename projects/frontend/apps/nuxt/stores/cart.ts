import { defineStore } from 'pinia'

interface CartItem {
  skuId: string
  name: string
  picture: string | string[]
  price: number
  count: number
  attrsText: string
}

export const useCartStore = defineStore('cart', {
  state: () => ({
    cartList: [] as CartItem[]
  }),

  getters: {
    allCount(): number {
      return this.cartList.reduce((sum, item) => sum + item.count, 0)
    },
    allPrice(): number {
      return this.cartList.reduce((sum, item) => sum + item.count * item.price, 0)
    }
  },

  actions: {
    deleteCart(skuId: string) {
      const index = this.cartList.findIndex(item => item.skuId === skuId)
      if (index > -1) {
        this.cartList.splice(index, 1)
      }
    }
  }
}) 