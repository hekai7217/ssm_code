package com.sxt.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sxt.bean.Student;
import com.sxt.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-07 9:21
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 * 测试条件查询
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class Mp04Test {

    @Autowired
    private StudentMapper studentMapper;


    @Test
    public void query01(){

        // 条件查询
        // 条件查询  查询一个

        // 01 创建 一个条件查询对象 wrapper
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();

//        queryWrapper.eq("sid",6);
//        queryWrapper.eq("sage",22);
        // SELECT sid,s_name,sage,ssex,sphone FROM t_student WHERE (sid = ? AND sage = ?)
//         Student student = studentMapper.selectOne(queryWrapper);

        // wrapper 还支持链式编程
        queryWrapper.gt("sage",18).  // 大于 18
                eq("ssex","女").    // 性别 女
                lt("sage",30);     // 小于 < 30

        List<Student> students = studentMapper.selectList(queryWrapper);
        System.out.println("students = " + students);

    }

    @Test
    public void query02(){

        // or 多条条件
//        QueryWrapper<Student> qr = new QueryWrapper<>();
//        qr.eq("sid", 2).or().lt("sage", 25);
//
//        List<Student> students = studentMapper.selectList(qr);
//        System.out.println("students = " + students);

        // 模糊查询
        QueryWrapper<Student> qr = new QueryWrapper<>();
//        qr.like("s_name","张");
        // SELECT sid,s_name,sage,ssex,sphone FROM t_student WHERE (s_name LIKE ?)

        // 排序
//        qr.orderByDesc("sage");
//        List<Student> students = studentMapper.selectList(qr);
//        System.out.println("students = " + students);

        // 统计
        // SELECT sid,s_name,sage,ssex,sphone FROM t_student GROUP BY ssex
        // 查询  结果 第一个字段 字段 的值
        List<Object> objects = studentMapper.selectObjs(qr);
        System.out.println("objects = " + objects);

    }

    @Test
    public void query03(){

        // 查询自定的指定的字段
        QueryWrapper<Student> qr = new QueryWrapper<>();
        // 查询 自定的字段
        qr.select("s_name","ssex");
        List<Student> students = studentMapper.selectList(qr);
        System.out.println("students = " + students);
    }

    @Test
    public void query04(){

        QueryWrapper<Student> qr = new QueryWrapper<>();

        qr.groupBy("ssex");
        List<Student> students = studentMapper.selectList(qr);
        System.out.println("students = " + students);

    }

    @Test
    public void update(){

        QueryWrapper<Student> qr = new QueryWrapper<>();
        qr.eq("sid",17);

        Student student = new Student();
        student.setSname("赵敏");
        student.setSage(28);
//        student.setSsex("女");
//        student.setSphone("1234");

        // 会对属性进判断   如果null 不会修改
        // 所有的属性都有
        // UPDATE t_student SET s_name=?, sage=?, ssex=?, sphone=? WHERE (sid = ?)

        // 如果没有属性
        //UPDATE t_student SET s_name=?, sage=? WHERE (sid = ?)
//        int update = studentMapper.update(student, qr);
//        System.out.println(update> 0 ? "成功":"失败");

    }

    @Test
    public void delete(){
        QueryWrapper<Student> qr = new QueryWrapper<>();
        qr.in("sage",100,70);
        int delete = studentMapper.delete(qr);
        // DELETE FROM t_student WHERE (sage IN (?,?))
        System.out.println("delete = " + delete);
    }

}
