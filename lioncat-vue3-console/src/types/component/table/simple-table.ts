interface SimpleColumn {
  prop?: string
  label?: string
  type?: 'selection'
  width?: string
}
interface SimpleData {
  [propName: string]: any
}

interface SimpleButton {
  label: string
  type: 'primary' | 'success' | 'warning' | 'danger' | 'info'
  fun: any
}

interface Pagination {
  pageSize: number
  total: number
  currentPage: number
  layout: string
}

export type { SimpleButton, SimpleColumn, SimpleData, Pagination }
