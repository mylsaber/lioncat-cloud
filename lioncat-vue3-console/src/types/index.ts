interface Response<T> {
  code: number
  msg: string
  data: T
}

interface PageResponse<T> {
  code: number
  msg: string
  data: {
    records?: Array<T>
    total: number
    size: number
    current: number
    pages: number
  }
}
interface Request {
  data?: any
}
interface PageRequest extends Request {
  page: number
  pageSize: number
}

export type { PageResponse, Response, Request, PageRequest }
