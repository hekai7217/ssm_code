package com.sxt.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import sun.awt.SunHints;

/**
 * @author 黄药师
 * @date 2020-10-07 9:20
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *  @TableName("t_student") 把实体和 表进行映射
 */
public class Student {

    @TableId(type = IdType.AUTO)  // 告诉 mp 表的主键

    private Integer sid;
    @TableField("s_name")  // 表字段和实体的映射
    private String sname;
    private Integer sage;
    private String ssex;
    private String sphone;

    // 默认 对象 和 数据库的字段进映射
    // 使用 @TableField 标记
    @TableField(exist =  false)  // 告诉mp 这个字段 和 数据库中的表的字段不用映射
    private String score;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public Student() {
    }

    public Student(Integer sid, String sname, Integer sage, String ssex, String sphone) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
        this.sphone = sphone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", ssex='" + ssex + '\'' +
                ", sphone='" + sphone + '\'' +
                '}';
    }
}
