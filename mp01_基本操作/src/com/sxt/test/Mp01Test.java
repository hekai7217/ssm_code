package com.sxt.test;

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
 *       mp的开发步骤:
 *       01  导入 4 个jar
 *       02 修改配置文件
 *         <bean id="sqlSessionFactory" class="com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean">
 *         </bean>
 *       03  写一个实体类
 *       04  写一个mapper接口 继承 BaseMapper(mp提供的 )
 *       05  测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class Mp01Test {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void helloMp(){

        // 不用写 sql
        // mp会扫描 实体  把sql 注入到 mapper中 直接调用

        // 直接查询 返回结果
        // Table 'mp.student' doesn't exist

        // 默认通过 实体的类名查询指定的数据库  Student 不存在mp.student 表

        // 解决: 告诉mp 实体和 表要映射     @TableName("t_student") 把实体和 表进行映射

        // Unknown column 'sname' in 'field list'
        // 字段不存在, 默认实体的字段和 数据库表字段 进行一一映射
        // 如果不一样 会报错
        // 解决 : 注解 实体字段和 表字段进行映射
        //   @TableField("s_name")  // 表字段和实体的映射

        List<Student> list = studentMapper.selectList(null);
        System.out.println("list = " + list);

    }
}
