package com.woailqw.simplevote.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Create vote.
 *
 * @author Jack Pan
 * @version 1.00 2020-08-16
 */
public class VoteIncrementDTO {


    @NotBlank(message = "投票主题不为空")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]+$", message = "仅支持中文英文数字")
    @Size(max = 200, message = "最多200个字符")
    private String voteTitle;

    @Valid
    @NotBlank(message = "投票项不为空")
    private List<VoteItemDTO> voteItemList;

    @NotBlank(message = "多选为必选项")
    private String multiChoice;

    @NotBlank(message = "截止时间为必选项")
    @JsonFormat(timezone="GMT+8")
    private LocalDateTime voteEnd;

    @NotBlank(message = "匿名为必选项")
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
