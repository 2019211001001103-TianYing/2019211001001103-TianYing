<%--
  Created by IntelliJ IDEA.
  User: 81519
  Date: 2021/3/13
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
This is my jsp.<br>
<form method="post" action="register">
    New User Registration<br/>
    Username:<input type="text" name="username" required="required"><br/>
    Password:<input type="text" name="Password" required="required" minlength="8"><br/>
    Email:<input type="text" name="Email"><br/>
    Birthdate:<input type="date" name="Birthdate"><br/>
    Gender<input type="radio" name="sex" value="male">male<input type="radio" name="sex" value="female"/>Female<br/>
    <input type="submit" value="Register"/>
</form>
<%@include file="footer.jsp"%>