package com.briup.order.sms.service.Impl;

import com.briup.order.sms.bean.Dishes;
import com.briup.order.sms.bean.extend.DishesExtend;
import com.briup.order.sms.mapper.DishesMapper;
import com.briup.order.sms.mapper.extend.DishesExtendMapper;
import com.briup.order.sms.service.IDishesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DishesServiceImpl implements IDishesService {
    @Resource
    private DishesMapper dishesMapper;
    @Resource
    private DishesExtendMapper dishesExtendMapper;
    @Override
    public List<DishesExtend> findAll() {
        return dishesExtendMapper.selectAll();
    }

    @Override
    public void AddDishes(Dishes dishes) {
        if(dishes.getDishesId() == null){
            dishesMapper.insert(dishes);
        }else{
            dishesMapper.updateByPrimaryKey(dishes);
        }
    }

    @Override
    public Dishes findByID(long id) {
        return dishesMapper.selectByPrimaryKey((int) id);
    }

    @Override
    public void Delete(Long id) {
        dishesMapper.deleteByPrimaryKey(Math.toIntExact(id));
    }

    @Override
    public void batchDelete(Long[] ids) {
        for(long id:ids){
            dishesMapper.deleteByPrimaryKey((int) id);
        }
    }
}
