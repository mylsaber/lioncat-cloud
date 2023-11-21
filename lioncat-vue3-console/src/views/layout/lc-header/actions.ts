import { logout_request } from '@/api/login'
import useUserStore from '@/store/user'
import { REMOVE_TOKEN } from '@/utils/token'
import { Router } from 'vue-router'

const doLogout = async (router: Router) => {
  await logout_request()
  useUserStore().clearUserInfo()
  REMOVE_TOKEN()
  await router.push('/login')
}

export { doLogout }
