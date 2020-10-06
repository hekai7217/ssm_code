package com.sxt.controller;

import com.sxt.bean.Stu;
import com.sxt.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-06 16:30
 * @desc 百战程序员 http://www.itbaizhan.com
 */
@Controller
public class StuController {

    @Autowired
    private StuService stuService;

    @RequestMapping("queryAll")
    public String queryAll(Model model){
        List<Stu> stus = stuService.findStus();
        model.addAttribute("stus",stus);
        return "stus";
    }

    @RequestMapping("addStu")
    public String addStu(Stu stu){
        stuService.addStu(stu);
        return "redirect:/queryAll.do";
    }

    @RequestMapping("delStu")
    public String delStu(int id){
        stuService.delStu(id);
        return "redirect:/queryAll.do";
    }

}
