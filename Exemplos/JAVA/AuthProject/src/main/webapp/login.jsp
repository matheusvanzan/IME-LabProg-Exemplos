<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>

    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h2>Login</h2>

    <form method="POST" action="/login">
        <label>
            Username:
            <input type="text" name="username" placeholder="Usuario" />
        </label>
        <br><br>
        <label>
            Senha:
            <input type="password" name="password" placeholder="Sua senha">
        </label>
        <br>

        <span class="error"><%
            String error = (String) request.getSession().getAttribute("error");

            if (error != null) {
                out.print("Erro: " + error);
            }
        %></span>

        <br>
        <input type="submit" value="Login" />

        <br><br>
        <a href="/signup">Criar conta</a>
    </form>

</body>
</html>