<%--
  Created by IntelliJ IDEA.
  User: mxg
  Date: 2020/10/30
  Time: 11:45 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    System.out.println(" target.jap runing....... ");
    System.out.println(" target 的 线程： " + Thread.currentThread().getName());
    System.out.println(" target " + request.getParameter("username"));

%>
</body>
</html>
