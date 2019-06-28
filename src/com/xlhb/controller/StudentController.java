package com.xlhb.controller;

import com.xlhb.pojo.Student;
import com.xlhb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    //学生跳转到修改密码界面
    @RequestMapping(value = "/studentPasswordManage.action")
    public ModelAndView studentPasswordManage(HttpSession session) {
        return new ModelAndView("studentpasswordmanage");
    }

    //学生修改密码
    @RequestMapping(value = "/updateStudentPassword.action", produces="application/json;charset=UTF-8")
    @ResponseBody
    public boolean updateStudentPassword(String newpassword, HttpSession session){
        Student student = (Student)session.getAttribute("loginStudent");
        student.setPassword(newpassword);
        studentService.updatePassword(student, student.getId());
        return true;
    }


}
