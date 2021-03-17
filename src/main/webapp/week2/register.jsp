<%--
  Created by IntelliJ IDEA.
  User: 81519
  Date: 2021/3/13
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    New User Registration<br/>
    Username:<input type="text" name="username" required="true"><br/>
    Password:<input type="text" name="Password"><br/>
    Email:<input type="text" name="Email" minlength="8"><br/>
    Birthdate:<input type="date" name="Birthdate"><br/>
    Gender Male<input type="radio"> Female<input type="radio"><br/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
