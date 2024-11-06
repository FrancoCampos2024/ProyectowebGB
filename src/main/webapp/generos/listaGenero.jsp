
<%@ page import="com.unu.proyectoWebGB.beans.*"%>
<%@ page import="java.util.*"%>
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


	<h3>LISTA DE GENEROS</h3>
	<div class="container">
		<%
		String url = "http://localhost:8080/ProyectowebCampos/";
		%>
		<table class="table">
			<thead>
				<tr>
					<th>Id del genero</th>
					<th>Nombre del genero</th>
					<th>Descripcion del genero</th>
					<th>OPERACIONES</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Genero> listagenero = (List<Genero>) request.getAttribute("listaGenero");
				if (listagenero != null) {

					for (Genero g : listagenero) {
				%>
				<tr>
					<td><%=g.getIdgenero()%></td>
					<td><%=g.getNombre()%></td>
					<td><%=g.getDescripcion()%></td>
					<td><a href="<%=url%>GeneroController?op=obtener&id=<%=g.getIdgenero()%>" class="btn btn-secundary">Editar</a>
					<a href="<%=url%>GeneroController?op=eliminar&id=<%=g.getIdgenero()%>" class="btn btn-danger">Eliminar</a>
					</td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td>No hay dato</td>
					<td>No hay dato</td>
					<td>No hay dato</td>
				</tr>
				<%
				}
				%>

			</tbody>

		</table>

	</div>

</body>

<div class="container">
	<a type="Button" href="<%=url%>GeneroController?op=nuevo"
		class="btn btn-primary">Nuevo Genero</a> <a type="button"
		href="<%=url%>" class="btn btn-primary">Menu</a>

</div>

</html>