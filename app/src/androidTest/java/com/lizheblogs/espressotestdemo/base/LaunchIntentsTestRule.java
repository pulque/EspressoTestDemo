package com.lizheblogs.espressotestdemo.base;

import android.app.Activity;
import android.support.test.espresso.intent.rule.IntentsTestRule;

/**
 * Created by LiZhe on 2018-08-10.
 * 测试规则接口话页面启动调用方法
 */
public class LaunchIntentsTestRule<T extends Activity> extends IntentsTestRule<T> {

    private ActivityLaunchInterface launchInterface;

    public LaunchIntentsTestRule(Class<T> activityClass, ActivityLaunchInterface launchInterface) {
        super(activityClass, false, false);
        this.launchInterface = launchInterface;
    }

    @Override
    protected void beforeActivityLaunched() {
        super.beforeActivityLaunched();
        launchInterface.beforeActivityLaunched();
    }

    @Override
    protected void afterActivityLaunched() {
        super.afterActivityLaunched();
        launchInterface.afterActivityLaunched();
    }

    @Override
    protected void afterActivityFinished() {
        super.afterActivityFinished();
        launchInterface.afterActivityFinished();
    }


}
