<%@page import="com.unu.proyectoWebGB.beans.Genero"%>
<%@page import="com.unu.proyectoWebGB.beans.Autor"%>
<%@page import="com.unu.proyectoWebGB.beans.Editorial"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h3>NUEVO LIBRO</h3>

	<form action="<%=url%>LibroController" method="post">
		<input type="hidden" name="op" value="insertar"> Nombre: <input
			type="text" name="nombre" id="nombre"><br> <br>
		Existencia: <input type="text" name="existencia" id="existencia"><br>
		<br> Precio : <input type="text" name="precio" id="precio"><br>
		<br> <label for="autor">Elije Autor:</label> <select
			id="autor" name="autor">
			<%
			List<Autor> autores = (List<Autor>) request.getAttribute("listarAutores");
			if (autores == null) {
				System.out.println("La lista de autores es nula.");
			} else if (autores.isEmpty()) {
				System.out.println("La lista de autores está vacía.");
			} else {
				for (Autor a : autores) {
			%>
			<option value="<%=a.getIdAutor()%>"><%=a.getNombre()%></option>
			<%
			}
			}
			%>

		</select> <br> <br> <label for="editorial">Elije Editorial:</label> <select
			id="editorial" name="editorial">
			<%
			List<Editorial> edit = (List<Editorial>) request.getAttribute("listarEditoriales");
			for (Editorial e : edit) {
			%>
			<option value="<%=e.getIdeditorial()%>"><%=e.getNombre()%></option>
			<%
			}
			%>

		</select> <br> <br> <label for="genero">Elije Genero:</label> <select
			id="genero" name="genero">
			<%
			List<Genero> genero = (List<Genero>) request.getAttribute("listarGeneros");
			for (Genero g : genero) {
			%>
			<option value="<%=g.getIdgenero()%>"><%=g.getNombre()%></option>
			<%
			}
			%>
		</select> <br> <br>Descripcion: <input type="text" name="descripcion"
			id="descripcion"><br>

		<button type="submit" class="btn btn-primary">Guardar</button>

	</form>




</body>
</html>