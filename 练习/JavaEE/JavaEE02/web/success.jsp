<%--
  Created by IntelliJ IDEA.
  User: tyza66
  Date: 2023/6/5
  Time: 9:19
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>提交成功</h4>
<%
    //在这里就可以写java代码了 request是一个jsp内置的对象
    String uname = (String)request.getAttribute("uname");
%>
<%=uname%>
</body>
</html>
