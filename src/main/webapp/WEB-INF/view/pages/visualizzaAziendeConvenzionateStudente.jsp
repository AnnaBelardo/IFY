<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Aziende Convenzionate</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="webjars/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="webjars/font-awesome/5.12.0/css/all.css" rel="stylesheet" />
<link href="./resources/css/bootstrap-table.css" rel="stylesheet" />
<!-- Custom styles for this template -->

<link rel="stylesheet" href="./resources/css/sidebar.css">
<link rel="stylesheet" href="./resources/css/style.css">
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
						
							<li><a href="/">Dashboard</a></li>
							<li><a href="/visualizzaAziendeConvenzionateStudente">Aziende Convenzionate</a></li>
							<li><a href="#">Tirocini in Corso</a></li>
							<li><a href="#">Domande di Tirocinio</a></li>
						</ul>
					</div>
				</nav>

				<!-- Page Content  -->
				<div id="content" class="p-4 p-md-5 pt-5">
					<div class="container">

						<h4>
							<span class="my-4 header">Aziende Convenzionate</span>
						</h4>
						<input class="form-control" id="filter" type="text"
							placeholder="Filtra Aziende...">
						<table class="table-sm" id="parentTable" data-toggle="table" data-sortable="true" data-detail-view="true" data-detail-view-icon="false">
							<thead>
								<tr>
									<th class="d-none">Hidden nested details table</th>
									<th class="detail" data-sortable="true">Azienda</th>
									<th class="detail" data-sortable="true">Sede</th>
									<th class="detail" data-sortable="true">Settore</th>
									<th data-sortable="true">Dettagli Azienda</th>
									<th data-sortable="true">Progetti Formativi Azienda</th>
								</tr>

							</thead>
							<tbody>

								<c:forEach items="${aziendeConvenzionate}" var="current"
									varStatus="loop">
									<tr>
										<td>
											<table class="table-warning">
												<thead>
													<tr class="bg-warning">
														<th data-sortable="true">Progetto</th>
														<th data-sortable="true">Attivazione</th>
														<th data-sortable="true">Ambito</th>
														<th data-sortable="true">Numero tirocinanti</th>
														<th data-sortable="true">Dettagli progetto</th>
														<th data-sortable="true">Invio domanda</th>
													</tr>
												</thead>
												<tbody>
												<c:forEach items="${current.progettiFormativi}" var="progetto" varStatus="loop">
														<c:if test="${progetto.stato.equals('attivo')}">
															<tr>
																<td>${progetto.nome}</td>
																<td>${progetto.data_compilazione}</td>
																<td>${progetto.ambito}</td>
																<td>${progetto.max_partecipanti}</td>
																<td>
																	<!--  
																	<input type="submit" class="btn btn-primary aziende-convenzionate-btn dettagli-btn" value="Dettagli">
																	-->
																	<form name="dettagliForm" method="POST" action="/visualizzaDettagliProgettoFormativoStudente">
																		<input type="hidden" name="idProgettoFormativo" value="${progetto.id}">
																			<button class="btn btn btn-primary aziende-convenzionate-btn dettagli-btn">
  																				Dettagli
																			</button>
																	</form>
																</td>
																<td>
																	<input type="submit" class="btn btn-primary aziende-convenzionate-btn invia-btn" value="Invia">
																</td>
															</tr>
														</c:if>
													</c:forEach>
												</tbody>
											</table>
										</td>
										<td>${current.ragioneSociale}</td>
										<td>${current.sede}</td>
										<td>${current.settore}</td>
										<td>
											<form method="post" action="/dettagliAziendaStudente">
												<input type="hidden" name="pIva" value="${current.pIva}">
												<input type="submit" class="btn btn-primary dettagli-btn" value="Dettagli">
											</form>
										</td>
										<td><a class="detail-icon btn btn-success prog-form-btn">Progetti Formativi</a></td>
											
										</td>

									</tr>

								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>

			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>

	<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<script src="./resources/js/bootstrap-table.min.js"></script>
	<script src="./resources/js/sidebar.js"></script>
	
	<c:if test="${AziendaPerDettagli != null}">
		<%@ include file="modalDettagliAzienda.jsp" %>
	</c:if>
	<c:if test="${progettoPerDettagli!=null}">
		<%@ include file="modalDettagliProgetto.jsp"%>
	</c:if>
	<script>
		// Load detail view
		$('#parentTable').on('expand-row.bs.table',
				function(e, index, row, $detail) {

					// Get subtable from first cell
					var $rowDetails = $(row[0]);

					// Write rowDetail to detail
					$detail.html($rowDetails);

					return;

				})

		/*filtraggio campi*/
		$(document)
				.ready(
						function() {
							$("#filter")
									.on(
											"keyup",
											function() {
												var value = $(this).val()
														.toLowerCase();
												$("#parentTable tbody tr")
														.filter(
																function() {
																	$(this)
																			.toggle(
																					$(
																							this)
																							.text()
																							.toLowerCase()
																							.indexOf(
																									value) > -1)
																});
											});
						});

		//show modal
	</script>
</body>






</html>

