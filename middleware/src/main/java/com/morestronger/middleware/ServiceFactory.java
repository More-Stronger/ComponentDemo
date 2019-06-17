package com.morestronger.middleware;

import android.widget.Toast;

import com.morestronger.middleware.component_login.EmptyLoginSevice;
import com.morestronger.middleware.component_login.ILoginService;
import com.morestronger.middleware.component_mine.EmptyMineService;
import com.morestronger.middleware.component_mine.IMineService;

/**
 * project ComponentDemo
 * author 王越强
 * describe 接口单例对象,获取和设置个接口对象.
 * date 2019/6/10
 * time 12:13
 */
public class ServiceFactory {
    private static volatile ServiceFactory instance;
    private ILoginService loginService;
    private IMineService mineService;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        if (null == instance) {
            synchronized (ServiceFactory.class) {
                if (null == instance) {
                    instance = new ServiceFactory();
                }
            }
        }
        return instance;
    }

    public ILoginService getLoginService() {
        if (null == loginService) {
            Toast.makeText(CommApplication.getApplication(), "没有初始化登录组件接口对象", Toast.LENGTH_SHORT).show();
            loginService = new EmptyLoginSevice();
        }
        return loginService;
    }

    public void setLoginService(ILoginService loginService) {
        this.loginService = loginService;
    }

    public IMineService getMineService() {
        if (null == mineService) {
            Toast.makeText(CommApplication.getApplication(), "没有初始化我的组件接口对象", Toast.LENGTH_SHORT).show();
            mineService = new EmptyMineService();
        }
        return mineService;
    }

    public void setMineService(IMineService mineService) {
        this.mineService = mineService;
    }
}
