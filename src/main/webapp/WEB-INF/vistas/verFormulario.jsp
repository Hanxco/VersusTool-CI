<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir nueva pelicula</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

	<script type="text/javascript">
		function setActionFormulario( accion ){
			var formulario = document.getElementById("formulario");
			formulario.action = accion;
		}
	</script>
</head>
<style>
	.tablaColor{
		background-color : #ddd;
	}
</style>
<body>
	<div class="container mt-3">
		<h1 align="center">AÑADIR PELICULA</h1>
		<br>
		<table class="table">
			<tr>
				<td><a href="">Inicio</a></td>
				<td><a href="verListado">Ver listado</a></td>
				<td><a href="verFormulario">Añadir nueva pelicula</a></td>
			</tr>
		</table>
		<div class="card">
			<div class="card-header">
				<div class="card-body">			
					${errorTitulo}
					<!--  	<div class="alert alert-danger alertaPersonalizada" role="alert">${errorTitulo}</div> -->
					<form:form id="formulario" name="formulario" class="text-center" method="POST" modelAttribute="pelicula">
						<div class="form-group">
							<form:input class="form-control" type="text" path="titulo" placeholder="Introduce Título" />
						</div>
						<div class="form-group">
							<form:input class="form-control" type="text" path="director" placeholder="Introduce Director" />
						</div>
						<div class="form-group">
							<form:input class="form-control" type="text" path="genero" placeholder="Introduce Genero" />
						</div>
						<div class="form-group">
							<form:input class="form-control" type="number" path="year" placeholder="Introduce Año" />
						</div>
						<br>
						<div class="text-center">
							<input type="submit" class="btn btn-warning" value="Modificar" onclick="setActionFormulario('modificar')" /> 
							<input type="submit" class="btn btn-danger" value="Eliminar" onclick="setActionFormulario('eliminar')" /> 
							<input type="submit" class="btn btn-success" value="Insertar" onclick="setActionFormulario('insertar')" />
						</div>
						<form:hidden id="id" path="id" />
					</form:form>
				</div>
			</div>
		</div>
		
	</div>
</body>
</html>
