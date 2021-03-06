package com.ruzhan.awaker.article;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.blankj.utilcode.util.Utils;
import com.crashlytics.android.Crashlytics;
import com.ruzhan.awaker.article.util.ConstantUtils;

import io.fabric.sdk.android.Fabric;

/**
 * Created by ruzhan on 2017/7/6.
 */

public class App extends android.app.Application {

    private static App INSTANCE;

    public static App get() {
        return INSTANCE;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;

        Utils.init(App.get());
        com.ruzhan.lion.App.setApp(this);

        if (ConstantUtils.isReleaseBuild()) {
            Fabric.with(this, new Crashlytics());
        }
    }
}
