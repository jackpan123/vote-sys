package com.woailqw.simplevote.controller;

import com.google.gson.Gson;
import com.woailqw.simplevote.constant.Code;
import com.woailqw.simplevote.dao.VoteMapper;
import com.woailqw.simplevote.dto.VoteIncrementDTO;
import com.woailqw.simplevote.entity.Vote;
import com.woailqw.simplevote.service.UserService;
import com.woailqw.simplevote.service.VoteService;
import com.woailqw.simplevote.utils.ResponseUtil;
import com.woailqw.simplevote.vo.CreatedVO;
import com.woailqw.simplevote.vo.PageResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Vote controller.
 * 投票控制器.
 *
 * @author Jack Pan
 * @version 1.00 2020-08-16
 */
@Api("Vote Controller")
@RestController(value = "vote")
@CrossOrigin
public class VoteController {

    @Autowired
    private VoteMapper voteMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private VoteService voteService;

    /**
     * Create vote.
     *
     * @param voteIncrement
     * @return Result.
     */
    @ApiOperation("Vote Increment")
    @PostMapping(value = "vote/v1.0/increment")
    public CreatedVO register(@RequestBody @Validated VoteIncrementDTO voteIncrement) {
        // Access current user ID.
        String userId = userService.getCurrentUser().getId();
        Vote vote = new Vote();
        BeanUtils.copyProperties(voteIncrement, vote);
        vote.prevInsert();
        vote.setUserId(userId);
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
        if (voteMapper.save(vote) > 0) {
            return new CreatedVO(Code.SUCCESS.getCode(), Code.SUCCESS.getZhDescription());
        } else {
            return new CreatedVO(Code.SERVICE_IS_BUSY.getCode(), Code.SERVICE_IS_BUSY.getZhDescription());
        }
    }

    @ApiOperation("Vote Increment")
    @GetMapping(value = "vote/v1.0/center")
    public PageResponseVO<Vote> voteCenter(Integer page, Integer count) {

        return ResponseUtil.generatePageResult(2,voteMapper.list(page, count) , page, count);
    }
}
