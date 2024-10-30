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
	
	<h3>Nuevo Genero</h3>
	<form action="<%=url%>GeneroController" method="Post">
	<input type="hidden" name="op" value="insertar">
	
	Nombre: <input type="text" name="nombre" id="nombre"><br>
	Descripcion: <input type="text" name="descripcion" id="descripcion"><br>
	
	<input type="submit" values="Guardar" name="Guardar">
	<a href="<%=url%>GeneroController?op=listar">Volver</a>
		
	</form>



</body>
</html>