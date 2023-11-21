<template>
  <el-icon :size="size" :color="color">
    <slot></slot>
  </el-icon>
</template>

<script setup lang="ts">
defineProps(['size', 'color'])
</script>
