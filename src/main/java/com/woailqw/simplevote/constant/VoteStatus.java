package com.woailqw.simplevote.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author jackpan
 * @version v1.0 2021/7/8 13:04
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VoteStatus {

    /**
     * 投票进行中
     */
    public static final String STARTING = "1";

    /**
     * 投票结束
     */
    public static final String END = "0";

}
