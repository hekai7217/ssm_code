package com.sxt.controller;

import com.sxt.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;

/**
 * @author 黄药师
 * @date 2020-10-03 14:12
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   数据绑定: 请求带来的数据绑定到 处理请求方法的参数上面
 *
 *      01 方式1  通过req.getParameter 获取
 *         在处理请求的方法中看恶意直接注入 javaWeb的组件
 *          HttpServletRequest      获取请求数据
 *          HttpServletResponse      回写数据
 *          HttpSession             数据共享
 *
 *     02  方式2  springmvc 可以直接把参获取到值和 处理请求方法的参数 绑定
 *     03  方式3  @Requestparam 可以和前台参数绑定,直接把数据赋值 给 处理请求的参数
 *
 *     04  方式4   可以直接绑定 数组
 *     05  可以直接帮顶对象
 *     06  可以直接绑定 到map中 (需要在参数中 添加 @Requestparam 注解 )
 *
 *
 */
@Controller
public class Demo01Controller {

    @RequestMapping("/data01")
    public ModelAndView handlerReq(HttpServletRequest req){

        String age = req.getParameter("age");

        System.out.println("age = " + age);
        String username = req.getParameter("username");
        System.out.println("username = " + username);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/success.jsp");
        return mv;

    }

    /**
     *   账号: <input name="username"><br>
     *         年龄: <input name="age"><br>
     *
     *     springmvc 可以直接把参获取到值和 处理请求方法的参数 绑定
     * @return
     */
    @RequestMapping("/data02")
    public ModelAndView handlerReq2(String username,Integer age){

        System.out.println("username = " + username);

        System.out.println("age = " + age);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("/success.jsp");
        return mv;

    }

    /**
     *   账号: <input name="username"><br>
     *         年龄: <input name="age"><br>
     *
     *     springmvc 可以直接把参获取到 和 处理请求方法的参数 绑定
     *     参数绑定, 前台参数 名称和 处理方法的名称不一致
     *     解决:
     *     mybatis @param
     *     springmvc  @Requestparam 可以和前台参数绑定,直接把数据赋值 给 处理请求的参数
     *
     * @return
     */
    @RequestMapping("/data03")
    public ModelAndView handlerReq3(@RequestParam("name") String username,@RequestParam("ages") Integer age){

        System.out.println("username = " + username);
        System.out.println("age = " + age);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("/success.jsp");
        return mv;

    }

    /**
     *   参数绑定数组

     * @return
     */
    @RequestMapping("/data04")
    public ModelAndView handlerReq4(String [] hobbys){

        System.out.println(Arrays.toString(hobbys));

        ModelAndView mv = new ModelAndView();
        mv.setViewName("/success.jsp");
        return mv;

    }

    /**
     *  springmvc    可以直接把请求参数和对象进行绑定
     * @return
     */
    @RequestMapping("/data05")
    public ModelAndView handlerReq5(User user){

        System.out.println("user = " + user);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/success.jsp");
        return mv;

    }

    /**
     *  springmvc    可以直接把请求参数和map绑定
     *
     *  把表单的数据绑定到map中需要 添加 @RequestParam在参数上面
     *
     *  map的邦的时候,不能绑定 数组
     *      data?key1=aa&key2=bb&fav=看书&fav=游泳
     *
     *
     * @return
     */
    @RequestMapping("/data06")
    public ModelAndView handlerReq6(@RequestParam Map<String,Object> map){
        System.out.println("map = " + map);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/success.jsp");
        return mv;
    }

}
