<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="/user/login.action"  method="get">
    用户名<input type="text" name="uname"> <br>
    密码 <input type="password" name="pwd"> <br>
    <button type="submit">登录</button>
</form>

<a href="/user/testParams?uname=tom&age=18">测试接收参数</a>

<a href="/user/testUser?uname=tom&pwd=abc&age=18">测试接收参数对象</a>

</body>
</html>
