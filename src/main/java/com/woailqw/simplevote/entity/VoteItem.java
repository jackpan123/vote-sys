package com.woailqw.simplevote.entity;

import lombok.Data;

/**
 * @author jackpan
 * @version v1.0 2021/7/7 13:18
 */
@Data
public class VoteItem extends BaseEntity {

    String userId;

    String voteId;

    String voteItemId;

    public static VoteItem getInstance(String userId,
        String voteId, String voteItemId) {
        VoteItem voteItem = new VoteItem();
        voteItem.prevInsert();
        voteItem.setUserId(userId);
        voteItem.setVoteId(voteId);
        voteItem.setVoteItemId(voteItemId);
        return voteItem;
    }
}
