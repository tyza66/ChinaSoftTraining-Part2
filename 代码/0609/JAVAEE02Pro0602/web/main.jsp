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
<%--引入jstl的核心标签库 prefix="c" 前缀--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
主页面


<%--登录验证  获取后端session的值 判断值是否为null 如果是null 没有登录 则跳转到登录页面--%>
<%--<% Object obj = session.getAttribute("cname");
    if (obj == null) {
        response.sendRedirect("login.jsp");
    }
%>--%>
<h1>欢迎<%=(String)session.getAttribute("cname")%>登录</h1>
<%--EL表达式(表达式语言) 替换<%=%>表达式  作用域范围:pageScope < requestScope < sessionScope < applicationScope
按照对应的作用域范围进行获取  注意：作用域范围指定可以省略 自动从pageScope查找到applicationScope
对于null表示  EL表达式(表达式语言) 什么也不显示  <%=%> null --%>
<h1>EL-欢迎${sessionScope.cname}登录</h1>
<%--application jsp内置对象 上下文对象--%>
<h1>该网站被访问<%=application.getAttribute("count")%>次</h1> <%--次数统计--%>
<h1>EL-该网站被访问${count}次</h1>

<a href="SelectAllCusServlet">查询所有的用户</a>
<% Object msg = request.getAttribute("msg");%>
<% if (msg != null) { %>
<%--<div style="color:#ff0000"><%=msg%></div>--%>
<div style="color:#ff0000">${requestScope.msg}</div>

<%
    }
%>

<form action="">
    姓名<input type="text">
    年龄 <input type="text">
    <input type="submit" value="搜索">
</form>
<a href="LogOutServlet">退出</a>
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
   <%-- <%List<Customer> list = (ArrayList)request.getAttribute("list");
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
    %>--%>
   <c:if test="${list != null && list.size() > 0}">
        <c:forEach var="tmp" items="${list}">
            <tr>
                <td>${tmp.cid}</td>
                <td>${tmp.cname}</td>
                <td>${tmp.cpwd}</td>
                <td>${tmp.cage}</td>
                <td><a href="DeleteCusByIdServlet?cid=${tmp.cid}>">删除</a></td>
                <td><a href="SelectCusByIdServlet?cid=${tmp.cid}">修改</a></td>
            </tr>
        </c:forEach>
   </c:if>
    </tbody>
</table>


</body>
</html>
