package com.springboot5.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * 登录检查
 * @Date And @Time: 2022/1/11  14:17
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     *
     * @author 汪思远
     * 登录前  目标方法执行之前
     * @date 2022/1/11 14:18
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object userLogin = session.getAttribute("user");
        //如果登录名不为空，则放行拦截
        if (userLogin!=null){
            return true;
        }
        //拦截住后的 提示信息
        request.setAttribute("msg","请先登录!");
//        response.sendRedirect("/");
        request.getRequestDispatcher("/").forward(request,response);
        //登录不成功则不放行
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
