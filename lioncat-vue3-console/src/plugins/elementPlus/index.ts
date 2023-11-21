import type { App } from 'vue'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
// eslint-disable-next-line @typescript-eslint/no-unused-vars
//@ts-expect-error忽略当前文件ts类型的检测否则有红色提示(打包会失败)
import zhCn from 'element-plus/dist/locale/zh-cn.mjs'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

export const setupElementPlus = (app: App<Element>) => {
  app.use(ElementPlus, {
    locale: zhCn,
  })

  for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
  }
}
