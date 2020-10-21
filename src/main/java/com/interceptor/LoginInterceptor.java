package com.interceptor;

import com.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url=request.getRequestURL().toString();

        User user= (User) request.getSession().getAttribute("currentUser");
        if (user!=null){
            return true;//true为不拦截
        }else {
            if (
                      url.contains("userLetter")
                      ||url.contains("addWorks")
                      ||url.contains("worksEdit")
                      ||url.contains("myWorks")
                      ||url.contains("sendComment")
                      ||url.contains("showMyWorks")
                      ||url.contains("analyze")
                      ||url.contains("bombHistory")
                      ||url.contains("updatePassword")
                      ||url.contains("updateHeadImage")
                      ||url.contains("mySettings")
                      ||url.contains("myRemind")
                ){

                response.sendRedirect(request.getContextPath()+"/login");
                return false;//false为拦截

            }

            return true;
        }

    }

}
