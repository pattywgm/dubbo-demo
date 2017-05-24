package com.patty.dubbo.consumer.controller;

import com.patty.dubbo.api.domain.User;
import com.patty.dubbo.api.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/5/23 下午8:01
 * Desc:
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    private UserService userService;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public String getAllUsers() {
        StringBuilder users = new StringBuilder();
        for (User user : userService.findAllUsers()) {
            users.append(user.toString()+"\r\n");
        }
        return users.toString();
    }
}
