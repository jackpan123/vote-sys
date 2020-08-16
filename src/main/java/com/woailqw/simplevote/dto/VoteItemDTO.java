package com.woailqw.simplevote.dto;

/**
 * Vote item DTO
 *
 * @author Jack Pan
 * @version 1.00 2020-08-16
 */
public class VoteItemDTO {

    private Integer id;

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
