<%--
  Created by IntelliJ IDEA.
  User: 81519
  Date: 2021/4/6
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<body>
<h1>Login</h1>
<%
    if (!(request.getAttribute("message")==null)){
        out.print("<h3>"+request.getAttribute("message")+"</h3>");
    }
%>

<form action="login" method="post">
    Username:<input type="text" id="username" name="username"><br>
    Password:<input type="password" id="password" name="password"><br>
    <input type="submit" value="login">
</form>
</body>
<%@include file="footer.jsp"%>
