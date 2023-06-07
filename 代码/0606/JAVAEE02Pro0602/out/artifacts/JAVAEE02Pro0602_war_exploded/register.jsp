<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/6/6
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% Object msg = request.getAttribute("msg");%>
<% if (msg != null) { %>
<div style="color:#ff0000"><%=msg%></div>
<%
    }
%>
<form action="RegisterServlet" method="post">

    用户名字:  <input type="text" name="cname"> <br>
    用户密码: <input type="password" name="cpwd"> <br>
    用户年龄: <input type="text" name="cage"> <br>
    <input type="submit" value="注册">
</form>
</body>
</html>
