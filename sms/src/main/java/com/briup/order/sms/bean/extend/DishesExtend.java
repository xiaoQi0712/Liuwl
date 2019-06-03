package com.briup.order.sms.bean.extend;

import com.briup.order.sms.bean.Classify;
import com.briup.order.sms.bean.Dishes;

/**
 * @program: tb_app01
 * @description: 课程拓展类
 * @author: charles
 * @create: 2019-04-30 16:34
 **/

public class DishesExtend extends Dishes {
    private Classify classify;

    public Classify getClassify() {
        return classify;
    }

    public void setClassify(Classify classify) {
        this.classify = classify;
    }
}
