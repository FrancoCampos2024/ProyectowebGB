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
	<h3>NUEVA EDITORIAL</h3>
	<form action="<%=url%>EditorialController" method="Post">
	<input type="hidden" name="op" value="insertar">
	Nombre Editorial: <input type="text" name="nombre" id="nombre"><br>
	Contacto Editorial: <input type="text" name="contacto" id="contacto"><br>
	Telefono Editorial: <input type="text" name="telefono" id="telefono"><br>
	<input type= "submit" value="Guardar" name="Guardar">
	<a href="<%=url%>EditorialController?op=listar">Volver</a>
	</form>

</body>
</html>