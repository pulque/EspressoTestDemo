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
import static com.lizheblogs.espressotestdemo.utils.TestInitUtils.initServerAddress;

@LargeTest
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginActivityTest extends BaseActivityTest<LoginActivity> {

    public LoginActivityTest() {
        super(LoginActivity.class);
    }

    @Override
    public void beforeActivityLaunched() {
        super.beforeActivityLaunched();
        clearUserNameAndPassword();
        initServerAddress();
    }

//    @Test
//    public void login() {
//        findView(R.id.userNameET, "android.widget.LinearLayout", 0, 1)
//                .perform(replaceText("9527"), closeSoftKeyboard());
//
//        findView(R.id.passwordET, "android.widget.LinearLayout", 2, 1)
//                .perform(replaceText("123"), closeSoftKeyboard());
//
//        findView(R.id.loginTV, "登录", "android.widget.RelativeLayout", 2, 4)
//                .perform(click());
//
    //截获打开页面intent
//        intended(allOf(
//                hasComponent(MAIN_ACTIVITY),
//                toPackage(PACKAGE_NAME)));
//    }

    @Test
    public void demoSelectDialogTest() {
//        findView(R.id.demoLL).perform(click());
//
//        findListItemAndMatches("13000000000", 0);
//
//        findListItemAndMatches("13333333333", 1);
//
//        findListItemAndMatches("13666666666", 2);
//
//        findListItemAndMatches("13888888888", 3);
//
//        findListItemAndMatches("13999999999", 4).perform(click());
//
//        intended(AllOf.allOf(
//                hasComponent(MAIN_ACTIVITY),
//                toPackage(PACKAGE_NAME)));
    }

//    private ViewInteraction findListItemAndMatches(String s, int i) {
//        return findView(R.id.basicNameTV, s, R.id.dataLV, i, 0)
//                .check(matches(withText(s)));
//    }

}