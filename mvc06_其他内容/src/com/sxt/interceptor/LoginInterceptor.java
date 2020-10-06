package com.sxt.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author 黄药师
 * @date 2020-10-06 14:33
 * @desc 百战程序员 http://www.itbaizhan.com
 *   拦截器 : 和servlet 中的filter类似
 *
 *   拦截器的开发步骤:
 *
 *   01  实现拦截器 接口  org.springframework.web.servlet.HandlerInterceptor
 *   02  重写 拦截器的方法
 *         preHandle  在 执行handler 方法之前可以 拦截
 *              返回true    放行
 *              放回false   拦截
 *         postHandle 在执行handler 方法之后处理
 *         afterCompletion  视图渲染之后执行处理的方法(处理 controller中 异常,日志)
 *
 *   03  需要把拦截器 配置到springmvc容器中
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {

        // 判断
        System.out.println("拦截操作....");

        // 判断是否登陆了
        HttpSession session = request.getSession();
        Object name = session.getAttribute("name");

        if (name != null) {
            // 登陆了 放行
            return true;
        }else{

            //转发到登陆页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);

            return  false;
        }
    }

    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
