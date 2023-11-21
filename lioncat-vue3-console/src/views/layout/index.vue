<template>
  <div>
    <el-container class="w-screen h-screen">
      <el-header class="header">
        <lc-header @reflash="mainMount += 1" />
      </el-header>
      <el-container class="h-90%">
        <el-aside width="auto">
          <lc-sidebar :isCollapse="isCollapse" />
        </el-aside>
        <div class="w-100% m-l-5">
          <lc-breadcrumb :isCollapse="isCollapse" @isFold="isFold" />
          <div class="m-r-5 p-5">
            <router-view v-slot="{ Component }">
              <transition name="fade">
                <component :is="Component" :key="mainMount"></component>
              </transition>
            </router-view>
          </div>
        </div>
      </el-container>
    </el-container>
  </div>
</template>

<script setup lang="ts">
import LcHeader from '@/views/layout/lc-header/index.vue'
import LcSidebar from '@/views/layout/lc-sidebar/index.vue'
import LcBreadcrumb from '@/views/layout/lc-breadcrumb/index.vue'
import { ref } from 'vue'

const isCollapse = ref(false)
const isFold = (v: boolean) => {
  isCollapse.value = v
}
const mainMount = ref(1)
</script>

<style scoped lang="scss">
.header {
  height: $header_hegith;
}
.fade-enter-from {
  opacity: 0;
}

.fade-enter-active {
  transition: ease-in-out 1s;
}
.fade-enter-to {
  opacity: 1;
}
</style>
