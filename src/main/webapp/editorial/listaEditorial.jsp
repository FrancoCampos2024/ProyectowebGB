<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.unu.proyectoWebGB.beans.Editorial"%>
<%@ page import="java.util.*"%>
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

	<div class="container">
		<h3>LISTA DE EDITORIALES</h3>
		<%
		String url = "http://localhost:8080/ProyectowebCampos/";
		%>

		<table class="table">
			<thead>
				<tr>
					<th>Id Editorial</th>
					<th>Nombre editorial</th>
					<th>Contacto Editorial</th>
					<th>Telefono</th>
					<th>Operaciones</th>
				</tr>
			</thead>


			<tbody>
				<%
				List<Editorial> listaEditorial = (List<Editorial>) request.getAttribute("listaEditorial");

				if (listaEditorial != null) {

					for (Editorial edit : listaEditorial) {
				%>

				<tr>
					<td><%=edit.getIdeditorial()%></td>
					<td><%=edit.getNombre()%></td>
					<td><%=edit.getContacto()%></td>
					<td><%=edit.getTelefono()%></td>
					<td><a type="button"
						href="<%=url%>EditorialController?op=obtener&id=<%=edit.getIdeditorial()%>">Editar</a>
						<a type="button"
						href="<%=url%>EditorialController?op=eliminar&id=<%=edit.getIdeditorial()%>" class="btn btn-danger">Eliminar</a>
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
	<a type="button" href="<%=url%>EditorialController?op=nuevo"
		class="btn btn-secondary">Nueva Editorial</a> <a type="button"
		href="<%=url%>" class="btn btn-secondary">Menu</a>
</div>


</html>