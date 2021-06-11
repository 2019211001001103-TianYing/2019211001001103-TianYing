package com.lab2;


import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/lab2/welcome.jsp"})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in LoginFilter-->init()");
    }

    public void destroy() {
        System.out.println("i am in LoginFilter-->destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in Logi nFilter-->doFilter()--request before chain");
        HttpServletRequest request1=(HttpServletRequest) request;
        HttpServletResponse response1=(HttpServletResponse) response;
        if (request1.getSession(false).isNew()){
            RequestDispatcher dispatcher=request.getRequestDispatcher("welcome.jsp");
            dispatcher.forward(request1,response1);
        }else {
            response1.sendRedirect("login.jsp");
        }
        chain.doFilter(request, response);
        System.out.println("i am in LoginFilter-->destroy()--response after chain");
    }
}
