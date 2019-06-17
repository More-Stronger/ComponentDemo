package com.morestronger.componentdemo;

import com.morestronger.component_login.LoginApplicationListener;
import com.morestronger.middleware.AppConfig;
import com.morestronger.middleware.CommApplication;
import com.morestronger.middleware.lifecycles.IApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * project ComponentDemo
 * author 王越强
 * describe
 * date 2019/6/10
 * time 10:23
 */
public class MainApplication extends CommApplication {

    @Override
    public List<IApplication> getApplicationList() {
        List<IApplication> applicationList = new ArrayList<>();
        applicationList.add(new MainApplicationListener());

        // APP 中通过反射进行实例化对象,减少耦合.禁止在壳 APP 中直接实例化各组件对象.
        for (String componentApplicationListenerPackageName : AppConfig.APPLICATION_LISTENERS) {
            try {
                Class clazz = Class.forName(componentApplicationListenerPackageName);
                Object object = clazz.newInstance();
                if (object instanceof IApplication) {
                    applicationList.add((IApplication) object);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return applicationList;
    }
}