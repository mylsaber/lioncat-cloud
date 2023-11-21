import { SysUser } from '@/types/user'

interface LoginForm {
  username: string
  password: string
}

interface RegistryForm extends LoginForm {
  confirmpw: string
  email: string
}

interface UserStore {
  userInfo: SysUser
}

export type { LoginForm, RegistryForm, UserStore }
