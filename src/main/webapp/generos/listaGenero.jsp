
<%@ page import="com.unu.proyectoWebGB.beans.*"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h3>LISTA DE GENEROS</h3>

	<%
	String url = "http://localhost:8080/ProyectowebCampos/";
	%>
	<table border=1>
		<thead>
			<tr>
				<th>Id del genero</th>
				<th>Nombre del genero</th>
				<th>Descripcion del genero</th>
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

</body>
<a type="Button" href="<%=url%>GeneroController?op=nuevo">Nuevo Genero</a>
</html>