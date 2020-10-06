package com.sxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 黄药师
 * @date 2020-10-06 14:38
 * @desc 百战程序员 http://www.itbaizhan.com
 */
@Controller
public class Demo02Controller {

    // 处理登陆的操作
    // 登陆后 保存到session中

    @RequestMapping("/login")
    public String login(String name, HttpSession session){
        session.setAttribute("name",name);
        return "/success.jsp";
    }

    @RequestMapping("/demo01")
    public String handlerReq01(){
        return "/success.jsp";
    }

}
