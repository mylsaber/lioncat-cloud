package com.mylsaber.console.auth.contorller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.mylsaber.common.exception.BaseException;
import com.mylsaber.common.pojo.CommonResult;
import com.mylsaber.console.auth.service.AuthForBService;
import com.mylsaber.console.auth.params.LoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/b")
@Slf4j
public class AuthForBController {

  private AuthForBService authForBService;

  @Autowired
  public void setAuthForBService(AuthForBService authForBService) {
    this.authForBService = authForBService;
  }

  @PostMapping("login")
  public CommonResult<String> doLogin(@Validated @RequestBody LoginRequest loginRequest) {
    try {
      String token = authForBService.login(loginRequest.getUsername(), loginRequest.getPassword());
      if (StrUtil.isBlank(token)) {
        log.error("登录失败");
        return CommonResult.getFail(null);
      }
      return CommonResult.getSuccess(token);
    } catch (Exception e) {
      throw new BaseException();
    }
  }

  @RequestMapping("isLogin")
  public String isLogin() {
    return "当前会话是否登录：" + StpUtil.isLogin();
  }
}
