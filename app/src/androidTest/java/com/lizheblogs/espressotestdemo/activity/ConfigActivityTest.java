package com.lizheblogs.espressotestdemo.activity;


import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.lizheblogs.espressotestdemo.LoginActivity;
import com.lizheblogs.espressotestdemo.base.BaseActivityTest;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.provider.FontsContract.Columns.RESULT_CODE;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static com.lizheblogs.espressotestdemo.utils.TestInitUtils.clearServerAddress;

@LargeTest
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConfigActivityTest extends BaseActivityTest<LoginActivity> {

    public ConfigActivityTest() {
        super(LoginActivity.class);
    }

    @Override
    public void beforeActivityLaunched() {
        super.beforeActivityLaunched();
        clearServerAddress();
    }

    @Before
    public void stubCameraIntent() {
        Instrumentation.ActivityResult result = createCaptureActivityResultStub();
        // Stub the Intent.
        intending(hasComponent("activity的类名")).respondWith(result);
    }

    @Test
    public void scanTest() {
//        findView(R.id.scanBut, "扫描").perform(click());
//
//        checkAddressForEnter("456", "10.0.0.10:985", "4654655464");
    }

    @Test
    public void deleteTest() {

//        DataInteraction relativeLayout = onData(anything())
//                .inAdapterView(allOf(withId(R.id.dataLV),
//                        childAtPosition(
//                                withClassName(is("android.widget.FrameLayout")),
//                                0)))
//                .atPosition(0);
//        relativeLayout.perform(longClick());//长按
    }

    private void checkClearEnter() {
//        findView(R.id.nameET, "name", android.widget.LinearLayout.class, 0, 1)
//                .check(doesNotExist());
//
//        findView(R.id.addressET, "10.0.0.203", android.widget.LinearLayout.class, 1, 1)
//                .check(doesNotExist());
//
//        findView(R.id.portET, "1111", android.widget.LinearLayout.class, 2, 1)
//                .check(doesNotExist());
//
//        findView(R.id.passCardET, "18288888888", android.widget.LinearLayout.class, 3, 1)
//                .check(doesNotExist());
    }

    private void checkAddressForEnter(String name, String ip, String phoneNumber) {
//        findView(R.id.nameTV, name, R.id.item, 0, 1)
//                .check(matches(withText(name)));
//
//        findView(R.id.ipTV, ip, R.id.item, 1, 1)
//                .check(matches(withText(ip)));
//
//        findView(R.id.cardTV, phoneNumber, R.id.item, 2, 1)
//                .check(matches(withText(phoneNumber)));
    }

    private void enterAddressAndSave(String name, String ip, String port, String phoneNumber) {
//        findView(R.id.nameET, "android.widget.LinearLayout", 0, 1)
//                .perform(replaceText(name), closeSoftKeyboard());
//
//        findView(R.id.addressET, "android.widget.LinearLayout", 1, 1)
//                .perform(replaceText(ip), closeSoftKeyboard());
//
//        findView(R.id.portET, "android.widget.LinearLayout", 2, 1)
//                .perform(replaceText(port), closeSoftKeyboard());
//
//        findView(R.id.passCardET, "android.widget.LinearLayout", 3, 1)
//                .perform(replaceText(phoneNumber), closeSoftKeyboard());
//
//        findView(R.id.saveBut, "保存", R.id.bottom, "android.widget.LinearLayout", 2, 1)
//                .perform(click());
    }

    private Instrumentation.ActivityResult createCaptureActivityResultStub() {

        // Create the Intent that will include the bundle.
        Intent resultData = new Intent();
        resultData.putExtra(RESULT_CODE, "{\"name\":\"123\",\"ip\":\"10.0.0.10\",\"port\":985,\"credential\":\"13109168585\",\"params\":\"\"}");

        // Create the ActivityResult with the Intent.
        return new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
    }

}
