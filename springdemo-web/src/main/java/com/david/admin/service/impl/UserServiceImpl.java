package com.david.admin.service.impl;

import com.david.admin.mapper.UserMapper;
import com.david.admin.model.User;
import com.david.admin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by GW on 2019/7/1.
 */
@Service
public class UserServiceImpl implements UserService {
        @Resource
        private UserMapper userMapper;

        @Override
        public User getUserByUsername(String username) {
                User user = userMapper.getUserByUsername(username);

                return user;
        }
}
