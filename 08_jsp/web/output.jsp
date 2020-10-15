<%--
  Created by IntelliJ IDEA.
  User: mxg
  Date: 2020/10/15
  Time: 3:07 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    out.write("out1 的 <br/>");
    out.write("out2 的 <br/>");


    response.getWriter().write("11111111111response.getWriter().write  <br/>");
    response.getWriter().write("222222222222response.getWriter().write    <br/>");

        out.write(12);
        out.print(12);


%>
</body>
</html>
