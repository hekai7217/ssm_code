package com.sxt.controller;

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
 * @date 2020-10-06 10:21
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *      *  总结:  springmvc 处理请求的返回结果
 *      *
 *      *  01  void   数据共享和 页面跳转 需要通过javaEE组件 request对象实现
 *      *         // 通过req 设置 数据共享
 *      *         req.setAttribute("msg","放假 10天");
 *      *         // 页面跳转   请求转发
 *      *         req.getRequestDispatcher("/success.jsp").forward(req,resp);
 *      *
 *      *  02 ModelAndView   把数据和 视图封装到了ModelAndView对象中 视图解析会自己解析
 *      *        ModelAndView mv = new ModelAndView();
 *      *         // 实现 跳转到那个页面
 *      *         mv.setViewName("success.jsp");
 *      *         // 共享数据
 *      *         mv.addObject("msg","mv");
 *      *         return mv;
 *      *
 *      *  03 String      返回字符串   实现数据共享 需要注入 springmvc 提供的组件 model / modelMap
 *      *
 *      *          model.addAttribute("name","杨过");
 *      *
 *      *         // /WEB-INF/view/hello.jsp
 *      *         // 前缀和后缀 在 视图解析器中 配置了
 *      *         // 前缀 + hello + .jsp
 *      *         return "hello";
 *      *
 *      *         ModelMap.addAttribute("name","尹志平");
 *      *         return "hello";
 *      *
 */
@Controller
public class Demo02Controller {


    //处理请求 返回的结果
    // 01 返回的结果是 void 类型
    // 如何 实现 数据共享 和页面跳转

    // springmvc 可以注入 javaEE的组件, 可以使用req实现数据共享 , req进行页面跳转
    @RequestMapping("demo03")
    public void handlerReq03(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 通过req 设置 数据共享
        req.setAttribute("msg","放假 10天");
        // 页面跳转   请求转发
        req.getRequestDispatcher("/success.jsp").forward(req,resp);
    }

    /**
     * 返回结果是  modelandView
     *  把 共享数据可以 直接 封装到 modelandView
     *  model 模型   可以共享数据
     *  View 视图    可以给视图(jsp)名称  视图解析器 会自动解析视图名称 找到他
     */
    @RequestMapping("demo04")
    public ModelAndView handlerReq04(){

        ModelAndView mv = new ModelAndView();
        // 实现 跳转到那个页面
        mv.setViewName("success.jsp");
        // 共享数据
        mv.addObject("msg","mv");
        return mv;

    }

    // 处理请求的方法 可以直接返回字符串
    // 如何找到指定的页面了 ?
    // 视图解析器  自己配置
    // 可以把 页面配置的更加简洁:直接返回页面名称
    //  /view/hello.jsp 通过配置视图解析器 可以直接返回hello

    @RequestMapping("demo05")
    public String handlerReq05(){

        // /WEB-INF/view/hello.jsp
        // 前缀和后缀 在 视图解析器中 配置了
        // 前缀 + hello + .jsp
        return "hello";
    }


    /**
     * 如果 返回的是字符串 可以实现页面跳转 不能实现数据共享
     *
     * springmvc 提供了解决方案:
     *
     * 01  在处理请求的参数中注入 model 可以实现数据共享
     *
     * 02  modelmap 也可以实现数据共享
     *
     * @return
     */
    @RequestMapping("demo06")
    public String handlerReq06(Model model){

        model.addAttribute("name","杨过");

        // /WEB-INF/view/hello.jsp
        // 前缀和后缀 在 视图解析器中 配置了
        // 前缀 + hello + .jsp
        return "hello";
    }

    @RequestMapping("demo07")
    public String handlerReq07(ModelMap map){

        map.addAttribute("name","尹志平");
        // /WEB-INF/view/hello.jsp
        // 前缀和后缀 在 视图解析器中 配置了
        // 前缀 + hello + .jsp
        return "hello";
    }


}
