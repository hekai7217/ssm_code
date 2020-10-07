package com.sxt.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sxt.bean.Student;
import com.sxt.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-07 9:21
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   ar 模式:
 *      一个java类对应数据中表,通过java来操作 数据库表的一行记录
 *
 *   ar模式开发步骤:
 *    01 spring+mp整合
 *    02 需要 XXXMapper
 *    03 实体类 extends Model 重写 pkVal() 方法
 *    04 扫描组件 注入 ioc容器  (底层还是通过mapper 操作 数据库 ar变成 了通过 对象操作数据库)
 *
 *    复杂的业务ar 不行
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class Mp01Test {

    /**
     * ar 模式 添加
     */
    @Test
    public void a_insert(){

        Student student = new Student();
        student.setSid(24);
        student.setSname("范瑶");
        student.setSphone("1111");
        student.setSage(34);
        student.setSsex("男");

        // ar 通过对象操作 数据库表中的记录
//        boolean insert = student.insert();
        // 如果存在数据 会修改数据
        boolean b = student.insertOrUpdate();
        System.out.println("b = " + b);
    }

    /**
     *  ar 模式查询  
     */
    @Test
    public void a_select(){

        Student stu = new Student();
//        stu.setSid(6);
//        // ar 查询  通过id查询
//        Student student = stu.selectById();
//        System.out.println("student = " + student);

        // 查询所有
//        List<Student> students = stu.selectAll();
//        System.out.println("students = " + students);

        // 条件查询
        QueryWrapper<Student> qr = new QueryWrapper<>();
        qr.eq("sid",5);
        Student student = stu.selectOne(qr);

    }

    /**
     * ar 删除
     */
    @Test
    public void ar_delete(){
        Student stu = new Student();
        stu.setSid(16);
        boolean b = stu.deleteById();
    }

    /**
     *  ar 模式 修改
     */
    @Test
    public void ar_update(){
        Student stu = new Student();
        stu.setSid(24);
        stu.setSname("小昭");
        boolean b = stu.updateById();
        System.out.println("b = " + b);
    }

}
