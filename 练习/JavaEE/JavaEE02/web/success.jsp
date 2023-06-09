<%--
  Created by IntelliJ IDEA.
  User: tyza66
  Date: 2023/6/5
  Time: 9:19
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" isErrorPage="true" %>
<%--指定页面错位 则条拽难道只当的错误页面 isErrorPage="true"代表有异常对象产生 --%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>提交成功</h4>
<%
    //在这里就可以写java代码了 request是一个jsp内置的对象
    String uname = (String)request.getAttribute("uname");
    /*
    * 前端这嘎达可以用xxxScope获取存进去的attribute 而且如果不屑来自那个scope就会自动从小到大的范围去找
    * el表达式中对于null的表示 空字符串就是什么都不显示 但是如果是null字符串就会显示
    * */
%>
<%=uname%>
</body>
</html>
