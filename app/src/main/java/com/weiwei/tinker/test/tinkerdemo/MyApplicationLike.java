package com.weiwei.tinker.test.tinkerdemo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.entry.DefaultApplicationLike;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * @creater weiwei
 * @date 2018/11/13
 */
@DefaultLifeCycle(
        application = ".MyApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL
)
public class MyApplicationLike extends DefaultApplicationLike {
    public static Application application;
    public MyApplicationLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        MultiDex.install(base);
        MyApplicationLike.application = getApplication();
        //should set before tinker is installed
        TinkerManager.setUpgradeRetryEnable(true);
        TinkerManager.installedTinker(this);
    }

    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback){
        getApplication().registerActivityLifecycleCallbacks(callback);
    }
}
