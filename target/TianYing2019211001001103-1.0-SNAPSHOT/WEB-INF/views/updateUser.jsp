<%--
  Created by IntelliJ IDEA.
  User: 81519
  Date: 2021/4/27
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Update</h1>
<%
    User u=(User) session.getAttribute("user");
%>

<form method="post" action="updateUser">
    <input type="hidden" name="id" value="<%=u.getId()%>">

    Username:<input type="text" name="Username" value="<%=u.getUsername()%>"/><br/>
    Password:<input type="password" name="password" value="<%=u.getPassword()%>"/><br/>
    Email:<input type="email" name="Email" value="<%=u.getEmail()%>"/><br/>
    Gender:<input type="radio" name="sex" value="male" <%="male".equals(u.getGender())?"checked":""%>>male
    <input type="radio" name="sex" value="female" <%="female".equals(u.getGender())?"checked":""%>/>Female<br/>
    Birthdate:<input type="date" name="BirthDate" value="<%=u.getBirthDate()%>"><br/>
    <input type="submit" value="Save Changes"/>
</form>

<%@include file="footer.jsp"%>
