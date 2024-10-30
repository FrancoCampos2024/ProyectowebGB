<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.unu.proyectoWebGB.beans.Editorial"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String url = "http://localhost:8080/ProyectowebCampos/";
	%>

	<table border=1>
		<thead>
			<tr>
				<th>Id Editorial</th>
				<th>Nombre editorial</th>
				<th>Contacto Editorial</th>
				<th>Telefono</th>
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
				<td><a type="button" href="<%=url%>EditorialController?op=obtener&id=<%=edit.getIdeditorial()%>">Editar</a></td>
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
</body>
<a type="button" href="<%=url%>EditorialController?op=nuevo">Nueva Editorial</a>
</html>