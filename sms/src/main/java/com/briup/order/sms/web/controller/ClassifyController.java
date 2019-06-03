package com.briup.order.sms.web.controller;

import com.briup.order.sms.bean.Classify;
import com.briup.order.sms.service.IClassifyService;
import com.briup.order.sms.utils.Message;
import com.briup.order.sms.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classify")
public class ClassifyController {
    @Autowired
    private IClassifyService iClassifyService;

    @PostMapping("/add")
    public Message Add(Classify classify){
        iClassifyService.Add(classify);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("findClassifyName")
    public Message findClassifyName(){
        List<Classify> list = iClassifyService.findClassifyName();
        return MessageUtil.success(list);
    }
}
