import request from '@/api'
import { LoginForm } from 'src/types/login'
import { Response } from '@/types'
import { SysUser } from '@/types/user'

const login_request = async (data: LoginForm) =>
  await request.post<any, Response<{ token: string }>>('/auth/login', data)

const userInfo_request = async () =>
  await request.post<any, Response<SysUser>>('/auth/info')

const logout_request = async () => await request.post('/auth/logout')

export { login_request, userInfo_request, logout_request }
