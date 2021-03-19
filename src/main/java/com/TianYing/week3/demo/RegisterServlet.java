package com.TianYing.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String Password=request.getParameter("Password");
        String Email=request.getParameter("Email");
        String Birthdate=request.getParameter("Birthdate");
        String sex=request.getParameter("sex");

        PrintWriter writer=response.getWriter();
        writer.println("<br>username :"+username);
        writer.println("<br>Password"+Password);
        writer.println("<br>Email"+Email);
        writer.println("<br>Birthdate"+Birthdate);
        writer.println("<br>sex"+sex);
        writer.close();

    }
}
