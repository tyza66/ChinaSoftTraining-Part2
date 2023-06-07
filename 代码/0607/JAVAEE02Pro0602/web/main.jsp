<%@ page import="java.util.List" %>
<%@ page import="com.icss.pojo.Customer" %>
<%@ page import="java.util.ArrayList" %><%--
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
<%--<h1>欢迎<%=(String)request.getAttribute("cname")%>登录</h1>--%>

<a href="SelectAllCusServlet">查询所有的用户</a>
<% Object msg = request.getAttribute("msg");%>
<% if (msg != null) { %>
<div style="color:#ff0000"><%=msg%></div>
<%
    }
%>
<form action="">
    姓名<input type="text">
    年龄 <input type="text">
    <input type="submit" value="搜索">
</form>
<table>
    <thead>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>密码</th>
            <th>年龄</th>
            <th>操作</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
    <%List<Customer> list = (ArrayList)request.getAttribute("list");
     if (list != null && list.size() > 0) {
        for (Customer tmp : list) {  %>
            <tr>
                <td><%=tmp.getCid()%></td>
                <td><%=tmp.getCname()%></td>
                <td><%=tmp.getCpwd()%></td>
                <td><%=tmp.getCage()%></td>
                <td><a href="DeleteCusByIdServlet?cid=<%=tmp.getCid()%>">删除</a></td>
                <td><a href="SelectCusByIdServlet?cid=<%=tmp.getCid()%>">修改</a></td>
            </tr>
   <%     }
     }
    %>

    </tbody>
</table>

</body>
</html>
