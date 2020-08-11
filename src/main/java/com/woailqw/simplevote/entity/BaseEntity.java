package com.woailqw.simplevote.entity;

import cn.hutool.core.lang.UUID;
import java.time.LocalDateTime;

/**
 * Base class.
 * @author Jack Pan
 * @version 1.0 2020-08-08
 */

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
