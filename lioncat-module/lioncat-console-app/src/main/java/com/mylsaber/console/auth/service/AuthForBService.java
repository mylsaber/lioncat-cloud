package com.mylsaber.console.auth.service;

import com.mylsaber.console.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthForBService {

    @Autowired
    private ISysUserService sysUserService;

    public String login(String username, String password) {
        return "";
    }
}
