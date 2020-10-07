package com.sxt.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxt.bean.Student;
import com.sxt.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.TreeSet;

/**
 * @author 黄药师
 * @date 2020-10-07 9:21
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   分页查询的操作步骤:
 *    01  添加配置
 *        mp的插件配置
 *
 *            配置mp的分页插件
 *         <property name="plugins">
 *             <array>
 *                 配置分页插件:拦截对象
 *                 <bean class="com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor">
 *                     <property name="dbType" value="MYSQL"></property>
 *                     指明要进行分页操作的数据库
 *                 </bean>
 *             </array>
 *         </property>
 *   02 导入一个sql 解析包
 *       需要导入 一个jar:jsqlparser-0.9.1.jar
 *
 *   03 测试
 *     3.1 创建page对象 封装 当前的页面和 页面大小
 *     3.2 调用方法  selectPage(page, null);
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class Mp05Test {

    @Autowired
    private StudentMapper studentMapper;


    @Test
    public void queryPage01(){


        // 创建一个 page对象 (封装 分页的数据)
        Page<Student> page = new Page<>(1,3);

        Page<Student> p = studentMapper.selectPage(page, null);

        // 查询的总数
        System.out.println("p.getTotal() = " + p.getTotal());
        // 分页
        System.out.println("p.getPages() = " + p.getPages());
        // 每页的大小
        System.out.println("p.getSize() = " + p.getSize());
        // 当前页码
        System.out.println("p.getCurrent() = " + p.getCurrent());
        // 分页返回的结果
        System.out.println("p.getRecords() = " + p.getRecords());
    }

    @Test
    public void queryPage02(){


        QueryWrapper<Student> qr = new QueryWrapper<>();
        qr.lt("sage",25);

        // 创建一个 page对象 (封装 分页的数据)
        Page<Student> page = new Page<>(1,3);

        Page<Student> p = studentMapper.selectPage(page, qr);

        // 查询的总数
        System.out.println("p.getTotal() = " + p.getTotal());
        // 分页
        System.out.println("p.getPages() = " + p.getPages());
        // 每页的大小
        System.out.println("p.getSize() = " + p.getSize());
        // 当前页码
        System.out.println("p.getCurrent() = " + p.getCurrent());
        // 分页返回的结果
        System.out.println("p.getRecords() = " + p.getRecords());
    }

    /**
     *   mp 插入数据后 会自动 返回自增的主键 
     */
    @Test
    public void testInsert(){
        //创建一个学生
        Student stu = new Student();
        stu.setSname("杨不悔");
        stu.setSage(28);
        stu.setSphone("1234");
        stu.setSsex("1");
        System.out.println("插入前: stu = " + stu);
        int insert = studentMapper.insert(stu);
        System.out.println("插入后: stu = " + stu);
    }
}
