<template>
  <div>
    <lc-simple-table
      :columns="columns"
      :data="tableData"
      :buttons="buttons"
      :pagination="pagination"
    >
      <el-table-column align="right">
        <template #header>
          <span>操作</span>
        </template>
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)">
            编辑
          </el-button>
          <el-button
            size="small"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
          >
            删除
          </el-button>
        </template>
      </el-table-column>
    </lc-simple-table>
  </div>
  <el-dialog
    v-model="dialogVisible"
    title="新增用户"
    :before-close="dialogBeforeClose"
  >
    <div class="m-r-17">
      <el-form
        :model="formdata"
        label-width="120px"
        ref="ruleFormRef"
        :rules="rules"
      >
        <el-form-item label="姓名" prop="userName">
          <el-input v-model="formdata.userName" />
        </el-form-item>
        <el-form-item label="密码" prop="password" v-if="dialogType === 'add'">
          <el-input v-model="formdata.password" />
        </el-form-item>
        <el-form-item label="头像地址" prop="avatar">
          <el-input v-model="formdata.avatar" />
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-radio-group v-model="formdata.gender">
            <el-radio :label="0">男</el-radio>
            <el-radio :label="1">女</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="电子邮箱" prop="email">
          <el-input v-model="formdata.email" />
        </el-form-item>
        <el-form-item label="手机号码" prop="phoneNumber">
          <el-input v-model="formdata.phoneNumber" />
        </el-form-item>
      </el-form>
    </div>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="resetForm(ruleFormRef)">取消</el-button>
        <el-button type="primary" @click="submitForm(ruleFormRef)">
          确认
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import LcSimpleTable from '@/component/lc-table/lc-simple-table/index.vue'
import { doList, doAddUser, doDelUser, doUpdateUser } from './actions'
import { PageRequest } from '@/types'
import { onMounted, reactive, ref } from 'vue'
import {
  Pagination,
  SimpleButton,
  SimpleColumn,
} from '@/types/component/table/simple-table'
import { ElNotification } from 'element-plus'
import { SysUser } from '@/types/user'
import type { FormInstance, FormRules } from 'element-plus'

// 生命周期：挂载时
onMounted(() => {
  getList()
})

// 编辑&新增弹窗
const dialogVisible = ref(false)
// 弹窗类型
let dialogType = ref('add')
// 关闭弹窗前回调
const dialogBeforeClose = (done: () => void) => {
  done()
}

// 弹窗表单数据
let formdata = reactive<SysUser>({
  userName: '',
  password: '',
  gender: 0,
  avatar: '',
  phoneNumber: '',
  email: '',
  status: 0,
  role: [],
  userType: 0,
  loginIp: '',
  loginDate: '',
  creator: 0,
  createTime: '',
  updater: 0,
  updateTime: '',
})

// 表单验证实例
const ruleFormRef = ref<FormInstance>()
// 表单验证规则
const rules = reactive<FormRules<SysUser>>({
  userName: [
    { required: true, message: '请输入用户名', trigger: 'blur' },
    { min: 2, max: 10, message: '限制2~10个字符', trigger: 'blur' },
  ],
  password: [
    { required: true, message: '请输入密码', trigger: 'blur' },
    { min: 8, max: 10, message: '限制8~32个字符', trigger: 'blur' },
  ],
  gender: [{ required: true, message: '请选择性别', trigger: 'change' }],
})
// 打开编辑弹窗
const handleEdit = (_index: number, row: SysUser) => {
  dialogType.value = 'update'
  dialogVisible.value = true
  formdata = row
}
// 删除一条数据
const handleDelete = (_index: number, row: SysUser) => {
  doDelUser(row.id, () => {
    getList()
  })
}
// 提交表单数据
const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {
      if (dialogType.value === 'add') {
        doAddUser(formdata, () => {
          formEl.resetFields()
          getList()
          dialogVisible.value = false
        })
      } else {
        doUpdateUser(formdata, () => {
          formEl.resetFields()
          getList()
          dialogVisible.value = false
        })
      }
    } else {
      console.log('error submit!', fields, formdata)
    }
  })
}
// 重置表单
const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
  dialogVisible.value = false
}

// 表格数据请求参数
const data = reactive<PageRequest>({
  page: 1,
  pageSize: 10,
})
// 表格行定义
const columns: SimpleColumn[] = [
  {
    type: 'selection',
  },
  {
    label: '姓名',
    prop: 'userName',
  },
  {
    label: '性别',
    prop: 'gender',
  },
  {
    label: '电子邮箱',
    prop: 'email',
  },
  {
    label: '手机号码',
    prop: 'phoneNumber',
  },
  {
    label: '上次登录IP',
    prop: 'loginIp',
  },
]
// 表格数据
const tableData: any = ref([])
const pagination = reactive<Pagination>({
  pageSize: 0,
  total: 0,
  currentPage: 0,
  layout: 'prev, pager, next, jumper, ->, total',
})
// 表格上按钮定义
const buttons: Array<SimpleButton> = [
  {
    label: '刷新',
    type: 'primary',
    fun: () => {
      getList()
    },
  },
  {
    label: '新增',
    type: 'primary',
    fun: () => {
      dialogType.value = 'add'
      dialogVisible.value = !dialogVisible.value
    },
  },
]
// 表格数据请求方法
const getList = () => {
  doList(data)
    .then((res) => {
      if (res.code === 200) {
        tableData.value = res.data.records
        pagination.total = res.data.total
        pagination.currentPage = res.data.current
        pagination.pageSize = res.data.size
      } else {
        ElNotification({
          type: 'error',
          message: '获取列表失败',
        })
      }
    })
    .catch(() => {
      ElNotification({
        type: 'error',
        message: '请求错误',
      })
    })
}
</script>
<style lang="scss" scoped>
.dialog-footer button:first-child {
  margin-right: 10px;
}
</style>
