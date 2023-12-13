package com.mylsaber.console.auth.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mylsaber.common.exception.BaseException;
import com.mylsaber.console.sys.entity.SysUser;
import com.mylsaber.console.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author jiangdi
 */
@Service
public class AuthService {

    private ISysUserService sysUserService;

    @Autowired
    public void setSysUserService(ISysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    public String login(String account, String password) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getAccount, account)
                .eq(SysUser::getPassword, password);
        SysUser sysUser = sysUserService.getOne(wrapper);
        if (ObjectUtil.isNull(sysUser)) {
            throw new BaseException(400, "账号或密码错误");
        }
        StpUtil.login(sysUser.getId());
        return StpUtil.getTokenValue();
    }

    public boolean register(String account, String password) {
        if (sysUserService.hasAccount(account)) {
            throw new BaseException(400, "账号已存在");
        }
        LocalDateTime date = DateUtil.date().toLocalDateTime();
        SysUser sysUser = new SysUser();
        sysUser.setAccount(account);
        sysUser.setPassword(password);
        sysUser.setCreateUser(null);
        sysUser.setCreateTime(date);
        sysUser.setUpdateUser(null);
        sysUser.setUpdateTime(date);
        return sysUserService.save(sysUser);
    }

}
