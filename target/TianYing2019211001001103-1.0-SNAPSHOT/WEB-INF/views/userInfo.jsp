<%@ page import="com.TianYing.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 81519
  Date: 2021/4/11
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    User user=(User)request.getAttribute("user");
%>
<table>
    <tr>
        <td>username:</td><td><%=user.getUsername()%></td>
    </tr><tr>
        <td>password:</td><td><%=user.getPassword()%></td>
</tr><tr>
        <td>Email:</td><td><%=user.getEmail()%></td>
</tr><tr>
        <td>Birthdate:</td><td><%=user.getBirthdate()%></td>
</tr><tr>
        <td>sex:</td><td><%=user.getSex()%></td>
    </tr>
</table>
<%@include file="footer.jsp"%>