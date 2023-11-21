import request from '@/api'
import { PageRequest, PageResponse, Response } from '@/types'
import { SysUser } from '@/types/user'

const list_user_request = async (data: PageRequest) =>
  await request.post<any, PageResponse<SysUser>>('/system/sysUser/list', data)

const add_user_request = async (data: SysUser) => {
  delete data.id
  return await request.post<any, Response<boolean>>('/system/sysUser/add', data)
}

const del_user_request = async (id: number) =>
  await request.post<any, Response<boolean>>(`/system/sysUser/del/${id}`)

const update_user_request = async (data: SysUser) => {
  delete data.password
  return await request.post<any, Response<boolean>>(
    `/system/sysUser/update/${data.id}`,
    data,
  )
}

const get_user_request = async (id: number) =>
  await request.post<any, Response<SysUser>>(`/system/sysUser/get/${id}`)

export {
  list_user_request,
  add_user_request,
  del_user_request,
  update_user_request,
  get_user_request,
}
