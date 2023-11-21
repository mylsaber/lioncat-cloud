import type { App } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import { getRouters } from '@/utils/router'

export const router = createRouter({
  history: createWebHistory(),
  routes: getRouters(),
})

export const setupRouter = (app: App<Element>) => {
  app.use(router)
}
