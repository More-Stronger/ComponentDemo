package com.morestronger.middleware;

/**
 * project ComponentDemo
 * author 王越强
 * describe app配置文件.
 * date 2019/6/10
 * time 13:51
 */
public class AppConfig {
    /**
     * 所有组件中 Application 监听对象完整类名.
     * 壳 APP 中通过反射进行实例化对象,减少耦合.禁止在壳 APP 中直接实例化各组件对象.
     */
    public static final String[] APPLICATION_LISTENERS = {
            "com.morestronger.component_login.LoginApplicationListener",
            "com.morestronger.component_mine.MineApplicationListener"
    };
}
