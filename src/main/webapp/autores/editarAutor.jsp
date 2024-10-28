<%@page import="com.unu.proyectoWebGB.beans.Autor"%>
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
	Autor autor;
	HttpSession sesion = request.getSession();

	if (request.getAttribute("autor") == null) {
		autor = new Autor();
	} else {
		autor = (Autor) request.getAttribute("autor");
		System.out.println(autor.getIdAutor());
		System.out.println(autor.getNombre());
	}
	%>

	<form role="form" action="<%=url%>AutoresController" method="POST">
		<input type="hidden" name="op" value="modificar" /> <input
			type="hidden" name="idautor" value="<%=autor.getIdAutor()%>" />

		<h1>REGISTRO DE AUTOR</h1>
		Codigo: <input type="text" name="codigo"
			value="<%=autor.getIdAutor()%>"> <br> Nombre: <input
			type="text" name="nombre" value="<%=autor.getNombre()%>"> <br>
		Nacionalidad: <input type="text" name="nacionalidad"
			value="<%=autor.getNacionalidad()%>"> <br> <input
			type="submit" class="btn btn-info" value="Guardar" name="Guardar">
		<a class="btn btn-danger" href="<%=url%>AutoresController?op=listar">Cancelar</a>
	</form>


</body>
</html>