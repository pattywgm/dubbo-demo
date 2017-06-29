package com.patty.dubbo.consumer.event;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/6/29 下午11:01
 * Desc: 事件通知接口
 */
public interface Notify {
    /**
     *
     * @param res 返回值
     * @param args 入参
     */
    public void onreturn(Object res, Object... args);

    /**
     *
     * @param ex 异常对象
     * @param args 入参
     */
    public void onthrow(Throwable ex, Object... args);

    /**
     *
     * @param args 入参
     */
    public void oninvoke(Object... args);
}
