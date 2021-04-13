<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 81519
  Date: 2021/4/11
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User List</h1>
<table border="1">
    <tr>
        <td>id</td><td>username</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthdate</td>
    </tr>
    <%ResultSet rs=(ResultSet) request.getAttribute("rsname");
    if(rs==null){
        %>
        <tr>
        No Date!!!
    </tr>
    <%}else 
        while (rs.next())
            {
                out.println("<tr>");
                out.println("<td>"+rs.getInt("id")+"</td>");
                out.println("<td>"+rs.getString("username")+"</td>");
                out.println("<td>"+rs.getString("Password")+"</td>");
                out.println("<td>"+rs.getString("Email")+"</td>");
                out.println("<td>"+rs.getString("Gender")+"</td>");
                out.println("<td>"+rs.getString("Birthdate")+"</td>");
                
            }
        %>
</table>
<%@include file="footer.jsp"%>

