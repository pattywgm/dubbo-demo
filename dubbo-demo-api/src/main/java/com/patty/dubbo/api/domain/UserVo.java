package com.patty.dubbo.api.domain;

import java.io.Serializable;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/5/23 下午5:26
 * Desc: UserVo Domain, Provider 提供给 Consumer 的User对象视图
 */

public class UserVo implements Serializable {
    private final String wId;
    private final String name;
    private final int age;
    private final String phoneNo;

    public int getAge() {
        return age;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getwId() {
        return wId;
    }

    public String getName() {
        return name;
    }


    public UserVo(String wId, String name, int age, String phoneNo) {
        this.wId = wId;
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
    }


    public String toString() {
        return (String.format("UserVo info: name-> %s, age -> %d, phoneNo -> %s",
                this.name, this.age, this.phoneNo));
    }
}
