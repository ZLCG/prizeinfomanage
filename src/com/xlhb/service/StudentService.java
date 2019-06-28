package com.xlhb.service;

import com.xlhb.pojo.Student;

import java.util.List;

public interface StudentService {
    public List<Student> listStudent();
    public Student getStudent(String number, String password);
    public void insertStudent(Student student);
    public void deleteStudent(Integer id);
    public void updatePassword(Student student, Integer id);
}
