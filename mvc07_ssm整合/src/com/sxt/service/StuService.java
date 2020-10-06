package com.sxt.service;

import com.sxt.bean.Stu;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-06 15:49
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public interface StuService  {

    List<Stu> findStus();

    //添加
    void addStu(Stu stu);

    void delStu(int id);
}
