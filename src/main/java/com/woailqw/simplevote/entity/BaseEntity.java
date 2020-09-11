package com.woailqw.simplevote.entity;

import cn.hutool.core.lang.UUID;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * Base class.
 * @author Jack Pan
 * @version 1.0 2020-08-08
 */
@Data
public class BaseEntity {

    private static final String ADMIN_ID = "0";

    private static final String EXIST = "0";

    private String id;

    private String createBy;

    private LocalDateTime createDate;

    private String updateBy;

    private LocalDateTime updateDate;

    private String remarks;

    private String delFlag;

    public void prevInsert() {
        this.id = UUID.randomUUID().toString();
        this.createBy = ADMIN_ID;
        this.createDate = LocalDateTime.now();
        this.updateBy = ADMIN_ID;
        this.updateDate = LocalDateTime.now();
        this.delFlag = EXIST;
    }

    public void prevUpdate() {
        this.updateBy = ADMIN_ID;
        this.updateDate = LocalDateTime.now();
    }


}
