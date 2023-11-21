import { RouteRecordRaw } from 'vue-router'
import localRouter from '@/router/local-router'
import config from '@/config'
import { Sidebar } from '@/types/router'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/login',
    component: () => import('@/views/login/LoginRegister.vue'),
    name: 'login',
    meta: {
      icon: 'none',
      label: '登录',
    },
  },
  {
    path: '/error',
    component: () => import('@/views/error/index.vue'),
    name: 'error',
    meta: {
      icon: 'none',
      label: '错误',
    },
  },
  {
    path: '/:pathMatch(.*)*',
    redirect: '/error',
    name: 'notFound',
  },
]

const buildSidebar = (
  route: RouteRecordRaw[] | undefined,
  sidebar: Sidebar[],
  basePath: string,
) => {
  if (route) {
    route.forEach((item) => {
      const { path, children, meta } = item
      const subSidebar: Sidebar[] = []
      const newBasePath = `${basePath}/${path}`
      if (children) {
        buildSidebar(children, subSidebar, newBasePath)
      }
      if (path) {
        sidebar.push({
          label: meta?.label || 'none',
          path: newBasePath,
          children: subSidebar,
          icon: meta?.icon || 'none',
        })
      }
    })
  }
  return sidebar
}

const getRouters = () => {
  if (config.router_type === 'local') {
    routes.push(localRouter)
    return routes
  } else {
    return []
  }
}

const getSidebar = () => buildSidebar(localRouter.children, [], '')

export { getRouters, getSidebar }
