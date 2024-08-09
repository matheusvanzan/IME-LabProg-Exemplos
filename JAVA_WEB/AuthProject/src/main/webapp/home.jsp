<%@ page import="com.labprog.entities.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>

    <h2>Home</h2>

    <% User user = (User)request.getSession().getAttribute("user"); %>
    User: <%= user.getUsername() %>

    <br><br>

    <a href="/logout">Sair</a>

</body>
</html>