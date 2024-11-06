<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hola</title>

<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<script src="assets/js/bootstrap.min.js">
	
</script>

</head>
<body>
	Quiero aprobar poo2 <br><br>

	<%
String url = "http://localhost:8080/ProyectowebCampos/";
%>
	<a type="button" href="<%=url%>AutoresController?op=listar">Seccion
		Autores</a> <br><br>

	<a type="button" href="<%=url%>EditorialController?op=listar">Seccion
		Editorial</a><br><br>

	<a type="button" href="<%=url%>GeneroController?op=listar">Seccion
		Genero</a><br><br>
	<a type="button" href="<%=url%>LibroController?op=listar">Seccion
		Libro</a>

</body>
</html>