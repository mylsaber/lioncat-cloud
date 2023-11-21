import { defineConfig, loadEnv, ConfigEnv } from 'vite'
import vue from '@vitejs/plugin-vue'
import UnoCss from 'unocss/vite'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'
// import { viteMockServe } from 'vite-plugin-mock'
import path from 'path'

// https://vitejs.dev/config/
export default defineConfig(({ mode }: ConfigEnv) => {
  const env = loadEnv(mode, process.cwd())
  return {
    plugins: [
      vue(),
      UnoCss(),
      AutoImport({
        resolvers: [ElementPlusResolver()],
      }),
      Components({
        resolvers: [ElementPlusResolver()],
      }),
      // viteMockServe({
      //   enable: command === 'serve',
      //   mockPath: './mock',
      // }),
    ],
    resolve: {
      alias: {
        '@': path.resolve('./src'), // 相对路径别名配置，使用 @ 代替 src
      },
    },
    css: {
      preprocessorOptions: {
        scss: {
          javascriptEnabled: true,
          additionalData: '@import "./src/styles/variable.scss";',
        },
      },
    },
    server: {
      proxy: {
        [env.VITE_APP_BASE_API]: {
          target: env.VITE_APP_SERVER,
          changeOrigin: true,
          rewrite: (path) => path.replace(/^\/api-dev/, ''),
        },
      },
    },
  }
})
