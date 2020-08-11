package com.woailqw.simplevote.controller;


import com.woailqw.simplevote.dao.UserMapper;
import com.woailqw.simplevote.entity.User;
import com.woailqw.simplevote.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The User Controller.
 *
 * @author Jack Pan
 * @version 1.00 2020-08-07
 */
@Api("User Controller")
@RestController(value = "user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation("Register")
    @PutMapping(value = "user/v1.0/register")
    public void register(@RequestBody UserVo userInfo) {
//        User user = new User();
//        BeanUtils.copyProperties(userInfo, user);
//        user.prevInsert();
        User list = userMapper.list();
    }

}
