<template>
  <div class="h-100%">
    <el-menu
      class="h-100%"
      :default-active="route.fullPath"
      :collapse="isCollapse"
      :router="true"
      background-color="#545c64"
      text-color="#fff"
    >
      <lc-menu :data="sidebar"></lc-menu>
    </el-menu>
  </div>
</template>

<script lang="ts" setup>
import { Sidebar } from '@/types/router'
import LcMenu from '@/views/layout/lc-sidebar/lc-menu.vue'
import { useRoute } from 'vue-router'
import { getSidebar } from '@/utils/router'

defineProps(['isCollapse'])

const sidebar: Sidebar[] = getSidebar()
const route = useRoute()
</script>

<style lang="scss" scoped></style>
