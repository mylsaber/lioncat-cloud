interface SysUser {
  id?: number

  /**
   * 用户名
   */
  userName: string

  /**
   * 用户类型
   */
  userType: number

  /**
   * 用户邮箱
   */
  email: string

  /**
   * 手机号码
   */
  phoneNumber: string

  /**
   * 用户性别
   */
  gender: number

  /**
   * 头像地址
   */
  avatar: string

  /**
   * 密码
   */
  password?: string

  /**
   * 帐号状态
   */
  status: number

  /**
   * 最后登录IP
   */
  loginIp: string

  /**
   * 最后登录时间
   */
  loginDate: string

  /**
   * 创建者
   */
  creator: number

  /**
   * 创建时间
   */
  createTime: string

  /**
   * 更新者
   */
  updater: number

  /**
   * 更新时间
   */
  updateTime: string

  /**
   * 角色列表
   */

  role: Array<string>
}

export type { SysUser }
