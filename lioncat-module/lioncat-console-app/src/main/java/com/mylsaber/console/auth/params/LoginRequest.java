package com.mylsaber.console.auth.params;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

/**
 * @author jiangdi
 */
@Getter
@Setter
public class LoginRequest {
    @NotBlank(message = "账号不能为空")
    @Length(min = 2, max = 10, message = "账号长度为2~10个字符")
    private String account;


    @NotBlank(message = "密码不能为空")
    @Length(min = 2, max = 20, message = "密码长度为2~10个字符")
    private String password;
}
