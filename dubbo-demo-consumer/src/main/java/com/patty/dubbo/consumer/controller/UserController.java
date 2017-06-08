package com.patty.dubbo.consumer.controller;

import com.patty.dubbo.api.domain.UserVo;
import com.patty.dubbo.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    public List<UserVo> getAllUsers() {
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    @ResponseBody
    public UserVo getUser(@PathVariable("userId") String userId) {
        return userService.findUserById(userId);
    }
}
