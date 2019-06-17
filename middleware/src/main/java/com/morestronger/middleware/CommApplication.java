package com.morestronger.middleware;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.morestronger.middleware.lifecycles.IApplication;

import java.util.List;

/**
 * project ComponentDemo
 * author 王越强
 * describe 通用抽象 Application 对象实例.
 * date 2019/6/10
 * time 10:53
 */
public abstract class CommApplication extends Application {
    /**
     * 假单例,用于保存 Application 实例对象,在其他地方获取.
     */
    private static Application application;

    /**
     * 应用程序生命周期监听器.用于第三方根据生命周期处理相关逻辑.
     */
    private List<IApplication> applicationList;

    /**
     * 应用程序是否在后台 true 后台, false 前台.
     */
    private boolean isBackground = true;

    /**
     * 获取应用程序 Application 实例.
     *
     * @return 返回应用程序 Application 实例.
     */
    public static Application getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化应用程序单例.
        initApplication();
        // 初始化第三方应用程序生命周期监听器.
        initCallbacks();
        // 注册应用程序转入前台的监听.
        registerForegroundListener();
        // 触发生命周期回调.
        triggerApplicationOnCreateCallbackEvent(0);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        registerBackgroundListener(level);
    }

    /**
     * 初始化应用程序.
     */
    private void initApplication() {
        if (null == application) {
            application = this;
        }
    }

    /**
     * 初始化应用程序生命周期监听器.
     */
    private void initCallbacks() {
        if (null == applicationList) {
            applicationList = getApplicationList();
        }
    }

    /**
     * 注册应用程序转入前台的监听.
     */
    private void registerForegroundListener() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                if (isBackground) {
                    isBackground = false;
                    triggerApplicationOnCreateCallbackEvent(2);
                }
            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    /**
     * 注册应用程序转入后台的监听.
     *
     * @param level 当前内存/页面状态等级.
     */
    private void registerBackgroundListener(int level) {
        // 采用大于等于的形式判断更加准确.
        if (level >= TRIM_MEMORY_UI_HIDDEN) {
            // 更新标识
            isBackground = true;
            triggerApplicationOnCreateCallbackEvent(1);
        }
    }

    /**
     * 触发 App 生命周期事件.
     *
     * @param eventCode 生命周期事件编码. 0=创建应用; 1=进入后台; 2=进入前台.
     */
    private void triggerApplicationOnCreateCallbackEvent(int eventCode) {
        if (null != applicationList && !applicationList.isEmpty()) {
            for (IApplication iApplication : applicationList) {
                switch (eventCode) {
                    case 0:
                        iApplication.onAppCreate();
                        break;
                    case 1:
                        iApplication.onAppToBackground();
                        break;
                    case 2:
                        iApplication.onAppToForeground();
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * 获取额外的生命周期处理接口对象.
     * 可用于第三方及程序内部监听应用的生命周期,以便处理相关业务问题.
     */
    public abstract List<IApplication> getApplicationList();
}
