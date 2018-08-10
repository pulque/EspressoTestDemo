package com.lizheblogs.espressotestdemo.utils;

import android.support.test.espresso.ViewInteraction;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by LiZhe on 2018-08-10.
 * 获取View
 */
public abstract class FindViewUtils {

    protected ViewInteraction findView(int viewID) {
        return onView(allOf(withId(viewID), isDisplayed()));
    }

    protected ViewInteraction findView(int viewID, String text) {
        return onView(allOf(withId(viewID), withText(text), isDisplayed()));
    }

    protected ViewInteraction findView(int viewID, String text, int layoutID, int viewChildPosition, int layoutChildPosition) {
        return onView(
                allOf(withId(viewID), withText(text),
                        childAtPosition(
                                childAtPosition(
                                        withId(layoutID),
                                        viewChildPosition),
                                layoutChildPosition),
                        isDisplayed()));
    }

    protected <T> ViewInteraction findView(int viewID, String text, Class<T> layoutClass, int viewChildPosition, int layoutChildPosition) {
        return onView(
                allOf(withId(viewID), withText(text),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(layoutClass),
                                        viewChildPosition),
                                layoutChildPosition),
                        isDisplayed()));
    }

    protected ViewInteraction findView(int viewID, String text, String layoutClassName, int viewChildPosition, int layoutChildPosition) {
        return onView(
                Matchers.allOf(withId(viewID), withText(text),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is(layoutClassName)),
                                        viewChildPosition),
                                layoutChildPosition),
                        isDisplayed()));
    }

    protected ViewInteraction findView(int viewID, String layoutClassName, int viewChildPosition, int layoutChildPosition) {
        return onView(
                Matchers.allOf(withId(viewID),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is(layoutClassName)),
                                        viewChildPosition),
                                layoutChildPosition),
                        isDisplayed()));
    }

    protected ViewInteraction findView(int viewID, String text, int layoutID, String layoutClassName, int viewChildPosition, int layoutChildPosition) {
        return onView(
                allOf(withId(viewID), withText(text),
                        childAtPosition(
                                allOf(withId(layoutID),
                                        childAtPosition(
                                                withClassName(is(layoutClassName)),
                                                viewChildPosition)),
                                layoutChildPosition),
                        isDisplayed()));
    }

    protected Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
