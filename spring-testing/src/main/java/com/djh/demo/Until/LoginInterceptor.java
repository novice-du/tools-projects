package com.djh.demo.Until;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建拦截器
 *
 * 注意点：
 * 1.拦截器中方法的执行顺序是 preHandle -> Controller -> postHandle -> afterCompletion
 * 只有preHandle返回true,才会执行后面的方法
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    //进入Controller之前执行该方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录拦截的业务逻辑
        System.out.println("-------自定义拦截器开始执行--------------");

        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        System.out.println("username:"+username+"   "+"pwd"+pwd);

        if ("dujunhua".equals(username) && "12345".equals(pwd)){
            System.out.println("username:"+username+"   "+"pwd"+pwd);
            return true;
        }else {
            System.out.println("账号密码错误");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("进入postHandle方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)  {
        System.out.println("进入afterCompletion方法");
    }
}
