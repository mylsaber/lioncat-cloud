<template>
  <div class="container-box w-screen h-screen">
    <div class="content-box">
      <div ref="formBoxDom" class="form-box">
        <div :class="{ hidden: formType === 0 }">
          <h1>注册</h1>
          <el-form
            :model="formData"
            ref="formRef"
            :rules="rules"
            :hide-required-asterisk="true"
          >
            <el-form-item prop="username">
              <el-input placeholder="用户名" v-model="formData.username" />
            </el-form-item>
            <el-form-item prop="email">
              <el-input placeholder="邮箱" v-model="formData.email" />
            </el-form-item>
            <el-form-item prop="password">
              <el-input
                type="password"
                placeholder="密码"
                v-model="formData.password"
              />
            </el-form-item>
            <el-form-item prop="confirmpw">
              <el-input
                type="password"
                placeholder="确认密码"
                class="form-input"
                v-model="formData.confirmpw"
              />
            </el-form-item>
            <el-form-item>
              <el-button>注册</el-button>
            </el-form-item>
          </el-form>
        </div>
        <div :class="{ hidden: formType !== 0 }">
          <h1>登录</h1>
          <el-form
            :model="formData"
            ref="formRef"
            :rules="rules"
            :hide-required-asterisk="true"
          >
            <el-form-item prop="username">
              <el-input placeholder="用户名" v-model="formData.username" />
            </el-form-item>
            <el-form-item prop="password">
              <el-input
                type="password"
                placeholder="密码"
                v-model="formData.password"
              />
            </el-form-item>
            <el-form-item>
              <el-button :loading="loading" @click="toLogin(formRef)">
                登录
              </el-button>
            </el-form-item>
          </el-form>
        </div>
      </div>

      <div class="con-box left">
        <p>已有账号</p>
        <el-button id="login" @click="changeForm(0)">去登录</el-button>
      </div>
      <div class="con-box right">
        <p>没有账号？</p>
        <el-button id="register" @click="changeForm(1)">去注册</el-button>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive } from 'vue'
import { RegistryForm } from 'src/types/login'
import { useRouter } from 'vue-router'
import { ElNotification } from 'element-plus'
import { FormInstance } from 'element-plus/lib/components/form/index.js'
import { doLogin } from '@/views/login/actions'

const router = useRouter()
const formType = ref(0)
const formBoxDom = ref()
const formRef = ref<FormInstance>()
const changeForm = (value: number) => {
  if (value === 0) {
    formBoxDom.value.style.transform = 'translateX(0%)'
  } else {
    formBoxDom.value.style.transform = 'translateX(80%)'
  }
  formType.value = value
}
let loading = ref(false)
const formData = reactive<RegistryForm>({
  username: 'mylsaber',
  password: '12345678',
  confirmpw: '',
  email: '',
})

const rules = {
  username: [
    {
      required: true,
      message: '请输入用户名',
      trigger: 'blur',
    },
  ],
  password: [
    {
      required: true,
      message: '请输入用户名',
      trigger: 'blur',
    },
  ],
}

const toLogin = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  await formEl.validate((valid, _fields) => {
    if (valid) {
      loading.value = true
      doLogin(formData)
        .then(() => {
          router.push('/')
          ElNotification({
            type: 'success',
            message: '登录成功',
          })
          loading.value = false
        })
        .catch((error) => {
          ElNotification({
            type: 'error',
            message: error,
          })
          loading.value = false
        })
    }
  })
}
</script>

<style scoped>
.container-box {
  /* 弹性布局 水平+垂直居中 */
  display: flex;
  justify-content: center;
  align-items: center;
  /* 渐变背景 */
  background: linear-gradient(200deg, #f3e7e9, #e3eeff);
}

.content-box {
  background-color: #fff;
  width: 650px;
  height: 415px;
  border-radius: 5px;
  /* 阴影 */
  box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.1);
  /* 相对定位 */
  position: relative;
}

.form-box {
  position: absolute;
  top: -10%;
  left: 5%;
  background-color: #d3b7d8;
  width: 320px;
  height: 500px;
  border-radius: 5px;
  box-shadow: 2px 0 10px rgba(0, 0, 0, 0.1);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 2;
  /* 动画过渡 加速后减速 */
  transition: 0.5s ease-in-out;
}

.form-box button {
  width: 100%;
  background-color: #f6f6f6;
  outline: none;
  border-radius: 8px;
  padding: 7px;
  color: #a262ad;
  letter-spacing: 2px;
  border: none;
  cursor: pointer;
}

.form-box button:hover {
  background-color: #a262ad;
  color: #f6f6f6;
  transition: background-color 0.5s ease;
}

h1 {
  text-align: center;
  margin-bottom: 25px;
  color: #fff;
  /* 字间距 */
  letter-spacing: 5px;
}

.con-box {
  width: 50%;
  /* 弹性布局 垂直排列 居中 */
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  /* 绝对定位 居中 */
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
}

.con-box.left {
  left: 2%;
}

.con-box.right {
  right: -2%;
}

.con-box p {
  font-size: 12px;
  letter-spacing: 2px;
  color: #8e9aaf;
  text-align: center;
}

.con-box button {
  margin-top: 3%;
  background-color: #fff;
  color: #a262ad;
  border: 1px solid #d3b7d8;
  padding: 6px 10px;
  border-radius: 5px;
  letter-spacing: 1px;
  outline: none;
  cursor: pointer;
}

.con-box button:hover {
  background-color: #d3b7d8;
  color: #fff;
}
</style>
