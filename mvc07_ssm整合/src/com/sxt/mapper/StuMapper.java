package com.sxt.mapper;

import com.sxt.bean.Stu;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-02 16:13
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public interface StuMapper {

    /**
     * 查询所有
     * @return
     */
    List<Stu> findStu();

    void addStu(Stu stu);

    void delStu(int id);
}
