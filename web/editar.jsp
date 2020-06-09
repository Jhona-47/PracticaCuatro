<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.emergentes.modelo.Anuncio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Anuncio anuncio = (Anuncio)request.getAttribute("anuncio");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center"> NUEVO  / EDITAR 
        </h1>
        <form action="MainController" method="post">
            <table>
                <input type="hidden" name="id" value="${anuncio.id}">

                <tr>
                   <td>titulo</td>
                   <td><input type="text" name="titulo" style="width:600px" value="${anuncio.titulo}" l></td>
                </tr>
                <tr>
                   <td>anuncio</td>
                   <td><input type="text" name="anuncio" style="width:900px ; heigth:12px" value="${anuncio.anuncio}"></td>
                </tr>
                <tr>
                        
                   <td></td>
                   <td><input type="submit" value="Enviar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
