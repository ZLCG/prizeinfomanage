package com.xlhb.controller;

import com.xlhb.pojo.Prizeinfo;
import com.xlhb.pojo.Student;
import com.xlhb.pojo.Teacher;
import com.xlhb.service.PrizeinfoService;
import com.xlhb.service.StudentService;
import com.xlhb.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private PrizeinfoService prizeinfoService;

    //跳转学生列表
    @RequestMapping(value = "/viewstudent.action")
    public ModelAndView viewstudent() {
        return new ModelAndView("viewstudents");
    }

    //教师用户查询学生列表
    @RequestMapping(value = "/studentlist.action", produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object prizeinfolist(HttpSession session) {
        List students = studentService.listStudent();
        return students;
    }

    //教师跳转到修改密码界面
    @RequestMapping(value = "/teacherPasswordManage.action")
    public ModelAndView teacherPasswordManage(HttpSession session) {
        return new ModelAndView("teacherpasswordmanage");
    }

    //教师修改密码
    @RequestMapping(value = "/updateTeacherPassword.action")
    @ResponseBody
    public Boolean updateStudentPassword(String newpassword, HttpSession session){
        Teacher teacher = (Teacher)session.getAttribute("loginTeacher");
        teacher.setPassword(newpassword);
        teacherService.updatePassword(teacher, teacher.getId());
        return true;
    }

    //删除学生
    @ResponseBody
    @RequestMapping(value = "/deleteStudent.action")
    public Boolean deleteStudent(Integer id){
        studentService.deleteStudent(id);
        return true;
    }

    //跳转添加学生页面
    @ResponseBody
    @RequestMapping(value = "/addStudentPage.action")
    public ModelAndView addStudentPage(){
        return new ModelAndView("addstudent");
    }

    //添加学生
    @ResponseBody
    @RequestMapping(value = "/addStudent.action")
    public Boolean addStudent(Student student){
        studentService.insertStudent(student);
        return true;
    }

    //跳转修改学生信息页面
    @ResponseBody
    @RequestMapping(value = "/updateStudentPage.action")
    public ModelAndView updateStudentPage(Integer id, HttpSession session){
        List<Student> students = studentService.listStudent();
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getId() == id){
                session.setAttribute("updateStudent", students.get(i));
                break;
            }
        }
        return new ModelAndView("updatestudent");
    }

    //修改学生信息页面获取原信息展示
    @ResponseBody
    @RequestMapping(value = "/updateStudentMessage.action")
    public Object updateStudentMessage(HttpSession session){
        Student student = (Student) session.getAttribute("updateStudent");
        return student;
    }

    //修改学生信息
    @ResponseBody
    @RequestMapping(value = "/updateStudent.action")
    public Boolean updateStudent(Student student, HttpSession session){
        studentService.updatePassword(student, ((Student)session.getAttribute("updateStudent")).getId());
        session.setAttribute("updateStudent", student);
        return true;
    }

    //跳转到学生奖惩信息管理页面
    @ResponseBody
    @RequestMapping(value = "/prizeinfoManage.action")
    public ModelAndView prizeinfoManagePage(Integer id, HttpSession session) {
        List<Student> students = studentService.listStudent();
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getId() == id){
                session.setAttribute("prizeinfomanagestudent", students.get(i));
                break;
            }
        }
        return new ModelAndView("prizeinfomanage");
    }

    //根据选中要管理的学生返回学生奖惩信息管理页面学生个人信息
    @ResponseBody
    @RequestMapping(value = "/prizeinfoManagePageStudentMessage.action")
    public Object prizeinfoManagePageStudentMessage(HttpSession session){
        Student student = (Student) session.getAttribute("prizeinfomanagestudent");
        return student;
    }

    //根据选中管理的学生返回学生奖惩信息
    @ResponseBody
    @RequestMapping(value = "/studentPrizeinfoList.action")
    public Object studentPrizeinfoList(HttpSession session){
        Integer id = ((Student)session.getAttribute("prizeinfomanagestudent")).getId();
        List prizeinfos =prizeinfoService.getPrizeinfo(id);
        return prizeinfos;
    }

    //删除学生奖惩信息
    @ResponseBody
    @RequestMapping(value = "/deletePrizeinfo.action")
    public Boolean deletePrizeinfo(Integer id){
        prizeinfoService.deletePrizeinfo(id);
        return true;
    }

    //跳转添加奖惩条目页面
    @ResponseBody
    @RequestMapping(value = "/addPrizeinfoPage.action")
    public ModelAndView addPrizeinfoPage(){
        return new ModelAndView("addprizeinfo");
    }

    //添加奖惩条目
    @ResponseBody
    @RequestMapping(value = "/addPrizeinfo.action")
    public Boolean addPrizeinfo(Prizeinfo prizeinfo, HttpSession session){
        prizeinfo.setStudentid(((Student)session.getAttribute("prizeinfomanagestudent")).getId());
        prizeinfo.setDate(new Date());
        prizeinfoService.insertPrizeinfo(prizeinfo);
        return true;
    }

    //跳转修改奖惩信息页面
    @ResponseBody
    @RequestMapping(value = "/updatePrizeinfoPage.action")
    public ModelAndView updatePrizeinfoPage(HttpSession session, Integer id){
        session.setAttribute("updateprizeinfoid", id);
        return new ModelAndView("updateprizeinfo");
    }

    //返回要修改的奖惩原信息
    @ResponseBody
    @RequestMapping(value = "/updatePrizeinfoMessage.action")
    public Object updatePrizeinfoMessage(HttpSession session){
        Prizeinfo prizeinfo = prizeinfoService.findPrizeinfo((Integer) session.getAttribute("updateprizeinfoid"));
        return prizeinfo;
    }


    //修改奖惩信息
    @ResponseBody
    @RequestMapping(value = "/updatePrizeinfo.action")
    public Boolean updatePrizeinfo(HttpSession session, Prizeinfo prizeinfo){
        prizeinfoService.updatePrizeinfo(prizeinfo, (Integer) session.getAttribute("updateprizeinfoid"));
        return true;
    }

}
