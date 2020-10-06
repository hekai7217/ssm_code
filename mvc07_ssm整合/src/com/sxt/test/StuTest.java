package com.sxt.test;

import com.sxt.bean.Stu;
import com.sxt.service.StuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-06 15:41
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *    01   spring整合 mybatis
 *
 *       1.1 导入 spring的jar
 *           4个核心, logging
 *  *           aop 的jar  aop 包 切面包 织入包
 *  *           事务  jdbc包  tx包
 *  *           测试包   test.jar
 *  *        mybatis的jar
 *              核心包
 *              log4j.jar
 *           数据库驱动
 *              连接池 / 驱动包
 *           spring和 mybatis的桥梁包
 *
 *      1.2  写service / mapper
 *
 *      1.3   配置文件
 *           log4j.properties
 *           db.properties
 *           application.xml
 *
 *      1.4 配置spring管理连接池
 *         管理Sqlsession的获取
 *         管理 mapper注入到ioc容器中
 *
 *    02  spring + springmvc
 *      整合springmvc
 *      01 导入 mvc的jar
 *      02 配置 springmvc.xml + controller
 *      03 配置web.xml
 *         01 前端控制 启动springmvc容器
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class StuTest {

        @Autowired
        private StuService stuService;

        @Test
        public void queryAll(){
                List<Stu> stus = stuService.findStus();
                System.out.println(stus);
        }
}


