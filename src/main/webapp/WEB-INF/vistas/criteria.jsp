<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include flush="true" page="header.jsp"/>
<body>
	<div class="container mt-3 p-5">		
		<jsp:include flush="true" page="menu.jsp"/>
		
		<br>
		<div class="row">
			<div class="col-8">
				<h4 align="left">LISTADO DE CRITERIOS</h4>			
			</div>
			<div class="col-4" align="left">
				<input type="button" 
						class="btn btn-primary" 
						value="Agregar nuevo criterio" 
						id="addNewCriteria"/>
			</div>
		</div>
		<table class="table table-striped mt-4">
			<tr>
				<th>Id</th>
				<th>Clave</th>
				<th>Descripción</th>
				<th>Tipo de aplicación</th>
				<th>Categoría</th>
				<th>Subcategoría</th>
				<th>Opciones</th>
			</tr>
			<c:forEach var="criteria" items="${criteriaList}" >
				<!--  mvc/peliculas/seleccionar?id=1  -->
				<tr>
					<td><c:url var="enlace" value="seleccionar">
							<c:param name="id" value="${criteria.id}" />
						</c:url> <a href="${enlace}">${ criteria.id }</a></td>
					<td>${ criteria.key }</td>
					<td>${ criteria.name }</td>
					<td>${ criteria.app_label }</td>
					<td>${ criteria.category }</td>
					<td>${ criteria.subcategory }</td>
					<td>
						<i class="fas fa-edit fa-2x" ></i>
				      	<i class="fas fa-trash-alt fa-2x" ></i>
					<td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include flush="true" page="footer.jsp"/>
	
	<!-- Modal -->
	<div class="modal fade" id="insertModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Añadir nuevo criterio</h5>
	        <button type="button" class="close" data-dismiss="modal" id="closeModal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      	<form action="" id="AcctionModal" method="POST">
			  <div class="modal-body">
			  	<div class="form-group">
				  <label for="tituloInput">Id</label>
				  <input type="text" class="form-control" id="idInput" name="ids" disabled>
				</div>
				<div class="form-group">
				  <label for="tituloInput">Clave</label>
				  <input type="text" class="form-control" id="clave" name="clave" placeholder="Introduce la clave del criterio">
				</div>
				<div class="form-group">
				  <label for="tituloInput">Nombre</label>
				  <input type="text" class="form-control" id="name" name="name" placeholder="Introduce el nombre del criterio">
				</div>
				<div class="form-group">
				  <label for="cuerpoInput">Tipo de aplicación</label>
  				  	<select class="form-control" name="tipoApp" id="tipoApp" >
						<option value="0">General</option>				  	
						<c:forEach var="tool" items="${appTypes}" >						
							<option value="${tool.id}">${tool.label}</option>
						</c:forEach>				  	
				 	</select>
				</div>
				<div class="form-group">
				  <label for="cuerpoInput">Categoría</label>
				  	<select class="form-control" name="categoria" id="categoria">
						<option value="">Selecciona una Categoría</option>				  	
						<option value="General">General</option>				  	
						<option value="Uso de herramientas">Uso de herramientas</option>				  	
				 	</select>
				</div>
				<div class="form-group">
				  <label for="cuerpoInput">Subcategoría</label>
				  	<select class="form-control" name="subcategoria" id="subcategoria" >
						<option value="">Selecciona una Subcategoría</option>				  	
						<option value="Requisitos hardware">Requisitos hardware</option>				  	
						<option value="Rendimiento">Rendimiento</option>				  	
						<option value="Retrocompatibilidad">Retrocompatibilidad</option>				  	
						<option value="Soporte">Soporte</option>				  	
				 	</select>
				</div>
			  </div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal" id="buttonClose">Cerrar</button>
					<input type="submit" class="btn btn-primary" value="Guardar cambios" />
				</div>
			</form>
	    </div>
	  </div>
	</div>
</body>
<script>
</script>
</html>
