package com.lizheblogs.espressotestdemo.activity;


import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.lizheblogs.espressotestdemo.LoginActivity;
import com.lizheblogs.espressotestdemo.base.BaseActivityTest;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static com.lizheblogs.espressotestdemo.utils.TestInitUtils.clearUserNameAndPassword;

@LargeTest
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WelcomeActivityTest extends BaseActivityTest<LoginActivity> {

    public WelcomeActivityTest() {
        super(LoginActivity.class);
    }

    @Override
    public void beforeActivityLaunched() {
        //此测试不需要初始化数据库等操作
        clearUserNameAndPassword();
    }

    @Test
    public void welcomeActivityTest() {
//        intended(allOf(
//                hasComponent(LOGIN_ACTIVITY),
//                toPackage(PACKAGE_NAME)));
    }
}
