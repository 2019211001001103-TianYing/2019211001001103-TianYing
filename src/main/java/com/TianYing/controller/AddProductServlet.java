package com.TianYing.controller;

import com.TianYing.dao.ProductDao;
import com.TianYing.model.Category;
import com.TianYing.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddProductServlet", value = "/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {
    Connection con=null;
    public void init(){
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category=new Category();
        List<Category> categoryList= null;
        try {
            categoryList = category.findAllCategory(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("categoryList",categoryList);
        String path="/WEB-INF/views/admin/addProduct.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName=request.getParameter("productName");
        System.out.println(productName);
        Double price=request.getParameter("price")!=null?Double.parseDouble(request.getParameter("price")):0.0;
        int categoryId=request.getParameter("categoryId")!=null?Integer.parseInt(request.getParameter("categoryId")):0;
        String productDescription =request.getParameter("productDescription");
        InputStream inputStream=null;
        Part filePart =request.getPart("picture");
        if(filePart!=null) {
            System.out.println(filePart.getName()+"size:"+filePart.getSize());
            inputStream=filePart.getInputStream();
        }
        Product product=new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setProductDescription(productDescription);
        product.setCategoryId(categoryId);
        System.out.println(product);
        ProductDao dao= new ProductDao();
        int i=0;
        try{
            i=dao.save(product,inputStream,con);
        }catch (Exception e) {
            System.out.println(e);
        }


    }
}
