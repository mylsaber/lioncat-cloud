import { router } from '@/router'
// 导入进度条
import { start, close } from '@/utils/nporgress'
import { GET_TOKEN, REMOVE_TOKEN } from '@/utils/token'
import useUserStore from '@/store/user'
import { userInfo_request } from '@/api/login/index.ts'
import config from '@/config'
import { ElNotification } from 'element-plus'

router.beforeEach(async (to, _from, next) => {
  const token = GET_TOKEN()
  const userStore = useUserStore()
  const userInfo = userStore.userInfo
  if (token) {
    //登录用户
    if (to.path === '/login') {
      next({ path: '/' })
    } else {
      if (userInfo.userName !== '') {
        next()
      } else {
        try {
          const res = await userInfo_request()
          if (res.code === 200) {
            userStore.userInfo = res.data
            next()
          } else {
            // 清除遗留的token和用户信息
            REMOVE_TOKEN()
            userStore.clearUserInfo()
            ElNotification({
              type: 'error',
              message: '用户信息已过期',
            })
            next({ path: '/login' })
          }
        } catch (e) {
          // 清除遗留的token和用户信息
          REMOVE_TOKEN()
          userStore.clearUserInfo()
          next({ path: '/login' })
        }
      }
    }
  } else {
    // 清除遗留的token和用户信息
    REMOVE_TOKEN()
    userStore.clearUserInfo()
    // 未登录用户
    if (to.path === '/login') {
      next()
    } else {
      ElNotification({
        type: 'error',
        message: '登录已过期',
      })
      next({ path: '/login' })
    }
  }
  start()
})

// eslint-disable-next-line @typescript-eslint/no-unused-vars
router.afterEach((to, _from) => {
  document.title = `${config.document_title}-${to.meta.label}`
  close()
})
