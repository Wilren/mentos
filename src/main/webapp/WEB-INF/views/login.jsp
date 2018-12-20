<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/public.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
</head>
<body>
<h2>自定义登录页面</h2>
<hr>

${error}
<c:url value="/login" var="logoutUrl"/>
<form action="${logoutUrl}" method="POST" name="f">
    用户名<input type="text" name="username"/> <br>
    密码 <input type="password" name="password"> <br>
    <input type="submit" value="登录">
</form>
</body>
</html>