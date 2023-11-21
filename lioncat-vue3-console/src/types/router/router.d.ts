import 'vue-router'

declare module 'vue-router' {
  interface RouteMeta {
    label: string
    icon: string
    color?: string
    hidden?: boolean
  }

  interface _RouteRecordBase {}
}
