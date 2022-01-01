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
			<div class="col-7">
				<h4 align="left">LISTADO DE APPS</h4>			
			</div>
			<div class="col-2">
				<input type="button"
						class="btn btn-primary"
						value="Ver tipos de apps" 
						id="showTypesApps" />
			</div>
			<div class="col-2 ml-3">
				<input type="button" 
						class="btn btn-primary" 
						value="Agregar nueva aplicación" 
						id="addNewCriteria"/>
			</div>
		</div>
		<table class="table table-striped mt-4">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Tipo</th>
				<th>Descripción</th>
				<th>Link</th>
				<th>Opciones</th>
			</tr>
			<c:forEach var="app" items="${appTools}" >
				<tr>
					<td><c:url var="enlace" value="seleccionar">
							<c:param name="id" value="${app.id}" />
						</c:url> <a href="<c:url value='/apps/tool/${app.id }'/>">${ app.id }</a></td>
					<td><c:url var="enlace" value="seleccionar">
							<c:param name="id" value="${app.id}" />
						</c:url> <a href="<c:url value='/apps/tool/${app.id }'/>">${ app.name }</a></td>
					<td>${ app.type_label }</td>
					<td>${ app.description }</td>
					<td>${ app.link }</td>
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
	        <h5 class="modal-title" id="exampleModalLabel">Añadir nueva app</h5>
	        <button type="button" class="close" data-dismiss="modal" id="closeModal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      	<form action="/VersusTools/apps/addTool" id="AcctionModal" method="POST">
			  <div class="modal-body">
			  	<div class="form-group">
				  <label for="tituloInput">Id</label>
				  <input type="text" class="form-control" id="idInput" name="ids" disabled>
				</div>
				<div class="form-group">
				  <label for="tituloInput">Nombre</label>
				  <input type="text" class="form-control" id="tituloInput" name="name" placeholder="Introduce el nombre">
				</div>
				<div class="form-group">
				  	<label for="tipoInput">Tipo</label>
  				  	<select class="form-control" name="type" id="tipoInput" >
						<option value="">Selecciona una tipo de app</option>
						<c:forEach var="typeApp" items="${appTypes}" >
							<option value="${typeApp.id}">${typeApp.label}</option>
						</c:forEach>	
					</select>		  
				</div>
				<div class="form-group">
				  <label for="descripcionInput">Descripción</label>
				  <textarea class="form-control" id="cuerpoInput" name="description" rows="5"></textarea>
				</div>
				<div class="form-group">
				  <label for="linkInput">Link</label>
  				  <input type="text" class="form-control" id="linkInput" name="link" placeholder="Link oficial">			  
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
	<!-- Modal -->
	<div class="modal fade" id="showTypesAppModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Tipos de aplicación</h5>
	        <button type="button" class="close" data-dismiss="modal" id="closeModalTypeAppModal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
		  <div class="modal-body">
		  	<table class="table table-sm">
		  		<thead>
		  			<tr>
		  				<td>Id</td>
		  				<td>Nombre</td>
		  				<td>Developer name</td>
		  			</tr>
		  		</thead>
		  		<tbody>
					<c:forEach var="type" items="${appTypes}" >
						<tr>
							<td>${ type.id }</td>
							<td>${ type.label }</td>
							<td>${ type.developerName }</td>
						</tr>
					</c:forEach>
		  		</tbody>
		  	</table>
		  </div>
		  <div class="modal-footer">
			<button type="button" class="btn btn-secondary" data-dismiss="modal" id="buttonCloseTypesAppModal">Cerrar</button>
			</div>
	    </div>
	  </div>
	</div>
</body>
<script>
</script>
</html>
