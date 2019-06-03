package com.briup.apps.tb_app01.service.impl;

import com.briup.apps.tb_app01.bean.Course;
import com.briup.apps.tb_app01.bean.CourseExample;
import com.briup.apps.tb_app01.bean.extend.CourseExtend;
import com.briup.apps.tb_app01.mapper.CourseMapper;
import com.briup.apps.tb_app01.mapper.extend.CourseExtendMapper;
import com.briup.apps.tb_app01.service.ICourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: tb_app01
 * @description: 课程实现类
 * @author: charles
 * @create: 2019-04-30 15:20
 **/
@Service
public class CourseServiceImpl implements ICourseService {
    @Resource
    private CourseMapper courseMapper;
    @Resource
    private CourseExtendMapper courseExtendMapper;


    @Override
    public void deleteById(long id) {
        courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(Long[] ids) {
        for(long id : ids){
            courseMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<CourseExtend> findAllWithTeacher() {
        return courseExtendMapper.selectAll();
    }

    @Override
    public List<Course> findAll() {
        CourseExample example = new CourseExample();
        return courseMapper.selectByExample(example);
    }

    @Override
    public Course findById(long id) {

        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Course course) {
        if(course.getId()==null){
            //保存
            courseMapper.insert(course);
        } else {
            //通过id来修改
            courseMapper.updateByPrimaryKey(course);
        }
    }
}
