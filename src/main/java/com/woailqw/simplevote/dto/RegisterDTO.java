package com.woailqw.simplevote.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Register DTO.
 * 注册数据传输对象.
 *
 * @author Jack Pan
 * @version 1.00 2020-08-15
 */
public class RegisterDTO {
    @NotBlank(message = "login name not null")
    @ApiModelProperty(value = "login name")
    private String loginName;

    @NotBlank(message = "password not null")
    @Pattern(regexp = "^[A-Za-z0-9_*&$#@]{6,22}$", message = "密码格式错误，6到22位")
    @ApiModelProperty(value = "password")
    private String password;

    @NotBlank(message = "password not null")
    @ApiModelProperty(value = "mobile")
    private String mobile;

    @NotBlank(message = "password not null")
    @ApiModelProperty(value = "name")
    private String name;

    /**
     * Gets loginName.
     *
     * @return Value of loginName.
     */
    public String getLoginName() {
        return this.loginName;
    }

    /**
     * Sets loginName.
     *
     * @param loginName Simple param.
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * Gets password.
     *
     * @return Value of password.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets password.
     *
     * @param password Simple param.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets mobile.
     *
     * @return Value of mobile.
     */
    public String getMobile() {
        return this.mobile;
    }

    /**
     * Sets mobile.
     *
     * @param mobile Simple param.
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets name.
     *
     * @param name Simple param.
     */
    public void setName(String name) {
        this.name = name;
    }
}
