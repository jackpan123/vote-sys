package com.woailqw.simplevote.controller;

import static com.woailqw.simplevote.constant.Code.VOTED;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.woailqw.simplevote.constant.Code;
import com.woailqw.simplevote.dao.VoteItemMapper;
import com.woailqw.simplevote.dao.VoteMapper;
import com.woailqw.simplevote.dto.VoteIncrementDTO;
import com.woailqw.simplevote.entity.Vote;
import com.woailqw.simplevote.entity.VoteItem;
import com.woailqw.simplevote.service.UserService;
import com.woailqw.simplevote.service.VoteItemService;
import com.woailqw.simplevote.service.VoteService;
import com.woailqw.simplevote.utils.ResponseUtil;
import com.woailqw.simplevote.vo.CreatedVO;
import com.woailqw.simplevote.vo.PageResponseVO;
import com.woailqw.simplevote.vo.SubmitVoteVo;
import com.woailqw.simplevote.vo.UnifyResponseVO;
import com.woailqw.simplevote.vo.VoteItemResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private VoteItemMapper voteItemMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private VoteService voteService;

    @Autowired
    private VoteItemService voteItemService;

    /**
     * Create vote.
     *
     * @param voteIncrement
     * @return Result.
     */
    @ApiOperation("Vote Increment")
    @PostMapping(value = "/v1.0/increment", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedVO increment(@RequestBody @Validated VoteIncrementDTO voteIncrement) {
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
        List<Vote> list = voteMapper.list(start, count);
        voteService.updateVoteStatus(list);
        return ResponseUtil.generatePageResult(voteMapper.countTotal(), list, page, count);
    }

    @ApiOperation("Vote Detail")
    @GetMapping(value = "/v1.0/voteDetail/{voteId}")
    public UnifyResponseVO voteDetail(@PathVariable String voteId) {
        Vote vote = voteMapper.get(voteId);
        // Access current user ID.
        String userId = userService.getCurrentUser().getId();
        if (vote == null) {
            return new UnifyResponseVO("该投票未找到", HttpStatus.NOT_FOUND);
        }
        boolean checkStatus = voteItemService.checkUserVoteStatus(vote, userId);
        if (checkStatus) {
            return new UnifyResponseVO(VOTED.getCode(), VOTED.getZhDescription(), HttpStatus.OK);
        }

        return new UnifyResponseVO<>(vote, HttpStatus.OK);
    }

    @ApiOperation("Submit Vote")
    @PostMapping(value = "/v1.0/submitVote/")
    public UnifyResponseVO submitVote(@RequestBody SubmitVoteVo vo) {
        // Access current user ID.
        String userId = userService.getCurrentUser().getId();
        VoteItem voteItem = VoteItem.getInstance(userId, vo.getVoteId(), vo.getVoteItemId());
        voteItemMapper.save(voteItem);
        return new UnifyResponseVO<>(voteItem, HttpStatus.OK);
    }

    @ApiOperation("Get Vote Items")
    @GetMapping(value = "/v1.0/getVoteItems/{voteId}")
    public UnifyResponseVO getVoteItems(@PathVariable String voteId) {
        Vote vote = voteMapper.get(voteId);
        String voteItem = vote.getVoteItem();
        JSONArray itemJson = JSONArray.parseArray(voteItem);
        List<VoteItem> list = voteItemMapper.list();
        Map<Integer, VoteItemResult> resultMap = new HashMap<>();
        for (int i = 0; i < itemJson.size(); i++) {
            JSONObject jsonObject = itemJson.getJSONObject(i);
            Integer id = jsonObject.getInteger("id");
            String name = jsonObject.getString("itemContext");
            VoteItemResult result = new VoteItemResult();
            result.setId(id);
            result.setName(name);
            resultMap.put(id, result);
        }
        for (VoteItem item : list) {
            VoteItemResult result = resultMap.get(Integer.valueOf(item.getVoteItemId()));
            if (result != null) {
                result.incrementNumber();
            }
        }
        return new UnifyResponseVO<>(resultMap.values(), HttpStatus.OK);
    }
}
