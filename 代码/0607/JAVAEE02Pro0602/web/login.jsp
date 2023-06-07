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
<%--获取所有Cookies 如果找到Cookie key是cname 对应的值获取出来  找到key是cpwd 对应的值获取出来
 判断如果用户名的值和密码的值不为空 直接跳转到后端 LoginServlet--%>
<%
    Cookie[] cs  = request.getCookies();
    String name = null;
    String pwd = null;
    if (cs != null && cs.length > 0) {
        for (Cookie tmp : cs) {
            if ("cname".equals(tmp.getName())) {
                 name = tmp.getValue();
            }
            if ("cpwd".equals(tmp.getName())) {
                pwd = tmp.getValue();
            }
        }
    }

    if (name != null && pwd != null) {
//        发送get请求  doGet()处理
        request.getRequestDispatcher("LoginServlet?cname="+name+"&cpwd="+pwd).forward(request,response);
    }

%>




<% Object msg = request.getAttribute("msg");%>
<% if (msg != null) { %>
  <div style="color:#ff0000"><%=msg%></div>
<%
}
%>



<form action="LoginServlet" method="post">
    用户名 : <input type="text" name="cname"> <br>
    密码 : <input type="password" name="cpwd"> <br>
    选择免登录时间:<select name="time">
                    <option value=""></option>
                    <option value="1">1天</option>
                    <option value="3">3天</option>
                    <option value="5">5天</option>
                </select>
    <input type="submit" value="登录">
    <input type="button" value="没有账号呢?请注册" onclick="location.href='register.jsp'">
</form>
</body>
</html>
