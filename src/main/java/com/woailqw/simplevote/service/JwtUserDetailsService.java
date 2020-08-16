package com.woailqw.simplevote.service;

import com.woailqw.simplevote.dao.UserMapper;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Validate token utils.
 *
 * @author Jack Pan.
 * @version 1.00 2020-08-16
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    /**
     * User cache map.
     */
    protected static final Map<String, com.woailqw.simplevote.entity.User> USER_MAP = new ConcurrentHashMap<>();

    @Autowired
    private UserMapper userMapper;

    /**
     * Load exist user into cache.
     */
    @PostConstruct
    public void init() {
        List<com.woailqw.simplevote.entity.User> list = userMapper.list();
        for (com.woailqw.simplevote.entity.User user : list) {
            USER_MAP.put(user.getLoginName(), user);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.woailqw.simplevote.entity.User user = USER_MAP.get(username);
        if (user != null) {
            return new User(user.getLoginName(), user.getPassword(),
                new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
