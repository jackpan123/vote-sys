package com.woailqw.simplevote.vo;

import lombok.Data;

/**
 * @author jackpan
 * @version v1.0 2021/7/8 23:16
 */
@Data
public class VoteItemResult {

    private Integer id;

    private String name;

    private Integer number = 0;


    public void incrementNumber() {
        this.number++;
    }
}
