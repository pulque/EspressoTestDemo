package com.lizheblogs.espressotestdemo.base;

/**
 * Created by LiZhe on 2018-08-10.
 * 页面启动调用接口
 */
public interface ActivityLaunchInterface {

    void beforeActivityLaunched();

    void afterActivityLaunched();

    void afterActivityFinished();
}
