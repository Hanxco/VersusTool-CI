<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />

<head>
	<meta charset="UTF-8"/>
	<link rel="shortcut icon" href="${ baseURL }/resources/static/favicon.ico">
	
	<!--  CSS CDN -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" rel="stylesheet" >
	<link href="${baseURL}/resources/css/bootstrap.min.css" rel="stylesheet" >
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
	<link href="${baseURL}/resources/css/styles.css" rel="stylesheet" >

	<!--  JAVASCRIPT CDN -->	
	<script src="${baseURL}/resources/js/bootstrap.min.js"></script>
	<script src="${baseURL}/resources/js/bootstrap.bundle.min.js"></script>
	<script src="${baseURL}/resources/js/popper.min.js"></script>
	<script src="${baseURL}/resources/js/jquery.min.js"></script>
	<script src="${baseURL}/resources/js/jquery-ui.min.js" type="text/javascript"></script>
	<script src="${baseURL}/resources/js/script.js" ></script>
	
	<title>VERSUS TOOLS</title>
</head>