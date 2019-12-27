<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Dashboard Responsabile</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="webjars/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="webjars/font-awesome/5.12.0/css/all.css" rel="stylesheet" />
<link href="./resources/css/bootstrap-table.css" rel="stylesheet" />
<!-- Custom styles for this template -->

<link rel="stylesheet" href="./resources/css/sidebar.css">
<link href="./resources/css/dashboard.css" rel="stylesheet">

</head>

<body>
	<div class="container-fluid">

		<%@ include file="header.jsp"%>
		<div class="row">
			<div class="wrapper d-flex align-items-stretch">
				<nav id="sidebar">
					<div class="custom-menu">
						<button type="button" id="sidebarCollapse" class="btn btn-primary">
							<i class="fa fa-bars"></i> <span class="sr-only">Toggle
								Menu</span>
						</button>
					</div>
					<div class="p-4 pt-5">
						<!--  <h1><a href="index.html" class="logo">IFY</a></h1>-->


						<ul class="list-unstyled components mb-5">

							<li><a href="#">Dashboard Ufficio</a></li>
							<li class="active"><a href="#homeSubmenuRichieste"
								data-toggle="collapse" aria-expanded="true"
								class="dropdown-toggle">Richieste</a>
								<ul class="collapse list-unstyled" id="homeSubmenuRichieste">
									<li><a href="/visualizzaRichiesteIscrizione">Richieste
											di iscrizione</a></li>
									<li><a href="#">Richieste di convenzionamento</a></li>

								</ul></li>
							<li class="active"><a href="#homeSubmenuDomande"
								data-toggle="collapse" aria-expanded="true"
								class="dropdown-toggle">Domande di tirocinio</a>
								<ul class="collapse list-unstyled" id="homeSubmenuDomande">
									<li><a href="#">Domande in attesa</a></li>
									<li><a href="#">Domande valutate</a></li>

								</ul></li>

							<li><a href="#">Tirocini in corso</a></li>
							<li><a href="/logout">Logout</a></li>


						</ul>
					</div>
				</nav>

				<!-- Page Content  -->
				<div id="content" class="p-4 p-md-5 pt-5">
					<div class="container">

						<h4>
							<span class="my-4 header">Benvenuto Nome utente nella tua
								area personale</span>
						</h4>
						<div class="card-deck">
							<div class="card">
								<img
									src="./resources/images/dashDelegato/RichiestaIscrizione.png"
									class="card-img-top" alt="...">
								<div class="card-body">
									<h5 class="card-title">Richieste di iscrizione</h5>
									<p class="card-text">In questa sezione puoi vedere i le
										richieste di iscrizione alla piattaforma</p>
								</div>
								<div class="card-footer">
									<small class="text-muted">Ultima modifica 10 mesi fa</small>
								</div>
							</div>
							<div class="card">
								<img src="./resources/images/dashDelegato/DomandeTirocinio.jpg"
									class="card-img-top" alt="...">
								<div class="card-body">
									<h5 class="card-title">Domande di tirocinio</h5>
									<p class="card-text">In questa sezione puoi vedere le
										domande di tirocinio</p>
								</div>
								<div class="card-footer">
									<small class="text-muted">Ultima modifica 3 giorni fa</small>
								</div>
							</div>
							<div class="card">
								<img src="./resources/images/dashDelegato/TirociniInCorso.jpg"
									class="card-img-top" alt="...">
								<div class="card-body">
									<h5 class="card-title">Tirocini in corso</h5>
									<p class="card-text">In questa sezione puoi vedere i
										tirocini in corso</p>
								</div>
								<div class="card-footer">
									<small class="text-muted">Ultima modifica 6 mesi fa</small>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>

<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/4.4.1/js/bootstrap.min.js"></script>
<script src="./resources/js/sidebar.js"></script>


</html>




