package com.sxt.service.impl;

import com.sxt.bean.Stu;
import com.sxt.mapper.StuMapper;
import com.sxt.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-06 15:49
 * @desc 百战程序员 http://www.itbaizhan.com
 */
@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Override
    public List<Stu> findStus() {
        return stuMapper.findStu();
    }

    @Override
    public void addStu(Stu stu) {
        stuMapper.addStu(stu);
    }

    @Override
    public void delStu(int id) {
        stuMapper.delStu(id);
    }
}
