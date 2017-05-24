package com.patty.dubbo.provider.service;

import org.springframework.stereotype.Service;
import com.patty.dubbo.api.domain.UserVo;
import com.patty.dubbo.provider.dao.UserDao;
import com.patty.dubbo.provider.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/5/23 下午5:55
 * Desc: Provider的UserBaseService层
 */
@Service
public class UserBaseService {

    @Autowired
    private UserDao userDao;

    /**
     * 查询所有用户
     *
     * @return
     */
    public List<UserVo> findAllUsers() {
        ArrayList<UserVo> userVoList = new ArrayList<UserVo>();
        for (User user : userDao.findAllUsers()) {
            userVoList.add(this.UserToUserVo(user));
        }
        return userVoList;
    }

    /**
     * 根据id查询指定用户
     *
     * @param id
     * @return
     */
    public UserVo findUserById(String id) {
        User user = userDao.findUserById(id);
        return this.UserToUserVo(user);
    }


    /**
     * 将User对象转换成UserVo对象,实现User对象的对外隐藏
     *
     * @param user
     * @return
     */
    private UserVo UserToUserVo(User user) {
        return new UserVo(user.getwId(), user.getName(), user.getAge(), user.getPhoneNo());
    }
}
