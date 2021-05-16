package com.TianYing.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminAuthenticationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest=(HttpServletRequest) request;
        HttpServletResponse httpResponse=(HttpServletResponse) response;
        HttpSession session=httpRequest.getSession(false);
        boolean isLoggedIn=(session != null && session.getAttribute("user")!= null);
        String loginURI=httpRequest.getContextPath()+"/login";
        boolean isLoginRequset=httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage=httpRequest.getRequestURI().endsWith("login");
        if(isLoggedIn&&(isLoginRequset||isLoginPage)) {
            RequestDispatcher dispatcher=request.getRequestDispatcher("/admin/home");
            dispatcher.forward(request,response);
        }
        else if(isLoggedIn||isLoginRequset) {
            chain.doFilter(request,response);
        }
        else {
            httpResponse.sendRedirect(httpRequest.getContextPath()+"/login");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}