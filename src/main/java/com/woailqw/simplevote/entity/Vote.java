package com.woailqw.simplevote.entity;


import java.time.LocalDateTime;

/**
 * Vote class.
 *
 * @author Jack Pan
 * @version 1.00 2020-08-16
 */
public class Vote extends BaseEntity {

    private String userId;

    private String voteTitle;

    private String voteItem;

    private String multiChoice;

    private LocalDateTime voteEnd;

    private String anonymous;

    /**
     * Gets userId.
     *
     * @return Value of userId.
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * Sets userId.
     *
     * @param userId Simple param.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

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
     * Gets voteItem.
     *
     * @return Value of voteItem.
     */
    public String getVoteItem() {
        return this.voteItem;
    }

    /**
     * Sets voteItem.
     *
     * @param voteItem Simple param.
     */
    public void setVoteItem(String voteItem) {
        this.voteItem = voteItem;
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
