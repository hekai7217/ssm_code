package com.sxt.controller;

import com.sxt.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 黄药师
 * @date 2020-10-06 10:39
 * @desc 百战程序员 http://www.itbaizhan.com
 */
@Controller
public class Demo04Controller {

    /**
     *   返回结果是对象,通过视图解析器下面配置的前缀,去这个目录找 url指定的视图 (方法上面的url 就是视图的名称)
     *   找不到会报错
     *
     *   问题?
     *   可以实现页面跳转, 不能实现数据共享
     *   @ModelAttribute("userKey")//跳转页面使用el表达式获取的对应的属性名称
     *   把user数据共享到 user.jsp 页面 默认的key 是url的名称
     *    @ModelAttribute(value = "u") 设置value 可指定key的名称
     *
     *
     *
     * @return
     */
    @ModelAttribute(value = "u")
    @RequestMapping("/user")
    public User handlerReq01(){

        User u = new User();
        u.setName("hello");
        u.setAge(18);
        return u;
    }

}
