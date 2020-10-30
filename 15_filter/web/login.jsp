<%--
  Created by IntelliJ IDEA.
  User: mxg
  Date: 2020/10/30
  Time: 9:41 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
this is login.jsp!<br/>
<form action="http://localhost:8080/15_filter/loginServlet" method="get">
    用户名：<input type="text" name="username" value="tong"><br/>
    密  码：<input type="text" name="password" value="123"><br/>
    <input type="submit" value="login">
</form>
</body>
</html>
