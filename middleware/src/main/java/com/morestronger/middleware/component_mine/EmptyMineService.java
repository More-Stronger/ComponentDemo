package com.morestronger.middleware.component_mine;

import android.content.Context;

/**
 * project ComponentDemo
 * author 王越强
 * describe  一个空实现接口对象,不做任何处理,当没有实例化时返回空对象,避免外部调用空指针异常.
 * date 2019/6/10
 * time 14:17
 */
public class EmptyMineService implements IMineService {
    @Override
    public void launch(Context context) {

    }
}
