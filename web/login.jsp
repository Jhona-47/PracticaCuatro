<%-- 
    Document   : login
    Created on : 08-06-2020, 03:34:31 PM
    Author     : Desktop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="LoginControlador" method="post">
            <label>Usuario</label>
            <input type="text" name="usuario">
            <br>
            <label>Password</label>
            <input type="password" name="password">
            <br>
            <input type="submit" name="Ingresar">
            <br>
        </form>
    </body>
</html>
