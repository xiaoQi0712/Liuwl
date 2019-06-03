package com.briup.order.sms.service;

import com.briup.order.sms.bean.Dishes;
import com.briup.order.sms.bean.extend.DishesExtend;

import java.util.List;

public interface IDishesService {
    //查找甜品信息
    List<DishesExtend> findAll();
    //增加甜品信息
    void AddDishes(Dishes dishes);
    //通过ID查找
    Dishes findByID(long id);
    //删除
    void Delete(Long id);
    //批量删除课程信息
    void batchDelete(Long[] ids);
}
