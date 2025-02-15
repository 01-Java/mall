import { defineStore } from 'pinia'

interface Category {
  id: number
  name: string
}

export const useCategoryStore = defineStore('category', {
  state: () => ({
    categoryList: [] as Category[]
  }),
  
  actions: {
    async getCategoryList() {
      // TODO: 实现获取分类列表的逻辑
      // const { data } = await useFetch('/api/category')
      // this.categoryList = data.value
    }
  }
}) 