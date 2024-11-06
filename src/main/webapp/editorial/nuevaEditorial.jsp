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
	<h3>AÑADIR EDITORIAL</h3>
	<%
	String url = "http://localhost:8080/ProyectowebCampos/";
	%>
	<div class="container mt-5">
  <form action="<%=url%>EditorialController" method="POST">
    <input type="hidden" name="op" value="insertar">
    
    <div class="form-group">
      <label for="nombre">Nombre Editorial:</label>
      <input type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese el nombre de la editorial">
    </div>
    
    <div class="form-group">
      <label for="contacto">Contacto Editorial:</label>
      <input type="email" class="form-control" name="contacto" id="contacto" placeholder="Ingrese el contacto de la editorial">
    </div>
    
    <div class="form-group">
      <label for="telefono">Teléfono Editorial:</label>
      <input type="text" class="form-control" name="telefono" id="telefono" placeholder="Ingrese el teléfono de la editorial">
    </div>
    
    <button type="submit" class="btn btn-primary">Guardar</button>
    <a href="<%=url%>EditorialController?op=listar" class="btn btn-secondary">Volver</a>
  </form>
</div>

</body>
</html>