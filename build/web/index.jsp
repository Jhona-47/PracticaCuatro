<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Anuncio"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<Anuncio> lista = (List<Anuncio>) request.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BLOG DE SALUD</title>
    </head>
    <body>
        <h1 align="center"style="color:#FF0000">BLOG DE SALUD</h1>
        <p><a href="MainController?op=nuevo">Nueva Entrada</p>
        
        <c:forEach var="item" items="${lista}">
            <hr> 
            <p>${item.fecha}</p>
            <h2 align="center">${item.titulo}</h2>
            <h3 aling="right">${item.anuncio}</h3 >
            <h4>Autor:administrador</h4>
            <h5 align="right"><a href="MainController?op=editar&id=${item.id}">Editar </a>
            <a align="right" href="MainController?op=eliminar&id=${item.id}"> Eliminar</a></h5>
            
           
        </c:forEach>
    </body>
</html>
