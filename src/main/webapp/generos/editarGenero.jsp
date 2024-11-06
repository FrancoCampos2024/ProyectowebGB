<%@page import="com.unu.proyectoWebGB.beans.Genero"%>
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
	
	<%
		String url="http://localhost:8080/ProyectowebCampos/";
		Genero genero = (Genero) request.getAttribute("genero");				
	%>
	
	<div class="container mt-5">

		<form role="form" action="<%=url%>GeneroController" method="POST">
			<input type="hidden" name="op" value="modificar" /> <input
				type="hidden" name="idgenero" value="<%=genero.getIdgenero()%>" />
			<div class="form-group">

				Codigo: <input type="text" name="codigo" class="form-control"
					value="<%=genero.getIdgenero()%>"> <br>
			</div>
			<div class="form-group">
				Nombre: <input type="text" name="nombre" class="form-control"
					value="<%=genero.getNombre()%>"> <br>

			</div>

			<div class="form-group">
				Descripcion: <input type="text" name="descripcion"
					value="<%=genero.getDescripcion()%>" class="form-control"> <br>
			</div>

	
			<input type="submit" class="btn btn-info" value="Guardar"
				name="Guardar"> <a class="btn btn-danger"
				href="<%=url%>GeneroController?op=listar">Cancelar</a>
		</form>

	</div>
	
</body>
</html>