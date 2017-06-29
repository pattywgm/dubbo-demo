package com.patty.dubbo.consumer.event;

import org.springframework.stereotype.Service;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/6/29 下午11:07
 * Desc:
 */
@Service("notifyImpl")
public class NotifyImpl implements Notify {
    @Override
    public void onreturn(Object res, Object... args) {
        System.out.println("onreturn:" + res.toString());

    }

    @Override
    public void onthrow(Throwable ex, Object... args) {

        System.out.println("onthrow: " + ex.getMessage());
    }

    @Override
    public void oninvoke(Object... args) {
        System.out.println("oninvoke: " + args[0]);
    }
}
