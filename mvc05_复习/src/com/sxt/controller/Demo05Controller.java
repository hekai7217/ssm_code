package com.sxt.controller;

import com.sxt.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-06 10:39
 * @desc 百战程序员 http://www.itbaizhan.com
 *    springmvc 返回结果转成字符串的操作
 *
 *    01 可以直接返回对象转成 json 字符串
 *      1.1 导入 jar, springmvc 默认支持 jackson.jar
 *      1.2 处理请求返回一个对象
 *        通过注解 @ResponseBody 把对象转成  json字符串
 *       也可以返回集合
 *
 *   02 如果多个方法都需要 返回json 可以把注解用到  类上面
 *
 *      @ResponseBody
 *      @Controller   是否可以把这种组合注解用到一个注解上面,
        @RestController 注解是封装了  @ResponseBody, @Controller
 *
 *   03 如果不是返回对象 返回字符串
 *      跳转页面还是 返回字符串?   返回的是字符串
 *
 *   如果ajax提交过来的是 ajax 参数绑定和 之前的操作一样
 */
//@ResponseBody
//@Controller
@RestController
public class Demo05Controller {

//    @ResponseBody
    @RequestMapping("/user01")
    public User handlerReq01(){
        User u = new User() ;
        u.setAge(20);
        u.setName("王语嫣");
       return u;
    }

    @RequestMapping("/user02")
    public List<User> handlerReq02(){

        List<User> users =new ArrayList<>();

        User u = new User() ;
        u.setAge(20);
        u.setName("王语嫣");
        users.add(u);

        User u2 = new User() ;
        u2.setAge(21);
        u2.setName("慕容复");
        users.add(u2);

        return users;
    }

    @RequestMapping("/user03")
    public String handlerReq03(){
        return "hello world ";
    }

}
