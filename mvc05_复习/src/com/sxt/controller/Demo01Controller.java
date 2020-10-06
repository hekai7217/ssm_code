package com.sxt.controller;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-06 9:22
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 * springmvc的helloworld 步骤:
 *  *  01 导入jar
 *  *     4个核心的加入 + aop + mvc + web的jar
 *  *
 *  *  02 控制器 和之前的servlet  开发步骤一样
 *  *      1. 实现controller接口 重写方法 handleRequest
 *  *          handleRequest 处理请求 方法的参数是 req,resp
 *  *          返回值:
 *  *            ModelAndView   模型和视图
 *  *                mv 就是封装了数据和视图
 *  *                设置数据共享 和 转发到的视图页面
 *  *      2. 可以用注解注解开发
 *            01 需要 扫描 注解
 *            02 需要 注册注解驱动
 *
 *  *
 *  *  03 需要把控制器配置到 ioc容器中
 *  *      创建一个springmvc的ioc容器
 *  *
 *  *  04  4.1配置一个前端控制器
 *  *          springmvc 提供好了, 在web.xml 中配置前端控制器
 *  *      4.2 启动ioc容器
 *  *
 *   处理请求的类  注解标记 controller
 *
 */
@Controller
public class Demo01Controller {

    // 写一个处理请求的方法
    @RequestMapping("/demo01")
    public ModelAndView handlerReq01(){

        ModelAndView mv = new ModelAndView();
        // 实现 跳转到那个页面
        mv.setViewName("success.jsp");
        // 共享数据
        mv.addObject("msg","hello msg");
        return mv;
    }

    // 数据绑定
    // 前台的 页面 的数据提供 可以直接和 处理请求的方法 的数据进行绑定

    // 要求: 前台提交的数据 必须和 处理请求的 参数名称一样
    @RequestMapping("/demo02")
    public ModelAndView handlerReq002(String name,Integer age){

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        ModelAndView mv = new ModelAndView();
        // 实现 跳转到那个页面
        mv.setViewName("success.jsp");
        // 共享数据
        mv.addObject("msg","hello msg");
        return mv;
    }

}
