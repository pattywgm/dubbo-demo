package com.patty.dubbo.provider.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/5/23 下午5:26
 * Desc: User Entity对象
 */

public class User implements Serializable {
    private  String wId;
    private  String name;

    @Min(10)
    @Max(30)
    private  int age;

    @NotNull
    private  String phoneNo;

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

    public User(){

    }

    public User(String wId, String name, int age, String phoneNo) {
        this.wId = wId;
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return (String.format("UserVo info: name-> %s, age -> %d, phoneNo -> %s",
                this.name, this.age, this.phoneNo));
    }
}
