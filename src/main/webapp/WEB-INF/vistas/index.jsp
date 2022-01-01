<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />

<html>
<body>
	<jsp:include flush="true" page="header.jsp"/>
	<div class="container mt-3 p-5">
		<div class="align-center">	
			<jsp:include flush="true" page="menu.jsp"/>
			<br><br>
			
			<div class="row">
				<div class="col-12">
					<div class="card-columns">
					  <div class="card cardVersus pointer" onclick="openVersus(1);">
						  	<img src="<c:url value='/resources/static/editorCodigo.png'/>" 
								 align="right" 
								 class="card-img" />			    
							<div class="card-body">
								<h5 class="card-title">Editores de c�digo</h5>
								<p class="card-text"></p>
							</div>
					  </div>
					  
					  <div class="card cardVersus pointer" onclick="openVersus(2);">
						<img src="<c:url value='/resources/static/softwareBuild.png'/>" 
							align="right" 
							class="card-img" />
						<div class="card-body">
							<h5 class="card-title">Herramientas de construcci�n</h5>
							<p class="card-text"></p>
						</div>
					  </div>
					  
					  <div class="card cardVersus pointer" onclick="openVersus(6);">
						<img src="<c:url value='/resources/static/controlVersiones.png'/>" 
							align="right" 
							class="card-img" />
						<div class="card-body">
							<h5 class="card-title">Herramientas de gesti�n de versiones</h5>
							<p class="card-text"></p>
						</div>
					  </div>
					  
					  <div class="card cardVersus pointer" onclick="openVersus(8);">
						<img src="<c:url value='/resources/static/package-open.jpg'/>" 
							align="right" 
							class="card-img" />
						<div class="card-body">
						<h5 class="card-title">Gestores de repositorios compartidos</h5>
						<p class="card-text"></p>
						</div>
					  </div>
					  
					  <div class="card cardVersus pointer" onclick="openVersus(3);">
						<img src="<c:url value='/resources/static/agileProjects.png'/>" 
							align="right" 
							class="card-img" />
						<div class="card-body mt-3">
							<h5 class="card-title">Herramientas de gesti�n de proyectos �giles</h5>
							<p class="card-text"></p>
						</div>
					  </div>
					  
					  <div class="card cardVersus pointer" onclick="openVersus(7);">
						<img src="<c:url value='/resources/static/continuosIntegration.jpg'/>" 
						 align="right" 
						 class="card-img" />
						<div class="card-body">
							<h5 class="card-title">Servidores de integraci�n continua</h5>
							<p class="card-text"></p>
						</div>
					  </div>
					  
					  <div class="card cardVersus pointer" onclick="openVersus(9);">
						<img src="<c:url value='/resources/static/virtualization.jpg'/>" 
							align="right" 
							class="card-img" />
						<div class="card-body">
							<h5 class="card-title">Herramientas de virtualizaci�n</h5>
							<p class="card-text"></p>
						</div>
					  </div>
					  
					  <div class="card cardVersus pointer" onclick="openVersus(4);">
						<img src="<c:url value='/resources/static/unitTesting.png'/>" 
								 align="right" 
								 class="card-img" />
						<div class="card-body">
							<h5 class="card-title">Herramientas de pruebas unitarias</h5>
							<p class="card-text"></p>
						</div>
					  </div>
					  
					  <div class="card cardVersus pointer" onclick="openVersus(5);">
						<img src="<c:url value='/resources/static/functionalTesting.webp'/>" 
							align="right" 
							class="card-img" />
						<div class="card-body">
							<h5 class="card-title">Herramientas de pruebas funcionales</h5>
							<p class="card-text"></p>
						</div>
					  </div>
					  
					  <div class="card cardVersus pointer" onclick="openVersus(10);">
						<img src="<c:url value='/resources/static/codeAnalysis.png'/>" 
							align="right" 
							class="card-img" />
						<div class="card-body">
							<h5 class="card-title">Herramientas de an�lisis de c�digo fuente</h5>
							<p class="card-text"></p>
						</div>
					  </div>
					  
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include flush="true" page="footer.jsp"/>
</body>
<script>
	function openVersus(type) {
		window.location.href = '/VersusTools/vs/' + type;
	}
</script>
</html>