package com.sxt.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sxt.mapper.StudentMapper;
import com.sxt.pojo.Student;
import com.sxt.service.IStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-07 14:40
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   mp 和 mybatis 无缝对接
 *   mp 都是在增强 mybatis
 *   可以不可以自己写mapper
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class Mp03Test {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void demo01(){

        Student stu = studentMapper.login("赵敏", 17);
        System.out.println("stu = " + stu);
    }


}
