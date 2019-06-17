package com.morestronger.component_login;

import android.content.Context;
import android.content.Intent;

import com.morestronger.middleware.component_login.ILoginService;

/**
 * project ComponentDemo
 * author 王越强
 * describe 在中间件中定义接口,各组件分别具体实现.
 * date 2019/6/10
 * time 10:20
 */
public class LoginService implements ILoginService {

    @Override
    public void launch(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
}
