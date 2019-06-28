package com.xlhb.controller;

import com.xlhb.pojo.Student;
import com.xlhb.service.PrizeinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PrizeinfoController {

    @Autowired
    private PrizeinfoService prizeinfoService;

    //学生用户跳转到奖惩列表页面
    @RequestMapping(value = "/viewprizeinfo.action")
    public ModelAndView viewprizeinfo() {
        return new ModelAndView("viewprizeinfos");
    }

    //学生用户查询奖惩列表
    @RequestMapping(value = "/prizeinfolist.action", produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object prizeinfolist(HttpSession session) {
        Integer id = ((Student)session.getAttribute("loginStudent")).getId();
        List prizeinfos =prizeinfoService.getPrizeinfo(id);
        return prizeinfos;
    }

}
