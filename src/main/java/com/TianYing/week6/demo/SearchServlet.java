package com.TianYing.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = request.getParameter("txt");
        String search = request.getParameter("search");
        if (txt == null) {
            response.sendRedirect("http://localhost:8080/2019211001001103TianYing_war/index.jsp");
        } else {
            if (search.equals("Baidu")) {
                response.sendRedirect("https://www.baidu.com" + txt);
            } else if (search.equals("Bing")) {
                response.sendRedirect("http://cn.bing.com" + txt);
            } else if (search.equals("Google")) {
                response.sendRedirect("http://www.google.com" + txt);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }
}
