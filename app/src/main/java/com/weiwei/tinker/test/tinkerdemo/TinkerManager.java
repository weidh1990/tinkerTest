package com.weiwei.tinker.test.tinkerdemo;

import android.content.Context;

import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.lib.util.UpgradePatchRetry;

/**
 * @creater weiwei
 * @date 2018/11/14
 * tinker管理类
 */
public class TinkerManager {
    private static boolean isInstalled = false;//是否已经初始化标志位
    private static ApplicationLike mApplicationLike;

    /**
     * 完成Tinker初始化
     *
     * @param applicationLike
     */
    public static void installedTinker(ApplicationLike applicationLike) {
        mApplicationLike = applicationLike;
        if (isInstalled) {
            return;
        }
        TinkerInstaller.install(mApplicationLike);
        isInstalled = true;
    }

    /**
     * 完成patch文件的加载
     *
     * @param path 补丁文件路径
     */
    public static void loadPatch(String path) {
        if (Tinker.isTinkerInstalled()) {//是否已经安装过
            TinkerInstaller.onReceiveUpgradePatch(MyApplicationLike.application, path);
        }
    }

    /**
     * 添加重试机制
     *
     * @param enable 是否重试
     */
    public static void setUpgradeRetryEnable(boolean enable) {
        UpgradePatchRetry.getInstance(MyApplicationLike.application).setRetryEnable(enable);
    }

}
