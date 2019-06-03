package com.briup.apps.tb_app01.service;

import com.briup.apps.tb_app01.bean.Course;
import com.briup.apps.tb_app01.bean.extend.CourseExtend;

import java.util.List;

public interface ICourseService {

    /**
     * @Description: 通过id删除
     * @Param: [id]
     * @return: void
     * @Author: charles
     * @Date: 2019-05-05
     */
    void deleteById(long id);
    /** 
     * @Description: 批量删除课程信息
     * @Param: [ids] 
     * @return: void 
     * @Author: charles 
     * @Date: 2019-05-05 
     */ 
    void batchDelete(Long[] ids);

    /**
     * @Description: 查询所有课程级联教师
     * @Param: []
     * @return: java.util.List<com.briup.apps.tb_app01.bean.extend.CourseExtend>
     * @Author: charles
     * @Date: 2019-05-05
     */
    List<CourseExtend> findAllWithTeacher();
    /** 
     * @Description: 查询所有 
     * @Param: [] 
     * @return: java.util.List<com.briup.apps.tb_app01.bean.Course> 
     * @Author: charles 
     * @Date: 2019-04-30 
     */ 
    List<Course> findAll();

    /** 
     * @Description: 通过id查找 
     * @Param: [] 
     * @return: com.briup.apps.tb_app01.bean.Course 
     * @Author: charles 
     * @Date: 2019-04-30 
     */ 
    Course findById(long id);

    /** 
     * @Description: 保存或者更新
     * @Param: [course] 
     * @return: void 
     * @Author: charles 
     * @Date: 2019-04-30 
     */ 
    void saveOrUpdate(Course course);


}
