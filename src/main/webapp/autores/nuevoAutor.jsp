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
	<h3>AÑADIR AUTOR</h3>
	<%
	String url = "http://localhost:8080/ProyectowebCampos/";
	%>

	<div class="container">

		<form action="<%=url%>AutoresController" method="Post">
			<input type="hidden" name="op" value="insertar"> Nombre del
			autor: <input type="text" name="nombre" id="nombre"
				class="form-control"><br> Nacionalidad del autor: <input
				type="text" name="nacionalidad" id="nacionalidad"
				class="form-control"><br> <input type="submit"
				value="Guardar" name="Guardar" class="btn btn-primary"> <a
				href="<%=url%>AutoresController?op=listar" class="btn btn-secundary">Volver</a>
		</form>

	</div>


</body>
</html>