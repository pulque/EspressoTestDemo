package com.lizheblogs.espressotestdemo.base;


import android.app.Activity;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.lizheblogs.espressotestdemo.BooleanIdlingResource;
import com.lizheblogs.espressotestdemo.utils.FindViewUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.concurrent.TimeUnit;

/**
 * 获取Context
 * Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//测试按方法名称排序执行
public abstract class BaseActivityTest<T extends Activity> extends FindViewUtils implements ActivityLaunchInterface {

    @Rule
    public IntentsTestRule<T> mActivityTestRule;
    private IdlingResource mIdlingResource;

    public BaseActivityTest(Class<T> activityClass) {
        this.mActivityTestRule = new LaunchIntentsTestRule<>(activityClass, this);
    }

    public void beforeActivityLaunched() {
        //启动Activity前，初始化需要的数据/对象等
    }

    public void afterActivityLaunched() {
    }

    public void afterActivityFinished() {
    }


    @Before
    public void registerIdlingResource() {
        //设置等待超时时间
        IdlingPolicies.setMasterPolicyTimeout(60 * 1000 * 3, TimeUnit.MILLISECONDS);
        IdlingPolicies.setIdlingResourceTimeout(60 * 1000 * 3, TimeUnit.MILLISECONDS);
        //初始化，并注册等待
        mIdlingResource = BooleanIdlingResource.getIdlingResource();
        // To prove that the test fails, omit this call:
        IdlingRegistry.getInstance().register(mIdlingResource);
        //启动Activity
        mActivityTestRule.launchActivity(null);
    }

    @After
    public void unregisterIdlingResource() {
        //反注册
        if (mIdlingResource != null) {
            IdlingRegistry.getInstance().unregister(mIdlingResource);
        }
    }

}
