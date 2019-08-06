package com.david.admin.controller.dto;

/**
 * Created by GW on 2019/7/4.
 * 登陆接口接收参数dto
 */

public class UserDto {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
