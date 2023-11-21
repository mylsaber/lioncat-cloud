import { UserStore } from 'src/types/login'
import { defineStore } from 'pinia'

const useUserStore = defineStore('User', {
  state: (): UserStore => {
    return {
      userInfo: {
        id: -1,
        userName: '',
        password: '',
        avatar: '',
        status: 0,
        phoneNumber: '',
        gender: 0,
        email: '',
        role: [],
        userType: 0,
        loginIp: '',
        loginDate: '',
        creator: 0,
        createTime: '',
        updater: 0,
        updateTime: '',
      },
    }
  },
  actions: {
    clearUserInfo() {
      this.userInfo = {
        id: -1,
        userName: '',
        password: '',
        avatar: '',
        status: 0,
        phoneNumber: '',
        gender: 0,
        email: '',
        role: [],
        userType: 0,
        loginIp: '',
        loginDate: '',
        creator: 0,
        createTime: '',
        updater: 0,
        updateTime: '',
      }
    },
  },
  getters: {},
})

export default useUserStore
