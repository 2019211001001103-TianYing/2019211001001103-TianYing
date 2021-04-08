package com.TianYing.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "RegisterServlet",value = "/register")
public class RegisterServlet extends HttpServlet {
    public Connection dbConn;
    public void init(){
        try{
            Class.forName(getServletConfig().getServletContext().getInitParameter("driver"));
            dbConn= DriverManager.getConnection(getServletConfig().getServletContext().getInitParameter("url"),getServletConfig().getServletContext().getInitParameter("username"),getServletConfig().getServletContext().getInitParameter("password"));
            System.out.println(dbConn);
        }catch (Exception e){System.out.println(e);}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String Password=request.getParameter("Password");
        String Email=request.getParameter("Email");
        String Birthdate=request.getParameter("Birthdate");
        String sex=request.getParameter("sex");

        PrintWriter writer=response.getWriter();
        String[][] ret = new String[100][6];
        int cnt = 0;
        try {
            Statement createDbStatement = dbConn.createStatement();
            String ADDdbRequire="insert into usertable(username,Password,Email,Birthdate,sex) values('"+username+"','"+Password+"','"+Email+"','"+Birthdate+"','"+sex+"')";
            createDbStatement.executeUpdate(ADDdbRequire);
            String dbRequire = "select * from usertable";
            ResultSet resultDb = createDbStatement.executeQuery(dbRequire);
            while (resultDb.next()) {
                ret[cnt][0] = resultDb.getObject(1).toString().trim();
                ret[cnt][1] = resultDb.getObject(2).toString().trim();
                ret[cnt][2] = resultDb.getObject(3).toString().trim();
                ret[cnt][3] = resultDb.getObject(4).toString().trim();
                ret[cnt++][4] = resultDb.getObject(5).toString().trim();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        writer.println("<table border=\"1\">");
        writer.println("<tr><td>id</td><td>UserName</td><td>Password</td><td>Email</td><td>Birthdate</td><td>Gender</td></tr>");
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < 5; j++) {
                writer.println("<td>" + ret[i][j] + "</td>");
            }
            writer.println("</tr>");
        }
        writer.println("</table>");


    }
}
