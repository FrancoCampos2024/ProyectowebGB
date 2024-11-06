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
	String url = "http://localhost:8080/ProyectowebCampos/";
	%>

	<h3>AÑADIR GENERO</h3>
	<div class="container">
		<form action="<%=url%>GeneroController" method="Post">
			<input type="hidden" name="op" value="insertar"> Nombre: <input
				type="text" name="nombre" id="nombre" class="form-control"><br>
			Descripcion: <input type="text" name="descripcion" id="descripcion"
				class="form-control"><br> 
				<input type="submit" class="btn btn-primary"
				 value="Guardar" name="Guardar"> <a
				href="<%=url%>GeneroController?op=listar" class="btn btn-primary">Volver</a>

		</form>

	</div>




</body>
</html>