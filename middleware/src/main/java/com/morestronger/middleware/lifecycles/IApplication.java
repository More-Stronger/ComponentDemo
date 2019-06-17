package com.morestronger.middleware.lifecycles;

/**
 * project ComponentDemo
 * author 王越强
 * describeb application接口.
 * date 2019/6/10
 * time 10:34
 */
public interface IApplication {

    /**
     * 应用程序被创建
     */
    void onAppCreate();

    /**
     * 应用程序转入后台运行.
     * 后台时,应该释放不必要的内存,避免应用被杀死.
     */
    void onAppToBackground();

    /**
     * 应用程序回到前台运行.
     */
    void onAppToForeground();
}
