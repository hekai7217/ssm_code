package com.sxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 黄药师
 * @date 2020-10-03 9:44
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *    springmvc 使用注解开发
 *    01  标记我们的类是 controller
 *          @Controller  用在类上面 可以告诉springmvc 是controller, 处理请求
 *            controller 必须用 @Controller注解不能用其他
 *
 *    02  写一个处理请求的方法
 *          handlerReq() 方法名可以随便写
 *          返回值: ModelAndView
 *
 *    03  请求的url 和      HelloAnnoController的handlerReq 方法进行映射
 *        使用注解 @RequestMapping(url) 可以直接用在方法上面
 *        url的访问请求 会指定找到   @RequestMapping("/hello2")上名的路径,
 *        执行 handlerReq  方法处理请求
 *
 *    04  springmvc容器中 需要
 *          01 扫描注解
 *          02 启动 注解驱动 (加一些注解需要的组件)
 *
 *    05 配置前端控制器
 *       启动mvc容器
 *
 */
@Controller
public class HelloAnnoController
{
    @RequestMapping("/hello2")
    public ModelAndView handlerReq(){

        ModelAndView mv = new ModelAndView();
        mv.addObject("name","东方不败");
        mv.setViewName("/success.jsp");

        return mv;
    }

}
