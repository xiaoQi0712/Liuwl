package com.briup.order.sms.service;

import com.briup.order.sms.bean.Classify;

import java.util.List;

public interface IClassifyService {
    //查找分类
    List<Classify> findClassifyName();
    //增加分类
    void Add(Classify classify);
}
