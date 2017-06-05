package com.patty.dubbo.api.service;

import com.patty.dubbo.api.domain.UserVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/6/5 下午4:24
 * Desc: 容错处理
 */
public class UserServiceMock implements UserService {
    /**
     * provider出现RpcException时,返回mock数据,进行容错处理
     *
     * @return
     */
    public List<UserVo> findAllUsers() {
        List<UserVo> userVos = new ArrayList<UserVo>();
        userVos.add(new UserVo("000001", "默认用户", 22, "***********"));
        return userVos;
    }

    public UserVo findUserById(String id) {
        return new UserVo("000001", "默认用户", 22, "***********");
    }
}
