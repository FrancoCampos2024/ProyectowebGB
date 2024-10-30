<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String url = "http://localhost:8080/ProyectowebCampos/";
	%>
	<h3>Nuevo Autor</h3>
	<form action="<%=url%>AutoresController" method="Post">
	<input type="hidden" name = "op" value= "insertar">
	Nombre del autor: <input type="text" name ="nombre" id = "nombre"><br>
	Nacionalidad del autor: <input type="text" name ="nacionalidad" id="nacionalidad"><br>
	<input type ="submit" value="Guardar" name="Guardar">
	<a href= "<%=url%>AutoresController?op=listar">Volver</a>
	</form>

</body>
</html>