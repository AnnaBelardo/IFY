<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<link rel="stylesheet" href="webjars/bootstrap/4.4.1/css/bootstrap.css">
<link href="./resources/css/modern-business.css" rel="stylesheet">
<link href="./resources/css/style.css" rel="stylesheet">
</head>
<body>

	<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0">

		<img src="./resources/images/logos/logo pre login.png" height="80"
			width="90"> <a class="navbar-brand col-sm-3 col-md-2 mr-0"
			href="/">Internship for you</a>
		
				<c:choose>
					<c:when
						test="${pageContext.request.servletPath == '/WEB-INF/view/pages/homepage.jsp'}">
						<a class="option">Login</a>
					</c:when>
					<c:otherwise>
						<a class="option" href='/'>Homepage</a>
					</c:otherwise>
				</c:choose>
			
		<figure class="figure">
			<img src="./resources/images/logos/logo dipartimento.png" height="50"
				width="50" class="figure-img img-fluid rounded logo"
				alt="Un'immagine generica segnaposto con angoli arrotondati in una figura.">
		</figure>
	</nav>

	<!-- Bootstrap core JavaScript -->
	<script src="./resources/vendor/jquery/jquery.min.js"></script>
	<script src="./resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>