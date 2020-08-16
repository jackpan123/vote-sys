package com.woailqw.simplevote.service;


import com.woailqw.simplevote.dao.UserMapper;
import com.woailqw.simplevote.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * User Service
 *
 * @author Jack Pan
 * @version
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * Get current user info.
     *
     * @return User info
     */
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userMapper.getUserByLoginName(auth.getName());
    }
}
