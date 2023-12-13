package com.mylsaber.console.auth.contorller;

import com.mylsaber.common.pojo.CommonResult;
import com.mylsaber.console.auth.params.LoginRequest;
import com.mylsaber.console.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangdi
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("login")
    public CommonResult<String> doLogin(@RequestBody @Validated LoginRequest loginRequest) {
        String token = authService.login(loginRequest.getAccount(), loginRequest.getPassword());
        return CommonResult.fastSuccess(token);
    }

    @PostMapping("register")
    public CommonResult<Boolean> doRegister(@RequestBody @Validated LoginRequest loginRequest) {
        boolean register = authService.register(loginRequest.getAccount(), loginRequest.getPassword());
        return CommonResult.fastSuccess(register);
    }
}
