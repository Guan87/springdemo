package com.david.admin.service.impl;

import com.david.admin.mapper.MenuMapper;
import com.david.admin.mapper.UserMapper;
import com.david.admin.service.MenuService;
import com.david.admin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by GW on 2019/7/1.
 */
@Service
public class MenuServiceImpl implements MenuService {
        @Resource
        private MenuMapper menuMapper;
}
