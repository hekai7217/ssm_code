package com.sxt.bean;

/**
 * @author 黄药师
 * @date 2020-09-29 17:02
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class Stu {

    private String name;
    private Integer age;
    private Integer id;
    private String info;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", info='" + info + '\'' +
                '}';
    }
}
