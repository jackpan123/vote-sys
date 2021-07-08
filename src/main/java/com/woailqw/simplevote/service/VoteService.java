package com.woailqw.simplevote.service;

import com.google.gson.Gson;
import com.woailqw.simplevote.constant.VoteStatus;
import com.woailqw.simplevote.dao.VoteMapper;
import com.woailqw.simplevote.dto.VoteIncrementDTO;
import com.woailqw.simplevote.dto.VoteItemDTO;
import com.woailqw.simplevote.entity.Vote;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Vote Service.
 *
 * @author Jack Pan
 * @version 1.00 2020-08-29
 */
@Service
public class VoteService {

    @Autowired
    private VoteMapper voteMapper;


    /**
     * Map multi choice and anonymous.
     *
     * @param vote
     * @param voteIncrement
     */
    public void supplementalAttributes(Vote vote, VoteIncrementDTO voteIncrement) {
        if (Boolean.TRUE.equals(voteIncrement.getAnonymous())) {
            vote.setAnonymous("1");
        } else {
            vote.setAnonymous("0");
        }

        if (Boolean.TRUE.equals(voteIncrement.getMultiChoice())) {
            vote.setMultiChoice("1");
        } else {
            vote.setMultiChoice("0");
        }
        vote.setVoteStatus("1");
        vote.setVoteItem(new Gson().toJson(voteIncrement.getVoteItemList()));
    }

    public void updateVoteStatus(List<Vote> list) {
        LocalDateTime now = LocalDateTime.now();
        for (Vote vote : list) {
            if (VoteStatus.STARTING.equals(vote.getVoteStatus())) {
                if (now.compareTo(vote.getVoteEnd()) > 0) {
                    vote.setVoteStatus(VoteStatus.END);
                    voteMapper.update(vote);
                }
            }
        }
    }
}
