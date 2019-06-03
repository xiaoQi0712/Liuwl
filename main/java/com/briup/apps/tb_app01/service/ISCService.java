package com.briup.apps.tb_app01.service;

import com.briup.apps.tb_app01.bean.StudentCourse;

import com.briup.apps.tb_app01.bean.extend.StudentCourseExtend;

import java.util.List;

/**
 * @author shanxw
 * @program:
 * @description:
 * @create: 2019/5/21 9:23
 */
public interface ISCService {

    List<StudentCourse> findAll();
    //查询所有选课级联教师
    List<StudentCourseExtend> findAllWithStudent();
    ////查询所有选课级联课程
    List<StudentCourseExtend> findAllWithCourse();

    StudentCourse findById(long id);

    void saveOrUpdate(StudentCourse studentcourse);

    void deleteById(long id);

    void batchDelete(Long[] ids);
}
