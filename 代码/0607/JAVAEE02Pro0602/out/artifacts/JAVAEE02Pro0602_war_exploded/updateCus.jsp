
<%@ page import="com.icss.pojo.Customer" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/6/7
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%Customer c = (Customer)request.getAttribute("customer") ;%>
<form action="UpdateCusByIdServlet" method="post">
    <%--用户编号 用户在界面不用看见 但是后端修改需要用户编号  设置type=hidden
       用户编号 设置禁用 disabled(不可以将前端的值传递到后端) readonly (可以将前端的值传递到后端)--%>
    用户编号： <input type="text"  name="cid" value="<%=c.getCid()%>" readonly>
    用户名字:  <input type="text" name="cname" value="<%=c.getCname()%>"> <br>
    用户密码: <input type="password" name="cpwd" value="<%=c.getCpwd()%>"> <br>
    用户年龄: <input type="text" name="cage" value="<%=c.getCage()%>"> <br>
    <input type="submit" value="修改">
</form>
</body>
</html>
