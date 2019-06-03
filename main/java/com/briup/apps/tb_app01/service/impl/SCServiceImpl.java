package com.briup.apps.tb_app01.service.impl;


import com.briup.apps.tb_app01.bean.StudentCourse;

import com.briup.apps.tb_app01.bean.StudentCourseExample;
import com.briup.apps.tb_app01.bean.extend.StudentCourseExtend;
import com.briup.apps.tb_app01.mapper.StudentCourseMapper;
import com.briup.apps.tb_app01.mapper.extend.StudentCourseExtendMapper;
import com.briup.apps.tb_app01.service.ISCService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shanxw
 * @program:
 * @description: 学生选课实现类
 * @create: 2019/5/21 9:35
 */

@Service
public class SCServiceImpl implements ISCService {
    @Resource
    private StudentCourseMapper studentCourseMapper;
    @Resource
    private StudentCourseExtendMapper studentCourseExtendMapper;



    @Override
    public List<StudentCourse> findAll() {
        StudentCourseExample example = new StudentCourseExample();
        return studentCourseMapper.selectByExample(example);
    }

    @Override
    public List<StudentCourseExtend> findAllWithStudent() {
        return studentCourseExtendMapper.selectAll();
    }

    @Override
    public List<StudentCourseExtend> findAllWithCourse() {
        return studentCourseExtendMapper.selectAll();
    }


    @Override
    public StudentCourse findById(long id) {

        return studentCourseMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(StudentCourse studentcourse) {

        if(studentcourse.getId()==null){
            //保存
            studentCourseMapper.insert(studentcourse);
        } else {
            //通过id来修改
            studentCourseMapper.updateByPrimaryKey(studentcourse);
        }
    }

    @Override
    public void deleteById(long id) {
        studentCourseMapper.deleteByPrimaryKey(id);

    }

    @Override
    public void batchDelete(Long[] ids) {
        for(long id: ids){
            studentCourseMapper.deleteByPrimaryKey(id);
        }
    }
}
