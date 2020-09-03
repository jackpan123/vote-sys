package com.woailqw.simplevote.entity;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * user class
 *
 * @author Jack Pan
 * @version 1.0 2020-08-08
 */
@Data
public class User extends BaseEntity {

    private String loginName;

    private String password;

    private String mobile;

    private String name;

    private String userType;

    private String loginIp;

    private LocalDateTime loginDate;

    private String loginFlag;

    /**
     * Gets loginName.
     *
     * @return Value of loginName.
     */
//    public String getLoginName() {
//        return this.loginName;
//    }
//
//    /**
//     * Sets loginName.
//     *
//     * @param loginName Simple param.
//     */
//    public void setLoginName(String loginName) {
//        this.loginName = loginName;
//    }
//
//    /**
//     * Gets password.
//     *
//     * @return Value of password.
//     */
//    public String getPassword() {
//        return this.password;
//    }
//
//    /**
//     * Sets password.
//     *
//     * @param password Simple param.
//     */
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    /**
//     * Gets mobile.
//     *
//     * @return Value of mobile.
//     */
//    public String getMobile() {
//        return this.mobile;
//    }
//
//    /**
//     * Sets mobile.
//     *
//     * @param mobile Simple param.
//     */
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }
//
//    /**
//     * Gets name.
//     *
//     * @return Value of name.
//     */
//    public String getName() {
//        return this.name;
//    }
//
//    /**
//     * Sets name.
//     *
//     * @param name Simple param.
//     */
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    /**
//     * Gets userType.
//     *
//     * @return Value of userType.
//     */
//    public String getUserType() {
//        return this.userType;
//    }
//
//    /**
//     * Sets userType.
//     *
//     * @param userType Simple param.
//     */
//    public void setUserType(String userType) {
//        this.userType = userType;
//    }
//
//    /**
//     * Gets loginIp.
//     *
//     * @return Value of loginIp.
//     */
//    public String getLoginIp() {
//        return this.loginIp;
//    }
//
//    /**
//     * Sets loginIp.
//     *
//     * @param loginIp Simple param.
//     */
//    public void setLoginIp(String loginIp) {
//        this.loginIp = loginIp;
//    }
//
//    /**
//     * Gets loginDate.
//     *
//     * @return Value of loginDate.
//     */
//    public LocalDateTime getLoginDate() {
//        return this.loginDate;
//    }
//
//    /**
//     * Sets loginDate.
//     *
//     * @param loginDate Simple param.
//     */
//    public void setLoginDate(LocalDateTime loginDate) {
//        this.loginDate = loginDate;
//    }
//
//    /**
//     * Gets loginFlag.
//     *
//     * @return Value of loginFlag.
//     */
//    public String getLoginFlag() {
//        return this.loginFlag;
//    }
//
//    /**
//     * Sets loginFlag.
//     *
//     * @param loginFlag Simple param.
//     */
//    public void setLoginFlag(String loginFlag) {
//        this.loginFlag = loginFlag;
//    }
}
