package com.briup.apps.tb_app01.web.controller;




import com.briup.apps.tb_app01.bean.StudentCourse;
import com.briup.apps.tb_app01.bean.extend.StudentCourseExtend;
import com.briup.apps.tb_app01.service.ISCService;
import com.briup.apps.tb_app01.utils.Message;
import com.briup.apps.tb_app01.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/sc")
public class StudentCourseController {

    @Autowired
    private ISCService scService;

    @GetMapping("findAll")
    public Message findAll(){
        List<StudentCourse> list = scService.findAll();
        return MessageUtil.success(list);
    }
    @GetMapping("findAllWithStudent")
    public Message findAllWithStudent(){
        List<StudentCourseExtend> list = scService.findAllWithStudent();
        return MessageUtil.success(list);
    }
    @GetMapping("findAllWithCourse")
    public Message findAllWithCourse(){
        List<StudentCourseExtend> list = scService.findAllWithCourse();
        return MessageUtil.success(list);
    }
    @GetMapping("findById")
    public Message findById(long id) {
        StudentCourse studentCourse = scService.findById(id);
        return MessageUtil.success(studentCourse);
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(StudentCourse StudentCourse){
        long time=System.currentTimeMillis();
        StudentCourse.setChooseTime(time);
        scService.saveOrUpdate(StudentCourse);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("deleteById")
    public Message deleteById(long id){
        scService.deleteById(id);
        return MessageUtil.success("删除成功！");
    }

    @PostMapping("batchDelete")
    public Message batchDelete(@RequestBody Long[] ids){
        scService.batchDelete(ids);
        return MessageUtil.success("删除成功");
    }



}
