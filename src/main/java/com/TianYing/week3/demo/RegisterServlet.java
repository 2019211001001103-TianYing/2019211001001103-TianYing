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
    Connection con=null;
    public void init() throws ServletException{
        //        String driver = getServletContext().getInitParameter("driver");
//        String url = getServletContext().getInitParameter("url");
//        String username = getServletContext().getInitParameter("username");
//        String password = getServletContext().getInitParameter("password");
//
//        try{
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
        con = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username = request.getParameter("Username");
        String password = request.getParameter("password");
        String Email = request.getParameter("Email");
        String Gender = request.getParameter("sex");
        String BirthDate = request.getParameter("BirthDate");
        PrintWriter writer = response.getWriter();
//        writer.println("<br>");
//        writer.println("<br>username:"+username);
//        writer.println("<br>password:"+password);
//        writer.println("<br>email:"+mail);
//        writer.println("<br>gender:"+sex);
//        writer.println("<br>birthDate:"+birth);
//        System.out.println("gotted");
        String[][] arr=new String[100][6];
        int a=0;
        try {
            System.out.println("con:"+con);
            Statement createDbStatement = con.createStatement();
            String add="insert into usertable values('"+Username+"','"+password+"','"+Email+"','"+Gender+"','"+BirthDate+"')";
            createDbStatement.executeUpdate(add);
            //            String rs="select * from usertable";
//            ResultSet result=createDbStatement.executeQuery(rs);
//            while(result.next()) {
//                arr[a][0]=result.getString(1);
//                arr[a][1]=result.getString(2);
//                arr[a][2]=result.getString(3);
//                arr[a][3]=result.getString(4);
//                arr[a++][4]=result.getString(5);
//            }
        } catch (Exception e) {
            System.out.println(e);
        }
        response.sendRedirect("login.jsp");
//        writer.println("<table border=\"1\">");
//        writer.println("<tr><th>ID</th><th>UserName</th><th>Password</th><th>Email</th><th>Gender</th><th>Birthdate</th></tr>");
//        for(int i=0;i<a;i++) {
//            writer.println("<tr><td>"+(i+1)+"</td>");
//            for(int j=1;j<=5;j++) {
//                writer.println("<td>"+arr[i][j]+"</td>");
//            }
//            writer.println("</tr>");
//        }
//        writer.println("</table>");
    }

}


