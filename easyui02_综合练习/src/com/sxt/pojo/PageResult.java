package com.sxt.pojo;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-08 14:43
 * @desc 百战程序员 http://www.itbaizhan.com
 *  分页返回的数据格式 的对象封装
 */
public class PageResult<T>{

    private Long total;

    private List<T> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
