<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cookie Projetc</title>
</head>
<body>
<h1><%= "Session Project!" %>
</h1>
<br/>

<form method="POST" action="/servlet1">
    Username: <input type="text" name="username" />
    <br>
    Password: <input type="password" name="password" />
    <br>
    <input type="Submit" value="Enviar" />
</form>

</body>
</html>