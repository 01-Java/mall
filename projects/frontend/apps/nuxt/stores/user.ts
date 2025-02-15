import { defineStore } from 'pinia'

interface UserInfo {
  token: string
  nickname: string
}

export const useUserStore = defineStore('user', {
  state: () => ({
    userInfo: {
      token: '',
      nickname: ''
    } as UserInfo
  }),
  
  actions: {
    clearUserInfo() {
      this.userInfo = {
        token: '',
        nickname: ''
      }
    }
  }
}) 