package com.morestronger.component_login;

import com.morestronger.middleware.ServiceFactory;
import com.morestronger.middleware.lifecycles.IApplication;

/**
 * project ComponentDemo
 * author 王越强
 * describe 登录 application 监听对象.在 APP创建时进行初始化值.
 * date 2019/6/10
 * time 12:01
 */
public class LoginApplicationListener implements IApplication {
    @Override
    public void onAppCreate() {
        ServiceFactory.getInstance().setLoginService(new LoginService());
    }

    @Override
    public void onAppToBackground() {

    }

    @Override
    public void onAppToForeground() {

    }
}
