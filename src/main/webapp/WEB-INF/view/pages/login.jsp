<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Login</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="webjars/bootstrap/4.4.1/css/bootstrap.css">
<link href="<c:url value="/resources/css/formStylePage.css" />" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</head>

<body>
<%@ include file="header.jsp" %>
	<div style="margin-top:100px;" class="container">
	
		<form class="form-horizontal" role="form" name="loginForm"
			method="post" action="/login"
			modelAttribute="utenteForm">
			
			<h3>Login</h3>
			<div style="justify-content:center;" class="row">
				<div class="col-6">
					<div class="form-group">
						<div style="margin: 0 auto;" class="col-sm-11">
							<c:choose>
								<c:when test="${EmailError == null}">
									<input type="text" name="email" id="inputEmail"
										placeholder="Email" class="form-control"
										value="${utenteForm.username}">
								</c:when>
								<c:otherwise>
									<input type="text" name="email" id="inputEmail" placeholder="Email" class="form-control is-invalid">
									<span class = "myError">${EmailError}</span>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
					<div class="form-group">
						<div style="margin: 0 auto;" class="col-sm-11">
							<c:choose>
								<c:when test="${PasswordError == null}">
									<input type="password" name="password" id="inputPassword"
										placeholder="Password" class="form-control"
										value="${utenteForm.password}">
								</c:when>
								<c:otherwise>
									<input type="password" name="password" id="inputPassword"
										placeholder="Password" class="form-control is-invalid">
										<span class = "myError">${PasswordError}</span>	
								</c:otherwise>
							</c:choose>

						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-11">
							<c:if test="${CondizioniError != null}">
								<span class = "myError">${CondizioniError}</span>
							</c:if>
						</div>
						<button style="margin: 0 auto;" type="submit" id="reg" class="btn btn-primary btn-block">Login</button>
					</div>
				
				</div>
				
			</div>
		</form>
	</div>
	<!-- ./container -->
	<%@ include file="footer.jsp" %>
	
	
	<c:if test="${message != null}">
		<%@ include file="modalNotifica.jsp"%>
	</c:if>
</body>
</html>