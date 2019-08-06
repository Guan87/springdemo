package com.david.admin.service;

import com.david.admin.model.User;

import java.util.List;

/**
 * Created by GW on 2019/7/1.
 */
public interface UserService {
    User getUserByUsername(String username);
}
