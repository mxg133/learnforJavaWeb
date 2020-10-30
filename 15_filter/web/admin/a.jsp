<%--
  Created by IntelliJ IDEA.
  User: mxg
  Date: 2020/10/30
  Time: 9:30 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    System.out.println("a.jsp runing.......");
    Object user = session.getAttribute("user");
    if (user == null) {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
        return;
    }
%>
我是a.jsp
</body>
</html>
