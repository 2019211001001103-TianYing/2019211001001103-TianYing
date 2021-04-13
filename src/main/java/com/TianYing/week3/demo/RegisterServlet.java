package com.TianYing.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet(name = "RegisterServlet",value = "/register")
public class RegisterServlet extends HttpServlet {
    public Connection dbConn;
    public void init()  {
        try {
            Class.forName(getServletConfig().getServletContext().getInitParameter("driver"));
            dbConn= DriverManager.getConnection(getServletConfig().getServletContext().getInitParameter("url"),getServletConfig().getServletContext().getInitParameter("username"),getServletConfig().getServletContext().getInitParameter("password"));
            System.out.println(dbConn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String Password=request.getParameter("Password");
        String Email=request.getParameter("Email");
        String Birthdate=request.getParameter("Birthdate");
        String sex=request.getParameter("sex");
        PrintWriter writer=response.getWriter();
//        writer.println("<br>");
//        writer.println("<br>username:"+username);
//        writer.println("<br>password:"+password);
//        writer.println("<br>email:"+mail);
//        writer.println("<br>gender:"+sex);
//        writer.println("<br>birthDate:"+birth);
//        System.out.println("gotted");
        String[][] ret=new String[100][5];
        int cnt=0;
        try {
//            System.out.println("try cn");
            Statement createDbStatement = dbConn.createStatement();

            String dbRequire1="insert into usertable(username,Password,Email,Birthdate,sex) values('"+username+"','"+Password+"','"+Email+"','"+Birthdate+"','"+sex+"')";
//            System.out.println(dbRequire1);
            createDbStatement.executeUpdate(dbRequire1);
            String dbRequire="select username,Password,Email,Birthdate,sex from usertable";
            ResultSet resultDb=createDbStatement.executeQuery(dbRequire);
            while(resultDb.next()) {
                ret[cnt][0]=resultDb.getObject(1).toString().trim();
                ret[cnt][1]=resultDb.getObject(2).toString().trim();
                ret[cnt][2]=resultDb.getObject(3).toString().trim();
                ret[cnt][3]=resultDb.getObject(4).toString().trim();
                ret[cnt++][4]=resultDb.getObject(5).toString().trim();
            }
            request.getRequestDispatcher("userList.jsp").forward(request,response);
            System.out.println("i am in RegisterServlet-->doPost()-->after()-->after forward()");

        } catch (Exception e) {
            System.out.println(e);
        }
     //  writer.println("<table border=\"1\">");
       // writer.println("<tr><td>UserName</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthdate</td></tr>");
       // for(int i=0;i<cnt;i++) {

         //   for(int j=0;j<5;j++) {
        //        writer.println("<td>"+ret[i][j]+"</td>");
        //    }
        //    writer.println("</tr>");
     //   }
     //   writer.println("</table>");
        response.sendRedirect("login.jsp");
    }
}