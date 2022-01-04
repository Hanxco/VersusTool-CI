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
					<h1 class="display-5">Versus Tools</h1>
				</div>
			</div>
			
			<div class="row mt-3">
				<div class="col-12" >
					<p class="lead">
						Es un prototipo de aplicaci�n web creado para la asignatura de 
						Integraci�n continua del <b>Master Universitario en Desarrollo �gil de Software para la Web</b>. 
						Su finalidad es poder comparar distintas herramientas inform�ticas profesionales.
					</p>
					<div id="sobreVsTool">
						<h1 class="display-6">Caracter�sticas principales</h1>
						<ul>
							<li>Gestionar las aplicaciones registradas</li>
							<li>Gestionar los criterios de comparaci�n para cada tipo de aplicaci�n</li>
							<li>Asignar caracter�sticas espec�ficas para cada aplicaci�n</li>
							<li>Desde la pantalla principal se pueden elegir las aplicaciones a comparar entre todo el cat�logo publicado.</li>
							<li>Desde la pantalla principal, es posible ver la comparaci�n detallada para cada tipo de herramienta de forma independiente.</li>					
						</ul>
					</div>
				</div>
				<div class="mt-3">
					<h3>
						<a href="https://github.com/Hanxco">
							<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWBotrR9_mmcZ_1e3Gz750BmsSWMBw9Cp6E_kB1endVP20Xdk-vC-iWlP-Uq3M6jn3gHQ&usqp=CAU" style="height: 120px;"/>
						</a>
						<small class="text-muted"><a href="https://github.com/Hanxco">https://github.com/Hanxco</a></small>
					</h3>
				</div>
			</div>
		</div>
	</div>
	<jsp:include flush="true" page="footer.jsp"/>
	
</body>
<script>
</script>
</html>
