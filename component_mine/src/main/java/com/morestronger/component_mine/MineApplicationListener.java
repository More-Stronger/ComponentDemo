package com.morestronger.component_mine;

import com.morestronger.middleware.lifecycles.IApplication;
import com.morestronger.middleware.ServiceFactory;

/**
 * project ComponentDemo
 * author 王越强
 * describe 我的 application 监听对象.在 APP创建时进行初始化值.
 * date 2019/6/10
 * time 12:03
 */
public class MineApplicationListener implements IApplication {
    @Override
    public void onAppCreate() {
        ServiceFactory.getInstance().setMineService(new MineService());
    }

    @Override
    public void onAppToBackground() {

    }

    @Override
    public void onAppToForeground() {

    }
}
