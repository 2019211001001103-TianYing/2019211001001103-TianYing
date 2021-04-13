<%--
  Created by IntelliJ IDEA.
  User: 81519
  Date: 2021/4/11
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<table>
    <tr>
        <td>username:</td><td><%=request.getAttribute("username")%></td>
    </tr><tr>
        <td>password:</td><td><%=request.getAttribute("password")%></td>
</tr><tr>
        <td>Email:</td><td><%=request.getAttribute("Email")%></td>
</tr><tr>
        <td>Birthdate:</td><td><%=request.getAttribute("Birthdate")%></td>
</tr><tr>
        <td>sex:</td><td><%=request.getAttribute("sex")%></td>
    </tr>
</table>
<%@include file="footer.jsp"%>