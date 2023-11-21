<template>
  <div class="flex h-8 flex-items-center">
    <CustomIcon size="20" @click="$emit('isFold', !isCollapse)">
      <Fold v-if="isCollapse === false"></Fold>
      <Expand v-else></Expand>
    </CustomIcon>
    <div class="m-l-5">
      <el-breadcrumb
        :separator-icon="ArrowRight"
        class="h-8 line-height-8! relative"
      >
        <template v-for="item in $route.matched" :key="item.name">
          <el-breadcrumb-item
            :to="{ path: item.path }"
            v-if="item.path !== '/'"
          >
            <el-icon class="relative! top-1.5px">
              <component :is="item.meta.icon"></component>
            </el-icon>
            {{ item.meta.label }}
          </el-breadcrumb-item>
        </template>
      </el-breadcrumb>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { ArrowRight } from '@element-plus/icons-vue'
import CustomIcon from '@/component/custom-icon/index.vue'
defineProps(['isCollapse'])
defineEmits(['isFold'])
</script>
