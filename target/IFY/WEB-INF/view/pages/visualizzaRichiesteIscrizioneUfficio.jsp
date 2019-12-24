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

<title>Gestioni richieste d'iscrizioni in attesa</title>

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
						
		
							<li class="active"><a href="#homeSubmenuRichieste"
								data-toggle="collapse" aria-expanded="true"
								class="dropdown-toggle">Richieste</a>
								<ul class="collapse list-unstyled" id="homeSubmenuRichieste">
									<li><a href="#">Richieste di iscrizione</a></li>
									<li><a href="#">Richieste di convenzionamento</a></li>

								</ul>
							</li>
							<li class="active"><a href="#homeSubmenuDomande"
								data-toggle="collapse" aria-expanded="true"
								class="dropdown-toggle">Domande di tirocinio</a>
								<ul class="collapse list-unstyled" id="homeSubmenuDomande">
									<li><a href="#">Domande in attesa</a></li>
									<li><a href="#">Domande valutate</a></li>

								</ul>
							</li>
							
							<li><a href="#">Tirocini in corso</a></li>
							<li><a href="#">Logout</a></li>

						</ul>
					</div>
				</nav>

				<!-- Page Content  -->
				<div id="content" class="p-4 p-md-5 pt-5">
					<div class="container">

						<h4>
							<span class="my-4 header">Richieste d'iscrizione in attesa</span>
						</h4>
						<input class="form-control" id="filter" type="text"
							placeholder="Filtra Richieste...">
						<table id="parentTable" data-toggle="table" data-sortable="true"
							data-detail-view="true">
							<thead>
								<tr>
									<th class="d-none">Hidden nested details table</th>
									<th class="detail"></th>
									<th class="detail"></th>
									<th class="detail" data-sortable="true">ID Richiesta</th>
									<th data-sortable="true">Nome</th>
									<th data-sortable="true">Cognome</th>
									<th data-sortable="true">Matricola</th>

								</tr>

							</thead>
							<tbody>
								<tr>
									<td>
										<dl>
											<dt>Sesso</dt>
											<dd>M</dd>
											<br>
											<dt>Sesso</dt>
											<dd>M</dd>
											<br>
											<dt>Sesso</dt>
											<dd>M</dd>
											<br>
											<dt>Sesso</dt>
											<dd>M</dd>
											<br>
											<dt>Sesso</dt>
											<dd>M</dd>
											<br>
											<dt>Sesso</dt>
											<dd>M</dd>
											<br>
											<dt>Sesso</dt>
											<dd>M</dd>
											<br>
											<dt>Sesso</dt>
											<dd>M</dd>
											<br>
											<dt>Sesso</dt>
											<dd>M</dd>
											<br>
											<dt>Sesso</dt>
											<dd>M</dd>
										</dl>
									</td>
									<td class="valuta"><a href="" class="approve-icon"
										data-toggle="modal" data-target="#exampleModal"
										onclick="<c:set var="valuta" scope="session" value="accetta"/>">
										
										<i
											class="fa fa-user-check"></i></a></td>
									<td class="valuta"><a href="" class="reject-icon"
										data-toggle="modal" data-target="#exampleModal" 
										onclick="<c:set var="valuta" scope="session" value="rifiuta"/>">
										
										<i
											class="fa fa-user-times"></i></a></td>
									<td>Richiesta 1</td>
									<td>Mario</td>
									<td>Rossi</td>
									<td>0512105148</td>

								</tr>
								<tr>
									<td>
										<dl>
											<dt>Color</dt>
											<dd>rainbow</dd>
										</dl>
									</td>
									<td class="valuta"><a href="" class="approve-icon"
										data-toggle="modal" data-target="#exampleModal"><i
											class="fa fa-user-check"></i></a></td>
									<td class="valuta"><a href="" class="reject-icon"
										data-toggle="modal" data-target="#exampletimes"><i
											class="fa fa-user-times"></i></a></td>
									<td>Richiesta 2</td>
									<td>Matteo</td>
									<td>Verdi</td>
									<td>0512105149</td>
								</tr>
								<tr>
									<td>
										<dl>
											<dt>Color</dt>
											<dd>blue</dd>
										</dl>
									</td>
									<td class="valuta"><a href="" class="approve-icon"
										data-toggle="modal" data-target="#exampleModal"><i
											class="fa fa-user-check"></i></a></td>
									<td class="valuta"><a href="" class="reject-icon"
										data-toggle="modal" data-target="#exampletimes"><i
											class="fa fa-user-times"></i></a></td>
									<td>Richiesta 3</td>
									<td>Bruno</td>
									<td>Bianchi</td>
									<td>0512105150</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

			</div>
		</div>
		</div>
		<%@ include file="footer.jsp"%>
</body>
<div class="modal" id="exampleModal" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Info</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				
				<c:choose>  
    				<c:when test="${valuta == 'accetta'}">  
       					Richiesta accettata con successo.
       					<c:out value="${valuta}"></c:out>  
    				</c:when>  
    				 
    				<c:when test="${valuta == 'rifiuta'}">  
       					Richiesta rifiutata con successo.
       					<c:out value="${valuta}"></c:out>    
    				</c:when>
    				
    				<c:otherwise>
    					Richiesta rifiutata con successo.
    					<c:out value="${valuta}"></c:out> 
    				</c:otherwise>   
				</c:choose>
				
				<%-- 
				<c:if test="${valuta == 'accetta'}">
 					<c:out value="Richiesta accettata con successo"/>
				</c:if>
				<c:if test="${valuta == 'rifiuta'}">
 					<c:out value="Richiesta rifiutata con successo"/>
				</c:if>
				--%>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger modalbutton-annulla" data-dismiss="modal">Annulla</button>
				<button type="button" class="btn btn-success modalbutton-conferma" data-dismiss="modal">Conferma</button>
			</div>
		</div>
	</div>
</div>

<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/4.4.1/js/bootstrap.min.js"></script>
<script src="./resources/js/bootstrap-table.min.js"></script>
<script src="./resources/js/sidebar.js"></script>

<script>
	// Load detail view
	$('#parentTable').on('expand-row.bs.table',
			function(e, index, row, $detail) {

				// Get subtable from first cell
				var $rowDetails = $(row[0]);

				// Give new id to avoid conflict with first cell    
				var id = $rowDetails.attr("id");
				$rowDetails.attr("id", id + "-Show");

				// Write rowDetail to detail
				$detail.html($rowDetails);

				return;

			})

	/*filtraggio campi*/
	$(document).ready(
			function() {
				$("#filter").on(
						"keyup",
						function() {
							var value = $(this).val().toLowerCase();
							$("#parentTable tbody tr").filter(
									function() {
										$(this).toggle(
												$(this).text().toLowerCase()
														.indexOf(value) > -1)
									});
						});
			});

	//show modal
	$('#myModal').on('shown.bs.modal', function() {
		$('#myInput').trigger('focus')
	})
</script>


</html>

