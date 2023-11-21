<template>
  <div v-if="buttons">
    <el-button
      v-for="({ label, type, fun }, index) in buttons"
      :key="index"
      :type="type"
      @click="fun"
    >
      {{ label }}
    </el-button>
  </div>
  <br v-if="buttons" />
  <el-table :data="data" stripe style="width: 100%">
    <el-table-column
      v-for="({ prop, label, width, type }, index) in columns"
      :key="index"
      :prop="prop"
      :label="label"
      :width="width"
      :type="type"
    />
    <slot></slot>
  </el-table>
  <br />
  <el-pagination
    background
    :total="pagination.total"
    :page-size="pagination.pageSize"
    v-model:current-page="pagination.currentPage"
  />
</template>

<script lang="ts" setup>
import {
  SimpleButton,
  SimpleColumn,
  SimpleData,
  Pagination,
} from '@/types/component/table/simple-table'

defineProps<{
  data: Array<SimpleData>
  columns: Array<SimpleColumn>
  buttons: Array<SimpleButton>
  pagination: Pagination
}>()
</script>
