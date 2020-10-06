package com.sxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 黄药师
 * @date 2020-10-06 15:12
 * @desc 百战程序员 http://www.itbaizhan.com
 */
@Controller
public class Demo03Controller {

    private int age = 10;

    // 处理请求
    @RequestMapping("/req01")
    public String handlerReq01(int id){

        age ++;
        System.out.println("请求过来了........");

        if (id == 1){  // 算术 异常 
            int a = 1 / 0 ;
        }

        if (id == 2){  // null异常 
           Object a = null;
            System.out.println("a.toString() = " + a.toString());
        }
        return "/success.jsp";
    }

    //处理异常
    // 局部异常的处理器

    //使用注解处理异常
    //  注解中 捕获处理去的异常 或者这个异常的子类

    // 01 controller 或者 dao service , 一定要报 异常抛上去  给dispatchservlet 处理
    // 02 捕获指定的异常

//    @ExceptionHandler(ArithmeticException.class)
//    public String exInfo(Exception e){
//        System.out.println("e = " + e.getMessage());
//        return "net.jsp";
//    }
}
