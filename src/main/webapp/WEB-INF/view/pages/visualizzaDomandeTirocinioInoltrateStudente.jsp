<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<title>Domande di tirocinio studente</title>

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
							<li><a href="/visualizzaDomandeTirocinioInoltrateStudente" class="active">Domande di Tirocinio</a></li>
						</ul>
					</div>
				</nav>

				<!-- Page Content  -->
				<div id="content" class="p-4 p-md-5 pt-5">
					<div class="container">

						<h4>
							<span class="my-4 header"> Domande di tirocinio</span>
						</h4>
						<input class="form-control" id="filter" type="text"
							placeholder="Filtra Domande...">
						<table id="parentTable" data-toggle="table" data-sortable="true"
							data-detail-view="true">
							<thead>
								<tr>
									<th class="d-none">Hidden nested details table</th>
									<th class="detail titolo" data-sortable="true">ID Domanda</th>
									<th data-sortable="true" class="titolo">Azienda</th>
									<th data-sortable="true" class="titolo">Progetto</th>
									<th data-sortable="true" class="titolo">Stato</th>
								</tr>

							</thead>
							<tbody>

								<c:forEach items="${domandeInoltrate}" var="current"
									varStatus="loop">
									<tr>
										<td>
											<dl>
												
												<dt>Sede azienda:</dt>
												<dd>${current.azienda.sede}</dd>
												<br>
												
												<dt>Settore azienda:</dt>
												<dd>${current.azienda.settore}</dd>
												<br>
												
												<dt>Attivita del tirocinio:</dt>
												<dd>${current.progettoFormativo.attivita}</dd>
												<br>
												
												
												<dt>Conoscenze richieste:</dt>
												<dd>${current.progettoFormativo.conoscenze}</dd>
												<br>
												
												<dt>Conoscenze Personali:</dt>
												<dd>${current.conoscenze}</dd>
												<br>

												<dt>Motivazioni Personali:</dt>
												<dd>${current.motivazioni}</dd>
												<br>
												
											
												<dt>Data inizio:</dt>
												<dd>${current.dataInizio}</dd>
												<br>
												
												<dt>Data fine:</dt>
												<dd>${current.dataFine}</dd>
												<br>
												
												<dt>Numero cfu:</dt>
												<dd>${current.cfu}</dd>
												<br>
												
												
												

											</dl>
										
										</td>
											
										<td>Domanda ${current.id}</td>
										<td>${current.azienda.ragioneSociale}</td>
										<td>${current.progettoFormativo.nome}</td>
										<td>${current.stato}</td>
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







</body>
</html>