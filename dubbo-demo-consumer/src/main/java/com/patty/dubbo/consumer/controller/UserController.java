package com.patty.dubbo.consumer.controller;

import com.alibaba.dubbo.rpc.RpcContext;
import com.patty.dubbo.api.domain.UserVo;
import com.patty.dubbo.api.service.EatingService;
import com.patty.dubbo.api.service.ShoppingService;
import com.patty.dubbo.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    @Resource
    private ShoppingService shoppingService;

    @Resource
    private EatingService eatingService;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<UserVo> getAllUsers() {
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public UserVo getUser(@PathVariable("userId") String userId) {
        return userService.findUserById(userId);
    }

    @RequestMapping(value = "/doSomething", method = RequestMethod.GET)
    @ResponseBody
    public String doSomething() {
        shoppingService.shopping();
        Future<String> shoppingFuture = RpcContext.getContext().getFuture(); // 拿到调用的Future引用，当结果返回后，会被通知和设置到此Future。
        eatingService.eating();
        Future<String> eatingFuture = RpcContext.getContext().getFuture();
        try {
            String doSth1 = shoppingFuture.get();
            String doSth2 = eatingFuture.get();
            return "Doing: " + doSth1 + " " + doSth2;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return "Doing: ";
    }
}
