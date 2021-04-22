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
<%
    Cookie[] allCookies=request.getCookies();
    String username="",password="",rememberMeVal="";
    if (allCookies!=null){
        for (Cookie c:allCookies){
            if (c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if (c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if (c.getName().equals("cRememberMe")){
                rememberMeVal=c.getValue();
            }
        }
    }
%>

<form action="login" method="post">
    Username:<input type="text" name="username" value="<%=username%>"><br>
    Password:<input type="password" name="Password" value="<%=password%>"><br>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVal.equals("1") ?"checked":""%>checked/>RememberMe<br/>
    <input type="submit" value="Login">
</form>
</body>
<%@include file="footer.jsp"%>
