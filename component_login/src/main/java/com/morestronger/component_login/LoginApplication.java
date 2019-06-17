package com.morestronger.component_login;

import com.morestronger.middleware.CommApplication;
import com.morestronger.middleware.lifecycles.IApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * project ComponentDemo
 * author 王越强
 * describe
 * date 2019/6/10
 * time 10:22
 */
public class LoginApplication extends CommApplication {

    @Override
    public List<IApplication> getApplicationList() {
        List<IApplication> applicationList = new ArrayList<>();
        applicationList.add(new LoginApplicationListener());
        return applicationList;
    }
}
