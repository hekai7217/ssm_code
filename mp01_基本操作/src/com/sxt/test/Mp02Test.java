package com.sxt.test;

import com.sxt.bean.Student;
import com.sxt.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class Mp02Test {

    @Autowired
    private StudentMapper studentMapper;

    // mp 的基本操作 
    
    @Test
    public void insert01(){

        // 所有的参数
        // 会根据实体 自动注入 sql
        // INSERT INTO t_student ( s_name, sage, ssex, sphone ) VALUES ( ?, ?, ?, ? )
//        Student student = new Student();
//        student.setSname("yellow doctor");
//        student.setSage(60);
//        student.setSsex("男");
//        student.setSphone("123");
//        studentMapper.insert(student);

        // 如果对象没有属性,进行判断空 不会添加进去
        //INSERT INTO t_student ( s_name, sage, ssex ) VALUES ( ?, ?, ? )
        Student student = new Student();
        student.setSname("old player");
        student.setSage(62);
        student.setSsex("男");

        int insert = studentMapper.insert(student);
        System.out.println(insert> 0 ? "成功":"失败");

    }

    /**
     * 更新操作
     *   更新通过 主键的id 进行判断
     *    实体类要声明 主键   @TableId(type = IdType.AUTO)  // 告诉 mp 表的主键
     */
    @Test
    public void update(){

        // 如果属性 都有 会更新所有
//        Student student = new Student();
//        // UPDATE t_student SET s_name=?, sage=?, ssex=?, sphone=? WHERE sid=?
//        student.setSid(1);
//        student.setSname("梅超风");
//        student.setSage(30);
//        student.setSsex("女");
//        student.setSphone("123");
//        int i = studentMapper.updateById(student);
//        System.out.println(i > 0 ? "成功":"失败");

        // 如果属性为null 不会更新

        //UPDATE t_student SET s_name=?, sage=? WHERE sid=?
        Student student = new Student();
        student.setSid(20);
        student.setSname("曲正凤");
        student.setSage(40);

        int i = studentMapper.updateById(student);
        System.out.println(i > 0 ? "成功":"失败");
    }

    /**
     * 查询
     */
    @Test
    public void query01(){

        // selectById 通过id查询
//        Student student = studentMapper.selectById(1);
//        System.out.println("student = " + student);

        // 同过列名查询
//        Map<String,Object> map = new HashMap<>();
//        map.put("sid",1);
//        map.put("sage",30);
//        // SELECT sid,s_name,sage,ssex,sphone FROM t_student WHERE sage = ? AND sid = ?
//        List<Student> students = studentMapper.selectByMap(map);
//        System.out.println("students = " + students);

        // selectBatchIds 批 查询
        // SELECT sid,s_name,sage,ssex,sphone FROM t_student WHERE sid IN ( ? , ? , ? )
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Student> students = studentMapper.selectBatchIds(list);
        System.out.println("students = " + students);
    }

    /**
     * 删除操作
     */
    @Test
    public void delete(){

        //id删除
//        int i = studentMapper.deleteById(22);
//        System.out.println(i > 0 ? "成功":"失败");

        // 通过列名删除
//        Map<String,Object> map = new HashMap<>();
//        map.put("sid",1);
//        map.put("sage",30);
//        //  DELETE FROM t_student WHERE sage = ? AND sid = ?
//        int i1 = studentMapper.deleteByMap(map);
//        System.out.println("i1 = " + i1);

        // 批删除
        List<Integer> list = Arrays.asList(1, 2, 3);
        // DELETE FROM t_student WHERE sid IN ( ? , ? , ? )
        int i = studentMapper.deleteBatchIds(list);
        System.out.println(i > 0 ? "成功":"失败");

    }

}
