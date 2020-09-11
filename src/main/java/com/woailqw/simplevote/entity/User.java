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
}
