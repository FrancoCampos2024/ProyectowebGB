<%@page import="com.unu.proyectoWebGB.beans.Libro"%>
<%@page import="java.util.List"%>
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
	<h3>LISTA DE LIBROS</h3>
	<%
	String url = "http://localhost:8080/ProyectowebCampos/";
	List<Libro> Libros = (List<Libro>) request.getAttribute("libros");
	%>

	<div class="container">
		<table class="table">

			<thead>
				<tr>
					<th>ID Libro</th>
					<th>Nombre</th>
					<th>Existencia</th>
					<th>Precio</th>
					<th>Autor</th>
					<th>Editorial</th>
					<th>Genero</th>
					<th>Descripcion</th>
				</tr>
			</thead>

			<tbody>
				<%
				if (Libros != null) {
					for (Libro l : Libros) {
				%>
				<tr>
					<td><%=l.getIdautor()%></td>
					<td><%=l.getNombre()%></td>
					<td><%=l.getExistencia()%></td>
					<td><%=l.getPrecio()%></td>
					<td><%=l.getAutor()%></td>
					<td><%=l.getEditorial()%></td>
					<td><%=l.getGenero()%></td>
					<td><%=l.getDescripcion()%></td>
				</tr>
				<%
				}
				}
				%>

			</tbody>
		</table>


	</div>

</body>

<a href="<%=url%>LibroController?op=nuevo">Nuevo libro</a>

</html>