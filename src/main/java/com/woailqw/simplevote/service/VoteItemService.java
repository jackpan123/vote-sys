package com.woailqw.simplevote.service;

import com.woailqw.simplevote.dao.VoteItemMapper;
import com.woailqw.simplevote.entity.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jackpan
 * @version v1.0 2021/7/6 12:45
 */
@Service
public class VoteItemService {

    @Autowired
    private VoteItemMapper voteItemMapper;


    /**
     *
     * @param vote
     * @return
     */
    public boolean checkUserVoteStatus(Vote vote, String userId) {
        int itemNumber = voteItemMapper.getVoteItemByUserId(userId, vote.getId());
        return itemNumber > 0;
    }
}
