<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="./login2.action" method="get">
    用户名<input type="text" name="uname"><br/>
    密码 <input type="password" name="pwd"><br/>
    <button type="submit">登录</button>
</form>
<a href="./testParams?uname=tom&age=10">giao</a>
<a href="./testUser?name=tom&pwd=jerry&age=10">giao2</a>
</body>
</html>
