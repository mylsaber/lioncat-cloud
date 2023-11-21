<template>
  <div class="flex flex-justify-between flex-items-center">
    <div class="flex flex-justify-between flex-items-center">
      <el-image :src="homeIcon" fit="cover" class="home-icon" />
      <p class="font-size-5 font-500 m-l-5">LionCat后台</p>
    </div>
    <div class="flex flex-items-center m-r-10">
      <div class="m-r-5">
        <el-button @click="$emit('reflash')">
          <el-icon><Refresh /></el-icon>
        </el-button>
      </div>
      <div class="m-r-5">
        <el-button @click="fullScreen">
          <el-icon><FullScreen /></el-icon>
        </el-button>
      </div>
      <div class="m-r-5">
        <el-dropdown>
          <el-avatar shape="square" :src="avatar" alt="加载失败"></el-avatar>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item>用户信息</el-dropdown-item>
              <el-dropdown-item @click="toLogout">退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import homeIcon from '@/assets/images/lion.jpg'
import { useRouter } from 'vue-router'
import { doLogout } from '@/views/layout/lc-header/actions.ts'

defineEmits(['reflash'])
const router = useRouter()

const fullScreen = () => {
  let full = document.fullscreenElement
  if (!full) {
    document.documentElement.requestFullscreen()
  } else {
    document.exitFullscreen()
  }
}

const avatar =
  'https://gitee.com/mylsaber/pictures/raw/master/img/202311121714031.jpg'

const toLogout = () => {
  doLogout(router)
}
</script>

<style lang="scss" scoped>
.home-icon {
  height: $header_hegith;
  width: $header_hegith;
}
</style>
