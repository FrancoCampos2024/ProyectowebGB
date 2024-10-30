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
	String url="http://localhost:8080/ProyectowebCampos/";	
	%>
	<h3>NUEVO LIBRO</h3>
	
	<form action="<%=url%>LibroController" method="post">
	<input type="hidden" name="op" value="insertar">
	
	Nombre: <input type="text" name="nombre" id="nombre"><br><br>
	Existencia: <input type="text" name="existencia" id="existencia"><br><br>
	Precio : <input type="text" name="precio" id="precio"><br><br>
	
	<label for="opciones">Elije Autor:</label>
	<select id="opciones" name="opciones">
		<option value="opcion1">Opción 1</option>
		<option value="opcion2">Opción 2</option>
		<option value="opcion3">Opción 3</option>
	</select>
	<br><br>
	<label for="opciones">Elije Editorial:</label>
	<select id="opciones" name="opciones">
		<option value="opcion1">Opción 1</option>
		<option value="opcion2">Opción 2</option>
		<option value="opcion3">Opción 3</option>
	</select>
	<br><br>
	<label for="opciones">Elije Genero:</label>
	<select id="opciones" name="opciones">
		<option value="opcion1">Opción 1</option>
		<option value="opcion2">Opción 2</option>
		<option value="opcion3">Opción 3</option>
	</select>
	
	<br><br>Descripcion: <input type="text" name="descripcion" id="descripcion"><br>
	
	</form>
	

	

</body>
</html>