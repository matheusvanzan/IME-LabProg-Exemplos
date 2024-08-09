<%--
  Created by IntelliJ IDEA.
  User: Vanzan
  Date: 21/03/2024
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <h2>Faça seu login</h2>

    <form method="POST" action="/login">
        <label>
            Username:
            <input type="text" name="username" placheholder="Usuario" />
        </label>
        <label>
            Senha:
            <input type="password" name="password" placeholder="Sua senha">
        </label>
        <br>
        <input type="submit" value="Login" />
    </form>

</body>
</html>
