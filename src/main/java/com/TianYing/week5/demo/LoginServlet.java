package com.TianYing.week5.demo;


import com.TianYing.dao.UserDao;
import com.TianYing.model.User;

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
    Connection con=null;
    @Override
    public void init() throws ServletException {
     //   try{
       //     Class.forName(getServletConfig().getServletContext().getInitParameter("driver"));
    //        dbConn= DriverManager.getConnection(getServletConfig().getServletContext().getInitParameter("url"),getServletConfig().getServletContext().getInitParameter("username"),getServletConfig().getServletContext().getInitParameter("password"));
   //         System.out.println(dbConn);
     //   }catch (Exception e){System.out.println(e);}
   super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String Password = request.getParameter("Password");
        PrintWriter writer=response.getWriter();

        UserDao userDao=new UserDao();
        try{
            User user=userDao.findByUsernamePassword(con,username,Password);
            if (user!=null){
                request.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);

            }else {
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }


       /* try {
            String dbRequire = "select * from usertable where username=? and password=?";
            prep = dbConn.prepareStatement(dbRequire);
            prep.setString(1, username);
            prep.setString(2, Password);
            re = prep.executeQuery();
            if (re.next()) {
                isValid = true;
                request.setAttribute("id",re.getInt("id"));
                request.setAttribute("username",re.getString("username"));
                request.setAttribute("Password",re.getString("Password"));
                request.setAttribute("Email",re.getString("Email"));
                request.setAttribute("Gender",re.getString("Gender"));
                request.setAttribute("Birthdate",re.getString("Birthdate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (isValid) {
            request.setAttribute("message","Username or Password Error!!!");
            request.getRequestDispatcher("login.jsp").forward(request,response);
           // writer.println("Login Success!!!");
           // writer.println("Welcome" + username);*/
        }
    }


