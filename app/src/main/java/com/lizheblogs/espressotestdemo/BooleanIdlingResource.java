/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lizheblogs.espressotestdemo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A very simple implementation of {@link IdlingResource}.
 * <p>
 * Consider using CountingIdlingResource from espresso-contrib package if you use this class from
 * multiple threads or need to keep a count of pending operations.
 */

public class BooleanIdlingResource implements IdlingResource {

    // The Idling Resource which will be null in production.
    @Nullable
    private static BooleanIdlingResource mIdlingResource;
    @Nullable
    private volatile ResourceCallback mCallback;

    // Idleness is controlled with this boolean.

    private AtomicBoolean mIsIdleNow = new AtomicBoolean(true);

    /**
     * Only called from test, creates and returns a new {@link BooleanIdlingResource}.
     */
    @VisibleForTesting
    @NonNull
    public static IdlingResource getIdlingResource() {
        mIdlingResource = new BooleanIdlingResource();
        return mIdlingResource;
    }

    /**
     * 耗时工作开始前调用
     */
    public static void IdlingStart() {
        // The IdlingResource is null in production.
        if (mIdlingResource != null) {
            mIdlingResource.setIdleState(false);
        }
    }

    /**
     * 耗时工作结束调用
     */
    public static void IdlingEnd() {
        // The IdlingResource is null in production.
        if (mIdlingResource != null) {
            mIdlingResource.setIdleState(true);
        }
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public boolean isIdleNow() {
        return mIsIdleNow.get();
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        mCallback = callback;
    }

    /**
     * Sets the new idle state, if isIdleNow is true, it pings the {@link ResourceCallback}.
     *
     * @param isIdleNow false if there are pending operations, true if idle.
     */
    private void setIdleState(boolean isIdleNow) {
        mIsIdleNow.set(isIdleNow);
        if (isIdleNow && mCallback != null) {
            mCallback.onTransitionToIdle();
        }
    }

}
