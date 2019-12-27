<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  		<meta name="description" content="">
  		<meta name="author" content="">
		<title>IFY - Internship for you</title>
		<!--  
		<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    	<script src="./resources/js/bootstrap.min.js"></script>
    	-->
    	<link rel="stylesheet" href="webjars/bootstrap/4.4.1/css/bootstrap.css">
    	<!-- vecchio <link rel="stylesheet" href="./resources/css/testo.css">-->
    	<!-- Bootstrap core CSS 
  		<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		-->
  		<!-- Custom styles for this template -->
  		<link href="./resources/css/modern-business.css" rel="stylesheet">
 		<link href="./resources/css/style.css" rel="stylesheet">
	</head>
	<body>
		<%@ include file="header.jsp" %>
  		<header>
			<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
		    	<ol class="carousel-indicators">
		        	<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
		        	<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		        	<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		      	</ol>
		      	<div class="carousel-inner" role="listbox">
		        <!-- Slide One - Set the background image for this slide in the line below -->
		        	<div class="carousel-item active" style="background-image: url('./resources/images/carosello/campus.jpg')">
		          		<div class="carousel-caption d-none d-md-block">
		            		<h3 class="testo">Dipartimento di Informatica dell'Università degli Studi di Salerno</h3>
		            		<p class="testo">L'università mette in contatto studenti e aziende</p>
		          		</div>
		        	</div>
		        <!-- Slide Two - Set the background image for this slide in the line below -->
		        	<div class="carousel-item" style="background-image: url('./resources/images/carosello/tirocini.jpg')">
		          		<div class="carousel-caption d-none d-md-block">
		            		<h3 class="testo">Tirocinio</h3>
		            		<p class="testo">IFY facilita agli studenti lo svolgimento di tirocini esterni</p>
		          		</div>
		        	</div>
		        	<!-- Slide Three - Set the background image for this slide in the line below -->
		        	<div class="carousel-item" style="background-image: url('./resources/images/carosello/aziendacarousel.jpg')">
		          		<div class="carousel-caption d-none d-md-block">
		            		<h3 class="testo">Azienda</h3>
		            		<p class="testo">IFY agevola i progetti formativi presso le aziende</p>
		          		</div>
		        	</div>
		      	</div>
		      	<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
		        	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
		        	<span class="sr-only">Previous</span>
		      	</a>
		      	<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
		        	<span class="carousel-control-next-icon" aria-hidden="true"></span>
		        	<span class="sr-only">Next</span>
		      	</a>
		    </div>
		</header>
		<!-- Page Content -->
		<div class="container page-wrap">
			<h1 class="my-4 testosopracard">Benvenuto sulla piattaforma per la gestione dei tirocini</h1><br>
			<!-- Marketing Icons Section -->
			<div class="row">
				<div class="col-lg-4 mb-4">
			      	<div class="card h-100">
			        	<h4 class="card-header">Visualizza le aziende convenzionate</h4>
			          	<div class="card-body">
							<img src="./resources/images/card/handshake.png"  class="img-thumbnail">
			            	<!--<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>-->
			          	</div>
			          	<div class="card-footer">
			            	<a href="#" class="btn btn-primary bottonecard">Visualizza</a>
			          	</div>
			        </div>
			    </div>
				<div class="col-lg-4 mb-4"> <!-- aggiungi mx-auto per centrare-->
			    	<div class="card h-100">
			        	<h4 class="card-header">Sei uno studente?</h4>
			          		<div class="card-body">
							<!--<img src="./img/studente.png" class="img-fluid">-->
								<img src="./resources/images/card/studente.png" class="img-thumbnail">
			            		<p class="card-text">Cosa aspetti a registrarti?</p>
			          		</div>
			          		<div class="card-footer">
			            		<a href="./iscrizioneStudente" class="btn btn-primary bottonecard">Iscriviti ora</a>
			          		</div>
			        </div>
			      </div>
			      <div class="col-lg-4 mb-4">
			      	<div class="card h-100">
			        	<h4 class="card-header">Sei un'azienda?</h4>
			          	<div class="card-body">
							<img src="./resources/images/card/azienda.png" class="img-thumbnail">
			            	<p class="card-text">Convenzionati in pochi passi</p>
			          	</div>
			          	<div class="card-footer">
			            	<a href="#" class="btn btn-primary bottonecard">Convenzionati ora</a>
			          	</div>
			        </div>
			      </div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container -->
		<%@ include file="footer.jsp" %>
		<!-- Bootstrap core JavaScript -->
		<script src="./resources/vendor/jquery/jquery.min.js"></script>
		<script src="./resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		<c:if test="${successoIscrizione != null}">
		
			<script> $(window).on('load', function() {
				alert("${successoIscrizione}");
			});
			
			</script>
		</c:if>
	</body>
</html>