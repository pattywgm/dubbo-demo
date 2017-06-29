package com.patty.dubbo.provider.serviceImpl;

import com.patty.dubbo.api.domain.UserVo;
import com.patty.dubbo.api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/6/28 下午11:14
 * Desc: UserService的另一个实现类,用来测试同一接口多个实现的情况下,将服务进行分组group
 */
@Service("anotherUserService")
public class AnotherUserServiceImpl implements UserService {

    public AnotherUserServiceImpl(){

    }

    @Override
    public List<UserVo> findAllUsers() {
        ArrayList<UserVo> userVos = new ArrayList<UserVo>();
        userVos.add(new UserVo("10", "patty", 23, "13812931251"));
        userVos.add(new UserVo("11", "jack", 22, "18719092278"));
        return userVos;
    }

    @Override
    public UserVo findUserById(String id) {
        return new UserVo("15", "rose", 22, "17712013366");
    }
}
