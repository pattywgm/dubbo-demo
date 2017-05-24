package com.patty.dubbo.api.domain;

import java.io.Serializable;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/5/23 下午5:26
 * Desc: User Entity
 */

public class User implements Serializable {
    private final String wId;
    private final String name;

    public User(String wId, String name) {
        this.wId = wId;
        this.name = name;
    }

    public String getwId() {
        return wId;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return (String.format("User info: name-> %s", this.name));
    }
}
