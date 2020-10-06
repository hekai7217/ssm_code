package com.sxt.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 黄药师
 * @date 2020-10-03 14:58
 * @desc 百战程序员 http://www.itbaizhan.com
 *   转换器可以把字符串转成 date类型
 */
public class DateConvert implements Converter<String, Date> {

    @Override
    public Date convert(String s) {

        Date parse = null;
        try {
            parse = new SimpleDateFormat("yyyy-MM-dd").parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return parse;
    }
}
