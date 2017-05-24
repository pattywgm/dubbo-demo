package com.patty.dubbo.provider.serviceImpl;

import com.patty.dubbo.api.domain.UserVo;
import com.patty.dubbo.api.service.UserService;
import com.patty.dubbo.provider.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/5/23 下午5:55
 * Desc:
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserBaseService userBaseService;

    @Override
    public List<UserVo> findAllUsers() {
        return userBaseService.findAllUsers();
    }

    @Override
    public UserVo findUserById(String id) {
        return userBaseService.findUserById(id);
    }
}
