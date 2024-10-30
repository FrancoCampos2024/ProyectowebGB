<%@page import="com.unu.proyectoWebGB.beans.*"%>
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
	Editorial edit;
	
	if(request.getAttribute("editorial")==null){
		edit= new Editorial();		
	}else{
		edit = (Editorial) request.getAttribute("editorial");
		System.out.println("Entro al jsp editar editorial:");
		System.out.println(edit.getIdeditorial());
		System.out.println(edit.getNombre());
		System.out.println(edit.getContacto());
		System.out.println(edit.getTelefono());		
	}
	
	%>
	<form role="form" action="<%=url%>EditorialController" method="POST">
		<input type="hidden" name="op" value="modificar" /> <input
			type="hidden" name="ideditorial" value="<%=edit.getIdeditorial()%>" />

		<h1>EDICION DE EDITORIAL</h1>
		Codigo: <input type="text" name="codigo"
			value="<%=edit.getIdeditorial()%>"> <br> Nombre: <input
			type="text" name="nombre" value="<%=edit.getNombre()%>"> <br>
		Contacto: <input type="text" name="contacto"
			value="<%=edit.getContacto()%>"> <br> 
			Telefono: <input type="text" name="telefono"
			value="<%=edit.getTelefono()%>"> <br>
			<input
			type="submit" class="btn btn-info" value="Guardar" name="Guardar">
		<a class="btn btn-danger" href="<%=url%>EditorialController?op=listar">Cancelar</a>
	</form>


</body>
</html>