package com.woailqw.simplevote.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Vote item DTO
 *
 * @author Jack Pan
 * @version 1.00 2020-08-16
 */
public class VoteItemDTO {

    @NotNull(message = "投票项ID不为空")
    private Integer id;

    @NotBlank(message = "投票项内容不为空")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]+$", message = "仅支持中文英文数字")
    @Size(max = 15, message = "最多15个字符")
    private String itemContext;

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets id.
     *
     * @param id Simple param.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets itemContext.
     *
     * @return Value of itemContext.
     */
    public String getItemContext() {
        return this.itemContext;
    }

    /**
     * Sets itemContext.
     *
     * @param itemContext Simple param.
     */
    public void setItemContext(String itemContext) {
        this.itemContext = itemContext;
    }
}
