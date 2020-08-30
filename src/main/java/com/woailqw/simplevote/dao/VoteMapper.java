package com.woailqw.simplevote.dao;

import com.woailqw.simplevote.entity.Vote;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * User mapper.
 *
 * @author Jack Pan
 * @version 1.00 2020-08-10
 */
@Mapper
public interface VoteMapper {

    /**
     * Save vote.
     *
     * @param vote Vote info.
     * @return Effect rows.
     */
    int save(Vote vote);

    /**
     * Vote list.
     *
     * @param page Page number
     * @param count Page size.
     * @return Vote list.
     */
    List<Vote> list(Integer page, Integer count);

    /**
     * Vote id.
     * @param voteId The vote id.
     * @return Vote.
     */
    Vote get(String voteId);
}
