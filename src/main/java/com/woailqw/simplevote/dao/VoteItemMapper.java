package com.woailqw.simplevote.dao;

import com.woailqw.simplevote.entity.Vote;
import com.woailqw.simplevote.entity.VoteItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author jackpan
 * @version v1.0 2021/7/5 14:22
 */
@Mapper
public interface VoteItemMapper {

    /**
     * Save vote.
     *
     * @param vote Vote info.
     * @return Effect rows.
     */
    int save(VoteItem voteItem);

    /**
     * 获取投票项
     * @param userId
     * @param voteId
     * @return
     */
    @Select(value = "SELECT COUNT(user_id) FROM vote_item_record WHERE user_id = #{userId} AND vote_id = #{voteId}")
    int getVoteItemByUserId(@Param("userId") String userId, @Param("voteId") String voteId);
}
