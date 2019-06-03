package com.briup.apps.tb_app01.web.controller;

import com.briup.apps.tb_app01.bean.User;
import com.briup.apps.tb_app01.service.IUserService;
import com.briup.apps.tb_app01.utils.Message;
import com.briup.apps.tb_app01.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private IUserService userService;

    @GetMapping("query")
    public Message query(
            String username,
            String realname,
            String gender,
            String type){
        User user = new User();
        user.setUsername(username);
        user.setRealname(realname);
        user.setGender(gender);
        user.setType(type);
        List<User> list = userService.query(user);
        return MessageUtil.success(list);
    }


    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(User user){
        if(user.getId() == null){
            user.setType("教师");
            user.setStatus("正常");
            user.setPassword("123321");
        }
        userService.saveOrUpdate(user);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("findAll")
    public Message findAll(){
        List<User> list = userService.findByType("教师");
        return MessageUtil.success(list);
    }

    @GetMapping("deleteById")
    public Message deleteById(long id){
        userService.deleteById(id);
        return MessageUtil.success("删除成功！");
    }

    @PostMapping("batchDelete")
    public Message batchDelete(@RequestBody long[] ids){
        userService.batchDelete(ids);
        return MessageUtil.success("删除成功！");
    }

    @GetMapping("findById")
    public Message findById(long id){
        User user = userService.findById(id);
        return MessageUtil.success(user);
    }

}
