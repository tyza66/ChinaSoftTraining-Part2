<%@ page import="com.sdm.pojo.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: tyza66
  Date: 2023/6/5
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Customer customer = (Customer) request.getAttribute("customer");
    List<Customer> list = (List<Customer>) request.getAttribute("all");
    if (customer != null) {
%>
<h3>登录成功</h3>
ID：<%=customer.getId()%><br>
用户名：<%=customer.getCname()%><br>
密码：<%=customer.getCpwd()%><br>
年龄：<%=customer.getCage()%><br>
<% } else {%>
<h3>登录失败</h3>
<% }%>
<%if (list.size() != 0) {%>
<%for (Customer c : list) {%>
<%=c.toString()%><br>
<%
        }
    }
%>

</body>
</html>
