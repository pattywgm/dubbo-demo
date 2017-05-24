package com.patty.dubbo.api.service;

import com.patty.dubbo.api.domain.UserVo;

import java.util.List;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/5/23 下午5:25
 * Desc: 用户服务公共接口
 */

public interface UserService {
    // 查询所有用户
    public List<UserVo> findAllUsers();

    // 根据id获取指定用户
    public UserVo findUserById(String id);
}
