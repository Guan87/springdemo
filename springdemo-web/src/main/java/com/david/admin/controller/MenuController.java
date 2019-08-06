package com.david.admin.controller;

import com.david.admin.model.User;
import com.david.admin.service.MenuService;
import com.david.admin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by GW on 2019/7/1.
 */
@Controller
@RequestMapping("menu/")
public class MenuController {
    @Resource
    private MenuService menuService;



}
