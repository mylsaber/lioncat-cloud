package com.mylsaber.console.sys.service;

import com.mylsaber.console.sys.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author mylsaber
 * @since 2023-11-22
 */
public interface ISysUserService extends IService<SysUser> {
    boolean hasAccount(String account);
}
