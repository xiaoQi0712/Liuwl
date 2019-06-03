package com.briup.apps.tb_app01.bean.extend;


import com.briup.apps.tb_app01.bean.Course;
import com.briup.apps.tb_app01.bean.StudentCourse;
import com.briup.apps.tb_app01.bean.User;

/**
 * @author shanxw
 * @program:
 * @description:
 * @create: 2019/5/27 16:22
 */
public class StudentCourseExtend extends StudentCourse {
    private User student;

    private Course course;

    public User getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
