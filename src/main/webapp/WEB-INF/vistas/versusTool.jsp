<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include flush="true" page="header.jsp"/>
<body>
	<div class="container mt-3 p-5">		
		<jsp:include flush="true" page="menu.jsp"/>
		
		<div class="row mt-5">
			<div class="row">
				<div class="col-12">
					<h3>Comparativa detallada</h3>
				</div>
				<div class="col-5">
					<select class="form-control" name="appSelect1" id="appSelect1">
						<option value="">Selecciona un editor</option>
						<c:forEach var="app" items="${lstApplications}" >
							<option value="${app.id}">${app.name}</option>
						</c:forEach>				  	
				 	</select>
				</div>
				<div class="col-5">
					<select class="form-control" name="appSelect2" id="appSelect2">
						<option value="">Selecciona un editor</option>
						<c:forEach var="app" items="${lstApplications}" >
							<option value="${app.id}">${app.name}</option>
						</c:forEach>				  
				 	</select>
				</div>
				<div class="col-1" align="right">
					<input type="button"
							onclick="compareTools()"
							value="Comparar"
							class="btn btn-primary" />
				</div>
			</div>
			
			<div class="row mt-3">
				<div class="col-12 pl-0">
					<table class="table table-hover">
						<tbody>
							<tr>
								<td></td>
								<c:forEach var="app" items="${lstApplications}" >
									<td>
										<div class="card">
											<div class="card-body">
												<h2>${app.name}</h2>
												<ul class="list-group">
												  <li class="list-group-item"><b>Tipo de aplicación: </b>${app.type_label}</li>
												  <li class="list-group-item"><b>Descripción: </b>${app.description}</li>
												  <li class="list-group-item"><b>Link oficial: </b>${app.link}</li>
												</ul>
											</div>
										</div>
									</td>
								</c:forEach>						
							</tr>
							<c:forEach var="versus" items="${versusWrapper}" >
								<tr>
									<td><b>${versus.criteriaName}</b></td>
									<td>
										<c:if test="${versus.typeData == 'text'}">
											${versus.res1}
									    </c:if>
									    <c:if test="${versus.typeData == 'boolean'}">
											<c:choose>
											    <c:when test="${versus.res1 == 'VERDADERO' || versus.res1 == 'TRUE'}">
													<i class="fas fa-check"></i>
											    </c:when>    
											    <c:when test="${versus.res1 == 'FALSO'}">
													<i class="fas fa-times" ></i>
											    </c:when>   
											</c:choose>
									    </c:if>
									</td>
									<td>
										<c:if test="${versus.typeData == 'text'}">
											${versus.res2}
									    </c:if>
									    <c:if test="${versus.typeData == 'boolean'}">
											<c:choose>
											    <c:when test="${versus.res2 == 'VERDADERO' || versus.res2 == 'TRUE'}">
													<i class="fas fa-check"></i>
											    </c:when>    
											    <c:when test="${versus.res2 == 'FALSO'}">
													<i class="fas fa-times" ></i>
											    </c:when>    
											</c:choose>
									    </c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<jsp:include flush="true" page="footer.jsp"/>
	
</body>
<script>
</script>
</html>
