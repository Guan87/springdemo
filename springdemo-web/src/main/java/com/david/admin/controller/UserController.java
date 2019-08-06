package com.david.admin.controller;

import com.david.Util.ResponseResult;
import com.david.admin.controller.dto.UserDto;
import com.david.admin.model.User;
import com.david.admin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by GW on 2019/7/1.
 */
@Controller
@RequestMapping("user/")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody//使用@RequestMapping，返回值通常解析为跳转路径，但是加上 @ResponseBody 后返回结果不会被解析为跳转路径，而是直接写入 HTTP response body 中。 比如异步获取 json 数据，加上 @ResponseBody 后，会直接返回 json 数据
    public ResponseResult login(@RequestBody UserDto userDto){
       User user1 =  userService.getUserByUsername(userDto.getUsername());
       if(user1 != null && user1.getPassword() !=null && userDto.getPassword().equals(user1.getPassword()) ){
           return ResponseResult.ok(user1);
       }else {
           return ResponseResult.fail("用户名或密码错误");

       }

    }

}
