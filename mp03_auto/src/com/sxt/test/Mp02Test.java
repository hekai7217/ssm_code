package com.sxt.test;

import com.alibaba.druid.sql.visitor.SQLASTOutputVisitor;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
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
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class Mp02Test {

    @Autowired
    private IStudentService studentService;

    @Test
    public void demo01(){

        // id 查询
//        Student byId = studentService.getById(5);
//        System.out.println("byId = " + byId);

        // 查询所有
        List<Student> list = studentService.list();
        System.out.println("list = " + list);

        // 统计
        int count = studentService.count();
        System.out.println("count = " + count);

        // 条件查询
        QueryWrapper<Student> qr = new QueryWrapper<>();
        qr.eq("sid",6);
        Student one = studentService.getOne(qr);
        System.out.println("one = " + one);

    }

    @Test
    public void demo02(){
        // 更新
        Student student = new Student();
        student.setsName("胡青牛");
        student.setSage(28);
        student.setSid(20);
        boolean b = studentService.updateById(student);
        System.out.println("b = " + b);
    }

    @Test
    public void demo03(){

//        Student student = new Student();
//        student.setsName("谢逊");
//        student.setSage(48);
        // 添加
//        boolean save = studentService.save(student);
//        System.out.println("save = " + save);
        // 批处理
//        studentService.saveBatch();

        boolean b = studentService.removeById(26);
        System.out.println("b = " + b);
    }


}
