<template>
  <template v-for="item in data" :key="item.label">
    <el-sub-menu v-if="item.children.length" :index="item.path">
      <template #title>
        <el-icon><component :is="item.icon" /></el-icon>
        <span>{{ item.label }}</span>
      </template>
      <lc-menu :data="item.children"></lc-menu>
    </el-sub-menu>
    <el-menu-item v-else :index="item.path">
      <el-icon><component :is="item.icon" /></el-icon>
      <template #title>{{ item.label }}</template>
    </el-menu-item>
  </template>
</template>

<script lang="ts" setup>
defineProps(['data'])
</script>
