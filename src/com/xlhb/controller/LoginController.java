package com.xlhb.controller;

import com.xlhb.pojo.Student;
import com.xlhb.pojo.Teacher;
import com.xlhb.service.StudentService;
import com.xlhb.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    //登录验证
    @RequestMapping(value = "/userLogin.action", produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object login(String username, String password, String identity, HttpSession session) {

        Map<String, Object> map = new HashMap<String, Object>();

        if (identity.equals("学生")){
            Student student = studentService.getStudent(username, password);
            if (student == null) {
                map.put("ok", false);
                map.put("message", "用户名或密码错误！请重试");
                return map;
            } else {
                map.put("ok", true);
                map.put("message", "studentHome.action");
                session.setAttribute("loginStudent", student);
                return map;
            }
        }else if (identity.equals("教师")){
            Teacher teacher = teacherService.getTeacher(username, password);
            if (teacher == null) {
                map.put("ok", false);
                map.put("message", "用户名或密码错误！请重试");
                return map;
            } else {
                map.put("ok", true);
                map.put("message", "teacherHome.action");
                session.setAttribute("loginTeacher", teacher);
                return map;
            }
        }else {
            map.put("ok", false);
            map.put("message", "登录异常！请重试");
            return map;
        }

    }

    //跳转学生首页
    @RequestMapping(value = "/studentHome.action")
    public ModelAndView studentHome(){
        return new ModelAndView("studenthome");
    }

    //跳转教师首页
    @RequestMapping(value = "/teacherHome.action")
    public ModelAndView teacherHome(){
        return new ModelAndView("teacherHome");
    }

    //返回当前登录用户名
    @RequestMapping(value = "/userName.action", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String getUserName(HttpSession session, String usersort){

        if (usersort.equals("学生")){

            return ((Student)session.getAttribute("loginStudent")).getName();

        } else if (usersort.equals("教师")){

            return ((Teacher)session.getAttribute("loginTeacher")).getName();

        } else {
            return null;
        }
    }

    //教师退出登录
    @RequestMapping(value = "/teacherLoginOut.action")
    public ModelAndView teacherLoginOut(HttpSession session) {
        session.setAttribute("loginTeacher", null);
        return new ModelAndView("login");
    }

    //学生退出登录
    @RequestMapping(value = "/studentLoginOut.action")
    public ModelAndView studentLoginOut(HttpSession session) {
        session.setAttribute("loginStudent", null);
        return new ModelAndView("login");
    }

}

