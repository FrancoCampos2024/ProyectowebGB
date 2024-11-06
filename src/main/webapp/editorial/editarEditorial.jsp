<%@page import="com.unu.proyectoWebGB.beans.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<script src="assets/js/bootstrap.min.js">
	
</script>
</head>
<body>
	<h3>EDITAR EDITORIAL</h3>
	<%
	String url = "http://localhost:8080/ProyectowebCampos/";
	Editorial edit;

	if (request.getAttribute("editorial") == null) {
		edit = new Editorial();
	} else {
		edit = (Editorial) request.getAttribute("editorial");
		System.out.println("Entro al jsp editar editorial:");
		System.out.println(edit.getIdeditorial());
		System.out.println(edit.getNombre());
		System.out.println(edit.getContacto());
		System.out.println(edit.getTelefono());
	}
	%>

	<div class="container mt-5">

		<form role="form" action="<%=url%>EditorialController" method="POST">
			<input type="hidden" name="op" value="modificar" /> <input
				type="hidden" name="ideditorial" value="<%=edit.getIdeditorial()%>" />
			<div class="form-group">

				Codigo: <input type="text" name="codigo" class="form-control"
					value="<%=edit.getIdeditorial()%>"> <br>
			</div>
			<div class="form-group">
				Nombre: <input type="text" name="nombre" class="form-control"
					value="<%=edit.getNombre()%>"> <br>

			</div>

			<div class="form-group">
				Contacto: <input type="email" name="contacto"
					value="<%=edit.getContacto()%>" class="form-control"> <br>
			</div>

			<div>
				Telefono: <input type="text" name="telefono" class="form-control"
					value="<%=edit.getTelefono()%>"> <br>
			</div>



			<input type="submit" class="btn btn-info" value="Guardar"
				name="Guardar"> <a class="btn btn-danger"
				href="<%=url%>EditorialController?op=listar">Cancelar</a>
		</form>

	</div>



</body>
</html>