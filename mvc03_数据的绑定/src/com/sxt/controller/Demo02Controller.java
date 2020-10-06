package com.sxt.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author 黄药师
 * @date 2020-10-03 14:48
 * @desc 百战程序员 http://www.itbaizhan.com
 *   自定义数据类型的绑定
 *
 *   前台 提交的是 string 服务器需要绑定 日期
 *
 *   总结: 前台提交的是字符串 后台转成 date类型
 *
 *   01  过字符串来获取 提交的数据  转成date类型
 *
 *   02   springmvc 可以使用转换器
 *          01 来一个转换器   实现 spring的转换接口
 *      *  02 需要在springmvc中注册转换器
 *
 *   03 注解
 *       @DateTimeFormat(pattern = "yyyy-MM-dd")  可以直接把字符串转成date类型
 *      *  可以直接 用在方法的请求参数上 , 用在类的属性上面
 */
@Controller
public class Demo02Controller {

    /**
     *  01 通过字符串来获取 提交的数据  转成date类型
     * @param birth
     * @return
     * @throws ParseException
     */
    @RequestMapping("/demo01")
    public ModelAndView handlerReq1(String birth) throws ParseException {

        Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
        System.out.println("parse = " + parse);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/success.jsp");
        return mv;
    }

    /**
     *  beanUtils 如何解决这个问题
     *     转换器    使用beanUtils 注册一个转化器
     *     字节写一个转换器   需要实现 beanUtils 的转换接口
     *
     *  spring的解决方案和    beanUtils的思路一样
     *
     *  01 来一个转换器   实现 spring的转换接口
     *
     *  02 需要在springmvc中注册转换器
     *
     *
     * @param birth
     * @return
     * @throws ParseException
     */
    @RequestMapping("/demo02")
    public ModelAndView handlerReq2(Date birth) throws ParseException {

        System.out.println("birth = " + birth);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/success.jsp");
        return mv;
    }

    /**
     *  上面解决方案很繁琐
     *
     *  解决方案:   注解
     *  @DateTimeFormat(pattern = "yyyy-MM-dd")  可以直接把字符串转成date类型
     *
     *  可以直接 用在方法的请求参数上 , 用在类的属性上面
     *
     * @param birth
     * @return
     * @throws ParseException
     */
    @RequestMapping("/demo03")
    public ModelAndView handlerReq3(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birth) throws ParseException {


        System.out.println("birth = " + birth);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/success.jsp");
        return mv;
    }

    /**
     *
     * <a href="/mvc03/rest/1500761.html"> restful风格 </a>
     *  参数直接在 url上面传递过来
     *
     *  获取参数:
     *   使用注解: @PathVariable("product_id")
     */
    @RequestMapping("/rest/{product_id}")
    public ModelAndView handlerRest(@PathVariable("product_id")String pid){

        System.out.println("pid = " + pid);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("/success.jsp");
        return mv;
    }

    /**
     *  springmvc 解决乱码问题
     *   和javaweb解决的方式是一样的
     *
     *   配置过滤器, springmvc 提供了 编码的过滤器 只需要在 web.xml 配置就可以
     *
     *
     *
     *  @return
     */
    @RequestMapping("/code")
    public ModelAndView handlerCode(String name){
        System.out.println("name = " + name);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/success.jsp");
        return mv;
    }
}
