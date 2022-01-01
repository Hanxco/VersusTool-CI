<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include flush="true" page="header.jsp"/>
<body>
	<div class="container mt-3 p-5">		
		<jsp:include flush="true" page="menu.jsp"/>
		
		<br>
		<div class="row mb-3">
			<div class="col-8">
				<h4 align="left">DETALLE DE LA APLICACIÓN</h4>
				<h6>${appObj.type_label} / ${appObj.name}</h6>			
			</div>
			<div class="col-4" align="left">
				<input type="button" 
						class="btn btn-primary" 
						value="Agregar nueva característica" 
						id="addNewCriteria"/>
			</div>
		</div>
		<table class="table table-striped">
			<tr>
				<td>Id</td>
				<td>Cod. Criterio</td>
				<td>Descripción Criterio</td>
				<td>Categoría Criterio</td>
				<td>Descripción</td>
				<td>Opciones</td>
			</tr>
			<c:forEach var="appCri" items="${appCriterias}" >
				<tr>
					<td>${ appCri.appDetail.id }</td>
					<td><c:url var="enlace" value="seleccionar">
							<c:param name="id" value="${appCri.criteria.id}" />
						</c:url> <a href="<c:url value='/criteria/${appCri.criteria.id }'/>">${ appCri.criteria.key }</a></td>
					<td>${ appCri.criteria.name }</td>
					<td>${ appCri.criteria.category }</td>
					<td>${ appCri.appDetail.description }</td>
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
	        <h5 class="modal-title" id="exampleModalLabel">Añadir nueva característica</h5>
	        <button type="button" class="close" data-dismiss="modal" id="closeModal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      	<form action="/VersusTools/apps/tool/${toolId}/addCriteriaApp" id="AcctionModal" method="POST">
			  <div class="modal-body">
			  	<div class="form-group">
				  <label for="tituloInput">Id</label>
				  <input type="text" class="form-control" id="idInput" name="ids" disabled>
				</div>
				<div class="form-group">
					<label for="tituloInput">Criterio</label>
				  	<select class="form-control" name="codCriterio" id="codCriterio" onChange="changeSelectRol();">
						<option value="">Selecciona un criterio</option>
						<c:forEach var="criteria" items="${lstCriterias}" >
							<option value="${criteria.id }">${criteria.name }</option>
						</c:forEach>				  	
				 	</select>
				</div>
				<div class="form-group">
				  <label for="descripcionInput">Descripción característica</label>
				  <textarea class="form-control" id="cuerpoInput" name="description" rows="5"></textarea>
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
