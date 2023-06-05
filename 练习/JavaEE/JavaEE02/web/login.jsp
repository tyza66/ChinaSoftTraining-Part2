<%--
  Created by IntelliJ IDEA.
  User: tyza66
  Date: 2023/6/5
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if(request.getAttribute("status").equals("ok")){
%>
<h3>注册成功</h3>
<%}%>
<form action="LoginServlet" method="get">
  用户名：<input name="cname" type="text"/><br/>
  密码：<input name="cpwd" type="password"><br/>
  <input type="submit" value="登录">
</form>
<a href="./register.jsp">注册</a>
</body>
</html>
