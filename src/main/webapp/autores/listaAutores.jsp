<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.unu.proyectoWebGB.beans.Autor"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>titulo</title>

<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<script src="assets/js/bootstrap.min.js">
	
</script>

<script>
	function eliminar(id) {
		if (confirm("¿Desea eliminar el registro?") == true) {
			location.href = "AutoresController?op=eliminar&id=" + id;

		} else {

		}
	}
</script>

</head>
<body>
	<h3>LISTA DE AUTORES</h3>
	<%
	String url = "http://localhost:8080/ProyectowebCampos/";
	%>

	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Codigo del autor</th>
					<th>Nacionalidad</th>
					<th>Nombre del autor</th>
					<th>Operaciones</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Autor> listaAutores = (List<Autor>) request.getAttribute("listaAutores");

				// Verificar si la lista no es nula
				if (listaAutores != null) {
					// Iterar sobre la lista de autores
					for (Autor autor : listaAutores) {
				%>
				<tr>
					<td><%=autor.getIdAutor()%></td>
					<td><%=autor.getNombre()%></td>
					<td><%=autor.getNacionalidad()%></td>
					<td><a
						href="<%=url%>AutoresController?op=obtener&id=<%=autor.getIdAutor()%>"
						class="btn btn-secundary">Editar</a> <a
						href="javascript:eliminar(<%=autor.getIdAutor()%>) "
						class="btn btn-danger">Eliminar</a></td>

				</tr>
				<%
				}
				} else {
				%>

				<tr>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td></td>
				</tr>

				<%
				}
				%>


			</tbody>
		</table>

	</div>


</body>


<div class="container">
	<a type="button" href="<%=url%>AutoresController?op=nuevo"
		class="btn btn-primary">Nuevo Autor</a> <a type="button"
		href="<%=url%>" class="btn btn-primary">Menu</a>

</div>


</html>