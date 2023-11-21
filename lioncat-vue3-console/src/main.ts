// 引入element-plus
import { setupElementPlus } from '@/plugins/elementPlus'

// 路由
import { setupRouter } from './router'

// 引入状态管理
import { setupStore } from '@/store'

// 引入全局样式
import '@/styles/index.scss'

// 引入windi css
import '@/plugins/unocss'

// 引入路由鉴权
import '@/plugins/permission'

import { createApp } from 'vue'
import App from './App.vue'

// 创建实例
const setupAll = async () => {
  const app = createApp(App)

  setupElementPlus(app)

  setupStore(app)

  setupRouter(app)

  app.mount('#app')
}

setupAll()
