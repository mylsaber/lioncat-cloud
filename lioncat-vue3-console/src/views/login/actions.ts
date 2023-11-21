import { login_request, userInfo_request } from '@/api/login'
import { RegistryForm } from 'src/types/login'
import useUserStore from '@/store/user'
import { SET_TOKEN } from '@/utils/token'

const doLogin = async (data: RegistryForm) => {
  const res = await login_request(data)
  if (res.code === 200) {
    SET_TOKEN(res.data.token)
    await doGetUserInfo()
    return res.msg
  } else {
    SET_TOKEN('')
    return Promise.reject(res.msg)
  }
}

const doGetUserInfo = async () => {
  const userStore = useUserStore()
  const info = await userInfo_request()
  userStore.userInfo = info.data
}

export { doLogin, doGetUserInfo }
