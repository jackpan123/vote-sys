package com.woailqw.simplevote.dao;

import com.woailqw.simplevote.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * User mapper.
 *
 * @author Jack Pan
 * @version 1.00 2020-08-10
 */
@Mapper
public interface UserMapper {

    /**
     * Save user.
     *
     * @param user User info
     * @return Effect rows
     */
    int save(User user);

    /**
     * User list.
     *
     * @return User list
     */
    List<User> list();

    User getUserByLoginName(String loginName);
}
