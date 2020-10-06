package com.sxt.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 黄药师
 * @date 2020-10-06 15:30
 * @desc 百战程序员 http://www.itbaizhan.com
 */
@Component
public class AppException implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        //判断异常
        ModelAndView mv = new ModelAndView();

        if (e instanceof NullPointerException){ // 空指针异常
            mv.setViewName("net.jsp");
        }

        if (e instanceof ArithmeticException){ // 算术异常
            mv.setViewName("net2.jsp");
        }


        return mv;
    }

}
