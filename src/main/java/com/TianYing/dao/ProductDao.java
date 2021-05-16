package com.TianYing.dao;

import com.TianYing.model.Product;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    public int save(Product product, InputStream picture,Connection con) throws SQLException {
        int n = 0;
        System.out.println("IN SAVE");
        String sql = "insert into Product(ProductName,ProductDescription,picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        System.out.println(product.getProductName());
        pt.setString(1, product.getProductName());
        System.out.println(product.getProductDescription());
        pt.setString(2, product.getProductDescription());
        if(picture!=null) {
            //for sql server
            System.out.println(picture);
            pt.setBinaryStream(3, picture);
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        System.out.println(product.getPrice());
        pt.setDouble(4, product.getPrice());
        System.out.println(product.getCategoryId());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        System.out.println(n);
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {

        int n = 0;
        String sql = "delete from Product where ProductId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1, productId);
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        int n = 0;
        String sql = "update Product set ProductName=?,ProductDescription=?,Picture=?,price=?,CategoryID=? where ProductId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, instance.getProductName());
        pt.setString(2, instance.getProductDescription());
        if(instance.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, instance.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, instance.getPrice());
        pt.setInt(5, instance.getCategoryId());
        pt.setInt(6,instance.getProductId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {

        List<Product> list=new ArrayList<Product>();
        String queryString="select * from Product where productId=?";
        PreparedStatement pt =con.prepareStatement(queryString);
        pt.setInt(1,productId);
        ResultSet rs=pt.executeQuery();
        Product product=new Product();
        while (rs.next()){

            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));

        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {

        List<Product> list=new ArrayList<Product>();
        String queryString="select * from Product where categoryId=?";
        PreparedStatement pt =con.prepareStatement(queryString);
        pt.setInt(1,categoryId);
        ResultSet rs=pt.executeQuery();
        while (rs.next()){
            Product product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            list.add(product);
        }
        return list;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> list=new ArrayList<Product>();
        String queryString="select * from Product";
        PreparedStatement pt =con.prepareStatement(queryString);
        ResultSet rs=pt.executeQuery();
        while (rs.next()){
            Product product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            list.add(product);
        }
System.out.println("successful");
        return list;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        return null;
    }
    public byte[] getPictureById(Integer productId,Connection con) throws SQLException {
        byte[] imgBytes=null;
        String sql="select picture from product where productId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs=pt.executeQuery();
        while (rs.next()){
            Blob blob=rs.getBlob("picture");
            imgBytes=blob.getBytes(1,(int)blob.length());
        }
        return imgBytes;
    }
}
