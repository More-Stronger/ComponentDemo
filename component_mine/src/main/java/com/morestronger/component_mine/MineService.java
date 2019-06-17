package com.morestronger.component_mine;

import android.content.Context;
import android.content.Intent;

import com.morestronger.middleware.component_mine.IMineService;

/**
 * project ComponentDemo
 * author 王越强
 * describe 在中间件中定义接口,各组件分别具体实现.
 * date 2019/6/10
 * time 10:21
 */
public class MineService implements IMineService {

    @Override
    public void launch(Context context) {
        Intent intent = new Intent(context, MineActivity.class);
        context.startActivity(intent);
    }
}
