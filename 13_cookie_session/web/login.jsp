<%--
  Created by IntelliJ IDEA.
  User: mxg
  Date: 2020/10/26
  Time: 5:38 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<form action="http://localhost:8080/13_cookie_session/loginServlet" method="get">
    用户名：<input type="text" name="username" value="${cookie.username.value}"><br/>
    密 码：<input type="text" name="password" value=""><br/>
    <input type="submit" value="登陆">


</form>
</body>
</html>
