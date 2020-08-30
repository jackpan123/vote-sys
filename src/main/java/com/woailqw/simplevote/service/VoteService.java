package com.woailqw.simplevote.service;

import com.google.gson.Gson;
import com.woailqw.simplevote.dto.VoteIncrementDTO;
import com.woailqw.simplevote.dto.VoteItemDTO;
import com.woailqw.simplevote.entity.Vote;
import org.springframework.stereotype.Service;

/**
 * Vote Service.
 *
 * @author Jack Pan
 * @version 1.00 2020-08-29
 */
@Service
public class VoteService {

    /**
     * Map multi choice and anonymous.
     *
     * @param vote
     * @param voteIncrement
     */
    public void supplementalAttributes(Vote vote, VoteIncrementDTO voteIncrement) {
        if ("true".equals(voteIncrement.getAnonymous())) {
            vote.setAnonymous("1");
        } else {
            vote.setAnonymous("0");
        }

        if ("true".equals(voteIncrement.getMultiChoice())) {
            vote.setMultiChoice("1");
        } else {
            vote.setMultiChoice("0");
        }
        vote.setVoteItem(new Gson().toJson(voteIncrement.getVoteItemList()));
    }
}
