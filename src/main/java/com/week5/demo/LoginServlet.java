package com.week5.demo;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
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
        String username = request.getParameter("username");
        String Password = request.getParameter("Password");

        PrintWriter writer = response.getWriter();
        boolean isValid = false;
        PreparedStatement prep = null;
        ResultSet re = null;
        try {
            String dbRequire = "select * from usertable where username=? and password=?";
            prep = dbConn.prepareStatement(dbRequire);
            prep.setString(1, username);
            prep.setString(2, Password);
            re = prep.executeQuery();
            if (re.next()) {
                isValid = true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (isValid) {
            writer.println("Login Success!!!");
            writer.println("Welcome" + username);
        } else {
            writer.println("Username or Password Error!!!");
        }
    }
}
