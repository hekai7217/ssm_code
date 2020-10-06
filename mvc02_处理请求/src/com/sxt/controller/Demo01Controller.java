package com.sxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 黄药师
 * @date 2020-10-03 11:32
 * @desc 百战程序员 http://www.itbaizhan.com
 *   如果@RequestMapping 用在类上面
 *      访问每个方法的时候,需要添加类上名的路径
 */
//@RequestMapping("user")
@Controller
public class Demo01Controller {

    /**
     *  如果配置*.do 结尾的   方法上面的.do 可以省略
     *
     *  方法上面的 /可以省略
     *
     * @return
     */
    @RequestMapping("req01")
    public ModelAndView req01(){

        System.out.println("Demo01Controller.req01");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/success.jsp");
        return mv;
    }

    @RequestMapping("req02")
    public ModelAndView req02(){

        System.out.println("Demo01Controller.req02");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/success.jsp");
        return mv;
    }

    /**
     *   @RequestMapping 可以限制请求
     *      RequestMapping 只支持  get请求
     *      method = RequestMethod.GET 只支持get请求
     *
     *    springmvc提供了只 支持 @GetMapping的注解     @PostMapping
     *       内部就是封装   @RequestMapping(method = RequestMethod.GET)
     *
     *      @RequestMapping 这个注解 默认可以处理get/post
     * @return
     */
    @RequestMapping(value = "req03",method = RequestMethod.GET)
    public ModelAndView req03(){

        System.out.println("Demo01Controller.req02");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/success.jsp");
        return mv;
    }

    /**
     * @RequestMapping 测试参数的限制
     *    参数的限制:
     *     params 提交参数必须有username / password
     *
     * @return
     */
    @RequestMapping(value = "req04",params={"username","password"})
    public ModelAndView req04(){

        System.out.println("Demo01Controller.req04");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/success.jsp");
        return mv;
    }


}
