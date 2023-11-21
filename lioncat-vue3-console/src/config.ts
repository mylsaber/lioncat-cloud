const APP_CONFIG: configuration = {
  router_type: 'local',
  document_title: 'LionCat后台管理',
}

type configuration = {
  router_type: 'local' | 'net'
  document_title: string
}

export default APP_CONFIG
