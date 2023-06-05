<%--
  Created by IntelliJ IDEA.
  User: Administrator
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
<% Object msg = request.getAttribute("msg");%>
<% if (msg != null) { %>
  <div style="color:#ff0000"><%=msg%></div>
<%
}
%>
<form action="LoginServlet" method="post">
    用户名 : <input type="text" name="cname"> <br>
    密码 : <input type="password" name="cpwd"> <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
