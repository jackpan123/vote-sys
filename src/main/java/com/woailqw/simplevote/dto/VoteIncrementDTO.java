package com.woailqw.simplevote.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Create vote.
 *
 * @author Jack Pan
 * @version 1.00 2020-08-16
 */
public class VoteIncrementDTO {


    private String voteTitle;

    private List<VoteItemDTO> voteItemList;

    private String multiChoice;

    @JsonFormat(timezone="GMT+8")
    private LocalDateTime voteEnd;

    private String anonymous;

    /**
     * Gets voteTitle.
     *
     * @return Value of voteTitle.
     */
    public String getVoteTitle() {
        return this.voteTitle;
    }

    /**
     * Sets voteTitle.
     *
     * @param voteTitle Simple param.
     */
    public void setVoteTitle(String voteTitle) {
        this.voteTitle = voteTitle;
    }

    /**
     * Gets voteItemList.
     *
     * @return Value of voteItemList.
     */
    public List<VoteItemDTO> getVoteItemList() {
        return this.voteItemList;
    }

    /**
     * Sets voteItemList.
     *
     * @param voteItemList Simple param.
     */
    public void setVoteItemList(List<VoteItemDTO> voteItemList) {
        this.voteItemList = voteItemList;
    }

    /**
     * Gets multiChoice.
     *
     * @return Value of multiChoice.
     */
    public String getMultiChoice() {
        return this.multiChoice;
    }

    /**
     * Sets multiChoice.
     *
     * @param multiChoice Simple param.
     */
    public void setMultiChoice(String multiChoice) {
        this.multiChoice = multiChoice;
    }

    /**
     * Gets voteEnd.
     *
     * @return Value of voteEnd.
     */
    public LocalDateTime getVoteEnd() {
        return this.voteEnd;
    }

    /**
     * Sets voteEnd.
     *
     * @param voteEnd Simple param.
     */
    public void setVoteEnd(LocalDateTime voteEnd) {
        this.voteEnd = voteEnd;
    }

    /**
     * Gets anonymous.
     *
     * @return Value of anonymous.
     */
    public String getAnonymous() {
        return this.anonymous;
    }

    /**
     * Sets anonymous.
     *
     * @param anonymous Simple param.
     */
    public void setAnonymous(String anonymous) {
        this.anonymous = anonymous;
    }
}
