<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/6/5
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
主页面
<h1>欢迎<%=(String)request.getAttribute("cname")%>登录</h1>
</body>
</html>
