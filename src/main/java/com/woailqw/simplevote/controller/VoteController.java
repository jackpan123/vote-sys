package com.woailqw.simplevote.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
@CrossOrigin(origins = "*")
@RequestMapping(path = "/vote", produces = "application/json")
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
    @PostMapping(value = "/v1.0/increment", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedVO register(@RequestBody @Validated VoteIncrementDTO voteIncrement) {
        // Access current user ID.
        String userId = userService.getCurrentUser().getId();
        Vote vote = new Vote();
        BeanUtils.copyProperties(voteIncrement, vote);
        vote.prevInsert();
        vote.setUserId(userId);
        voteService.supplementalAttributes(vote, voteIncrement);
        if (voteMapper.save(vote) > 0) {
            return new CreatedVO(Code.SUCCESS.getCode(), Code.SUCCESS.getZhDescription());
        } else {
            return new CreatedVO(Code.SERVICE_IS_BUSY.getCode(), Code.SERVICE_IS_BUSY.getZhDescription());
        }
    }

    @ApiOperation("Vote Increment")
    @GetMapping(value = "/v1.0/center")
    public PageResponseVO<Vote> voteCenter(Integer page, Integer count) {
        int start = (page - 1) * count;
        return ResponseUtil.generatePageResult(voteMapper.countTotal(), voteMapper.list(start, count), page, count);
    }

    @ApiOperation("Vote Detail")
    @GetMapping(value = "/v1.0/voteDetail/{voteId}")
    public ResponseEntity<Vote> voteDetail(@PathVariable String voteId) {
        Vote vote = voteMapper.get(voteId);
        if (vote != null) {
            return new ResponseEntity<>(vote, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
