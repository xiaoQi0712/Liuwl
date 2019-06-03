package com.briup.order.sms.web.controller;

import com.briup.order.sms.bean.Dishes;
import com.briup.order.sms.bean.extend.DishesExtend;
import com.briup.order.sms.service.IDishesService;
import com.briup.order.sms.utils.Message;
import com.briup.order.sms.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishesController {
    @Autowired
    private IDishesService iDishesService;
    @GetMapping("findAll")
    public Message findAll(){
        List<DishesExtend> list = iDishesService.findAll();
        return MessageUtil.success(list);
    }
    @PostMapping("AddDishes")
    public Message AddDishes(Dishes dishes){
        iDishesService.AddDishes(dishes);
        return MessageUtil.success("操作成功");
    }
    @GetMapping("findById")
    public Message findById(Long id){
        Dishes dishes = iDishesService.findByID(id);
        return MessageUtil.success(dishes);
    }
    @GetMapping("Delete")
    public Message Delete(Long id){
        iDishesService.Delete(id);
        return MessageUtil.success("删除成功");
    }
    @PostMapping("batchDelete")
    public Message batchDelete(@RequestBody Long[] ids){
        iDishesService.batchDelete(ids);
        return MessageUtil.success("删除成功");
    }

}
