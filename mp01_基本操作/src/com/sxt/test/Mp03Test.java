package com.sxt.test;

import com.sxt.bean.Student;
import com.sxt.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-07 9:21
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 */
public class Mp03Test {


    @Test
    public void helloMp(){

        ApplicationContext app = new ClassPathXmlApplicationContext("application.xml");

        StudentMapper studentMapper = app.getBean("studentMapper", StudentMapper.class);


    }
}
