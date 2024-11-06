<%@page import="com.unu.proyectoWebGB.beans.Autor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<script src="assets/js/bootstrap.min.js">
	
</script>
</head>
<body>

	<h3>EDITAR AUTOR</h3>
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

	<div class="container mt-5">
		<form role="form" action="<%=url%>AutoresController" method="POST">
			<input type="hidden" name="op" value="modificar" /> <input
				type="hidden" name="idautor" value="<%=autor.getIdAutor()%>" />

			<div class="form-group">
				<label for="codigo">Código:</label> <input type="text"
					class="form-control" name="codigo" id="codigo"
					value="<%=autor.getIdAutor()%>" readonly>
			</div>

			<div class="form-group">
				<label for="nombre">Nombre:</label> <input type="text"
					class="form-control" name="nombre" id="nombre"
					value="<%=autor.getNombre()%>"
					placeholder="Ingrese el nombre del autor">
			</div>

			<div class="form-group">
				<label for="nacionalidad">Nacionalidad:</label> <input type="text"
					class="form-control" name="nacionalidad" id="nacionalidad"
					value="<%=autor.getNacionalidad()%>"
					placeholder="Ingrese la nacionalidad del autor">
			</div>

			<button type="submit" class="btn btn-info">Guardar</button>
			<a href="<%=url%>AutoresController?op=listar" class="btn btn-danger">Cancelar</a>
		</form>
	</div>


</body>
</html>