package com.briup.apps.tb_app01.web.controller;

import com.briup.apps.tb_app01.bean.Course;
import com.briup.apps.tb_app01.bean.extend.CourseExtend;
import com.briup.apps.tb_app01.service.ICourseService;
import com.briup.apps.tb_app01.utils.Message;
import com.briup.apps.tb_app01.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @GetMapping("findAllWithTeacher")
    public Message findAllWithTeacher(){
        List<CourseExtend> list = courseService.findAllWithTeacher();
        return MessageUtil.success(list);
    }

    @GetMapping("findAll")
    public Message findAll(){
        List<Course> list = courseService.findAll();
        return MessageUtil.success(list);
    }

    @GetMapping("findById")
    public Message findById(long id) {
        Course course = courseService.findById(id);
        return MessageUtil.success(course);
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Course course){
        courseService.saveOrUpdate(course);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("deleteById")
    public Message deleteById(long id){
        courseService.deleteById(id);
        return MessageUtil.success("删除成功！");
    }

    @PostMapping("batchDelete")
    public Message batchDelete(@RequestBody Long[] ids){
        courseService.batchDelete(ids);
        return MessageUtil.success("删除成功");
    }

}
