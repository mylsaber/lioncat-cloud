import {
  add_user_request,
  del_user_request,
  list_user_request,
  update_user_request,
} from '@/api/user'
import { PageRequest } from '@/types'
import { SysUser } from '@/types/user'
import { ElNotification } from 'element-plus'

const doList = async (data: PageRequest) => await list_user_request(data)

const doAddUser = async (data: SysUser, call: () => void) => {
  add_user_request(data)
    .then((res) => {
      if (res.code === 200) {
        ElNotification({
          type: 'success',
          message: '新增成功',
        })
        call()
        return res
      } else {
        ElNotification({
          type: 'error',
          message: res.msg,
        })
        call()
        return Promise.reject(res.msg)
      }
    })
    .catch((error) => {
      ElNotification({
        type: 'error',
        message: error.msg,
      })
      call()
      return Promise.reject(error)
    })
}

const doDelUser = (id: number | undefined, call: () => void) => {
  if (id) {
    del_user_request(id)
      .then(() => {
        ElNotification({
          type: 'success',
          message: '删除成功',
        })
        call()
      })
      .catch((e) => {
        ElNotification({
          type: 'error',
          message: e.msg,
        })
      })
  } else {
    ElNotification({
      type: 'error',
      message: '选择行没有查找到ID',
    })
  }
}

const doUpdateUser = (data: SysUser, call: () => void) => {
  update_user_request(data)
    .then(() => {
      ElNotification({
        type: 'success',
        message: '修改成功',
      })
      call()
    })
    .catch((e) => {
      ElNotification({
        type: 'error',
        message: e.msg,
      })
    })
}

export { doList, doAddUser, doDelUser, doUpdateUser }
