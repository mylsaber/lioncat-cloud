import { RouteRecordRaw } from 'vue-router'

const localRouter: RouteRecordRaw = {
  path: '/',
  component: () => import('@/views/layout/index.vue'),
  name: 'layout',
  redirect: '/home',
  children: [
    {
      path: 'home',
      component: () => import('@/views/home/index.vue'),
      name: 'home',
      meta: {
        icon: 'HomeFilled',
        label: '首页',
      },
    },
    {
      path: 'access',
      name: 'access',
      meta: {
        icon: 'Lock',
        label: '权限管理',
      },
      redirect: '/access/user',
      children: [
        {
          path: 'user',
          component: () => import('@/views/access/user/index.vue'),
          name: 'user',
          meta: {
            icon: 'User',
            label: '用户管理',
          },
        },
        {
          path: 'role',
          component: () => import('@/views/access/role/index.vue'),
          name: 'role',
          meta: {
            icon: 'UserFilled',
            label: '角色管理',
          },
        },
        {
          path: 'menu',
          component: () => import('@/views/access/menu/index.vue'),
          name: 'menu',
          meta: {
            icon: 'Menu',
            label: '菜单管理',
          },
        },
      ],
    },
    {
      path: 'blog',
      name: 'blog',
      meta: {
        icon: 'Document',
        label: '博客管理',
      },
      redirect: '/blog/article',
      children: [
        {
          path: 'article',
          component: () => import('@/views/blog/article/index.vue'),
          name: 'article',
          meta: {
            icon: 'Document',
            label: '文章管理',
          },
        },
        {
          path: 'category',
          component: () => import('@/views/blog/category/index.vue'),
          name: 'category',
          meta: {
            icon: 'Files',
            label: '分类管理',
          },
        },
        {
          path: 'tag',
          component: () => import('@/views/blog/tag/index.vue'),
          name: 'tag',
          meta: {
            icon: 'Collection',
            label: '标签管理',
          },
        },
      ],
    },
  ],
}

export default localRouter
