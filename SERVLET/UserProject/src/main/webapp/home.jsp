<%@ page import="com.labprog.userproject.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Home</h1>
<br/>

<%
    User u = (User)request.getSession().getAttribute("user");

%>

<p>Username: <%= u.getUsername() %></p>

</body>
</html>