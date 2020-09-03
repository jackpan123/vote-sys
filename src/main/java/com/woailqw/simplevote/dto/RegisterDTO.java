package com.woailqw.simplevote.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;

/**
 * Register DTO.
 * 注册数据传输对象.
 *
 * @author Jack Pan
 * @version 1.00 2020-08-15
 */
@Data
public class RegisterDTO {

    @NotBlank(message = "login name not null")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]+$", message = "登录名格式错误")
    @ApiModelProperty(value = "login name")
    private String loginName;

    @NotBlank(message = "password not null")
    @Pattern(regexp = "^[A-Za-z0-9_*&$#@]{6,22}$", message = "密码格式错误，6到22位")
    @ApiModelProperty(value = "password")
    private String password;

    @NotBlank(message = "mobile not null")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式错误")
    @ApiModelProperty(value = "mobile")
    private String mobile;

    @NotBlank(message = "name not null")
    @ApiModelProperty(value = "name")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{2,4}$", message = "仅支持2-4位中文名字")
    private String name;

}
