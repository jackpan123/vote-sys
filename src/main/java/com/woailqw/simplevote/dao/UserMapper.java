package com.woailqw.simplevote.dao;

import com.woailqw.simplevote.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * User mapper.
 *
 * @author Jack Pan
 * @version 1.00 2020-08-10
 */
@Mapper
public interface UserMapper {

    int save(User user);
}
