package com.TianYing.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class HelloWorldServlet extends HttpServlet {
    String Name="TianYing";

    String ID="2019211001001103";



    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {
        //get writer - java.io
        PrintWriter writer = response.getWriter();
        Date date=new Date();
        writer.println("NAME: "+Name);
        writer.println("ID: "+ID);
        writer.println("Date and Time"+date.toString());
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
