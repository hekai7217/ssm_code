package com.sxt.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 * @author 黄药师
 * @date 2020-10-03 9:24
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *
 *  springmvc的helloworld 步骤:
 *  01 导入jar
 *     4个核心的加入 + aop + mvc + web的jar
 *
 *  02 控制器 和之前的servlet  开发步骤一样
 *      1. 实现controller接口 重写方法 handleRequest
 *          handleRequest 处理请求 方法的参数是 req,resp
 *          返回值:
 *            ModelAndView   模型和视图
 *                mv 就是封装了数据和视图
 *                设置数据共享 和 转发到的视图页面
 *      2. 可以用注解注解开发
 *
 *  03 需要把控制器配置到 ioc容器中
 *      创建一个springmvc的ioc容器
 *
 *  04  4.1配置一个前端控制器
 *          springmvc 提供好了, 在web.xml 中配置前端控制器
 *      4.2 启动ioc容器
 *
 */
public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        ModelAndView mv = new ModelAndView();

        // 设置数据
//        req.setAttribute();
        mv.addObject("name","周芷若");

        // 转发到 视图页面
        // 通过视图解析器  可以配置 前缀和后缀
        //  可以直接返回 字符串 找到指定的页面
        mv.setViewName("/success.jsp");

        return mv;
    }
}
