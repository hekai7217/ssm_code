package com.sxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 黄药师
 * @date 2020-10-06 10:24
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *  总结: 自定义 页面跳转
 *      请求转发:
 *      如果有 forward  视图解析器 会 忽略 前缀和后缀
 *      *       通过过来的视图路径 找到指定的页面
 *      *     return "forward:/success.jsp";
 *
 *      重定向:
 *      return "redirect:/success.jsp";
 *       细节:
 *      *     01  不用加项目范围路径
 *      *     02  如果是在WEB-INF的视图,重定向 是不能直接访问 (只能通过内部访问,请求转发)
 *      *     03  重定向可以访问外部的资源路径
 *      *     04  重定向 不能实现数据共享
 *
 *      如果需要访问,WEB-INF 下面的资源用 forward,
 *                  需要数据共享 使用  forward,
 *
 *       如果需要访问的资源,  redirect
 */
@Controller
public class Demo03Controller {

    /**
     *  自定义页面的跳转
     *
     *     如果有 forward  视图解析器 会 忽略 前缀和后缀
     *       通过过来的视图路径 找到指定的页面
     *     return "forward:/success.jsp";
     * @return
     */
    @RequestMapping("req01")
    public String handlerReq01(){
        return "forward:/success.jsp";
    }

    /**
     *  自定义页面的跳转
     *
     *     如果有 redirect  视图解析器 会 忽略 前缀和后缀
     *       通过过来的视图路径 找到指定的页面
     *     return "forward:/success.jsp";
     *
     *     细节:
     *     01  不用加项目范围路径
     *     02  如果是在WEB-INF的视图,重定向 是不能直接访问 (只能通过内部访问,请求转发)
     *     03  重定向可以访问外部的资源路径
     *     04  重定向 不能实现数据共享
     *
     *
     * @return
     */
    @RequestMapping("req02")
    public String handlerReq02(){
//        return "redirect:/success.jsp";

//        return "redirect:/WEB-INF/view/hello.jsp";

        return "redirect:http://www.jd.com";

    }
}
