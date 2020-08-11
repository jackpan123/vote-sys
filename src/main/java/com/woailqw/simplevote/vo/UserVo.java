package com.woailqw.simplevote.vo;

/**
 * user vo class
 */
public class UserVo {

    private String loginName;

    private String password;

    private String mobile;

    private String name;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserVo{" +
            "loginName='" + loginName + '\'' +
            ", password='" + password + '\'' +
            ", mobile='" + mobile + '\'' +
            ", name='" + name + '\'' +
            '}';
    }
}
