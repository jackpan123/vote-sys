package com.woailqw.simplevote.controller;


import com.woailqw.simplevote.constant.Code;
import com.woailqw.simplevote.dao.UserMapper;
import com.woailqw.simplevote.dto.RegisterDTO;
import com.woailqw.simplevote.entity.User;
import com.woailqw.simplevote.vo.CreatedVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
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

    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @Autowired
    private UserMapper userMapper;

    @ApiOperation("Register")
    @PutMapping(value = "user/v1.0/register")
    public CreatedVO register(@RequestBody @Validated RegisterDTO userInfo) {
        User user = new User();
        BeanUtils.copyProperties(userInfo, user);
        user.setPassword(ENCODER.encode(userInfo.getPassword()));
        user.prevInsert();
        int result = userMapper.save(user);
        if (result > 0) {
            return new CreatedVO(Code.SUCCESS.getCode(), Code.SUCCESS.getZhDescription());
        } else {
            return new CreatedVO(Code.SERVICE_IS_BUSY.getCode(), Code.SERVICE_IS_BUSY.getZhDescription());
        }

    }

}
