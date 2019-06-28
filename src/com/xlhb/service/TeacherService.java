package com.xlhb.service;

import com.xlhb.pojo.Teacher;

public interface TeacherService {
    public Teacher getTeacher(String number, String password);
    public void updatePassword(Teacher teacher, Integer id);
}
