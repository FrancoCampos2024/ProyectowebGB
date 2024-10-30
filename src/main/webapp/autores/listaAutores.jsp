<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.unu.proyectoWebGB.beans.Autor"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>titulo</title>
</head>
<body>

	<%
	String url = "http://localhost:8080/ProyectowebCampos/";
	%>
	<a type="button" href="<%=url%>AutoresController?op=nuevo">Nuevo
		Autor</a>


	<table border=1>
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
					href="<%=url%>AutoresController?op=obtener&id=<%=autor.getIdAutor()%>">Editar</a>
					<a
					href="<%=url%>AutoresController?op=eliminar&id=<%=autor.getIdAutor()%>">Eliminar</a>
				</td>

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
</body>
</html>