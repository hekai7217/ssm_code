package com.sxt.test;

import com.sxt.bean.User;
import org.junit.Test;

/**
 * @author 黄药师
 * @date 2020-10-07 15:15
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class UserTest {

    @Test
    public void set(){

        User user = new User();
        user.setName("张三");
        user.setAge(30);

        System.out.println(user.getName());
        System.out.println(user.getAge());

    }

}
