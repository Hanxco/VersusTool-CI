<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Peliculas</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

</head>
<style>
	.tablaColor{
		background-color : #ddd;
	}
</style>
<body>
	<div class="container mt-3">
		<h1 align="center">LISTADO DE PELICULAS</h1>
		<br>
		<table class="table">
			<tr>
				<td><a href="">Inicio</a></td>
				<td><a href="peliculas/verListado">Ver listado</a></td>
				<td><a href="peliculas/verFormulario">Añadir nueva pelicula</a></td>
			</tr>
		</table>
		<br>
		<table class="table table-striped">
			<tr>
				<th>Id</th> 
				<th>Titulo</th>
				<th>Director</th>
				<th>Genero</th>
				<th>Año</th>
			</tr>
			<c:forEach var="pelicula" items="${listaPeliculas}" >
				<!--  mvc/peliculas/seleccionar?id=1  -->
				<tr>
					<td>${ pelicula.id }</td>
					<td><c:url var="enlace" value="seleccionar">
							<c:param name="id" value="${pelicula.id}" />
						</c:url> <a href="${enlace}">${ pelicula.titulo }</a></td>
					<td>${ pelicula.director }</td>
					<td>${ pelicula.genero }</td>
					<td>${ pelicula.year }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
