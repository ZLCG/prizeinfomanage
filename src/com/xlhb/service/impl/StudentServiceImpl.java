package com.xlhb.service.impl;

import com.xlhb.mapper.StudentMapper;
import com.xlhb.pojo.Student;
import com.xlhb.pojo.StudentExample;
import com.xlhb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    //返回学生列表
    @Override
    public List<Student> listStudent() {
        return studentMapper.selectByExample(new StudentExample());
    }

    //以学号和密码为参数查找学生（至多一位，没有找到返回null）
    @Override
    public Student getStudent(String number, String password){
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria studentExampleCriteria = studentExample.createCriteria();

        studentExampleCriteria.andNumberEqualTo(number);
        studentExampleCriteria.andPasswordEqualTo(password);
        List<Student> students = studentMapper.selectByExample(studentExample);
        if (students.size() == 0){
            return null;
        } else {
            return students.get(0);
        }
    }

    //添加一位学生
    public void insertStudent(Student student){
        studentMapper.insertSelective(student);
    }

    //以学生ID为参数删除学生
    @Override
    public void deleteStudent(Integer id) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria studentExampleCriteria =studentExample.createCriteria();
        studentExampleCriteria.andIdEqualTo(id);
        studentMapper.deleteByExample(studentExample);
    }

    //修改指定ID的学生信息（参数传入一个新的学生对象）
    @Override
    public void updatePassword(Student student, Integer id) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria studentExampleCriteria =studentExample.createCriteria();

        studentExampleCriteria.andIdEqualTo(id);
        studentMapper.updateByExampleSelective(student, studentExample);
    }

}
