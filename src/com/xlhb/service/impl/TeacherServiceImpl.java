package com.xlhb.service.impl;

import com.xlhb.mapper.TeacherMapper;
import com.xlhb.pojo.Teacher;
import com.xlhb.pojo.TeacherExample;
import com.xlhb.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    //以学号和密码为参数查找教师（至多一位，没有找到返回null）
    @Override
    public Teacher getTeacher(String number, String password) {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria teacherExampleCriteria = teacherExample.createCriteria();

        teacherExampleCriteria.andNumberEqualTo(number);
        teacherExampleCriteria.andPasswordEqualTo(password);
        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
        if (teachers.size() == 0){
            return null;
        } else {
            return teachers.get(0);
        }
    }

    //修改指定ID的教师信息（参数传入一个新的教师对象）
    @Override
    public void updatePassword(Teacher teacher, Integer id) {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria teacherExampleCriteria = teacherExample.createCriteria();
        teacherExampleCriteria.andIdEqualTo(id);
        teacherMapper.updateByExampleSelective(teacher, teacherExample);
    }
}
