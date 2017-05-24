package com.patty.dubbo.provider.serviceImpl;

import com.patty.dubbo.api.domain.User;
import com.patty.dubbo.api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/5/23 下午5:55
 * Desc:
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public List<User> findAllUsers() {
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(0, new User("01", "patty"));
        userList.add(1, new User("02", "ZJM"));
        return userList;
    }

    @Override
    public User findUserById(String id) {
        return new User("01", "Patty");
    }
}
