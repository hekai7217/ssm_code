package com.sxt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 黄药师
 * @date 2020-10-06 15:23
 * @desc 百战程序员 http://www.itbaizhan.com
 *   @ControllerAdvice 处理全局异常
 */
@ControllerAdvice
public class AppAllException {

    // 处理异常1
    @ExceptionHandler(NullPointerException.class)
    public String exInfo(Exception e){
        System.out.println("e = " + e.getMessage());
        return "net.jsp";
    }


    // 处理异常2
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ArithmeticException.class)
    public String exInfo2(Exception e){
        System.out.println("e = " + e.getMessage());
        return "net2.jsp";
    }
}
