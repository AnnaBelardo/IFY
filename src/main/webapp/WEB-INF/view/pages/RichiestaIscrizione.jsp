<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<title>Invio richiesta registrazione</title>
<meta charset="utf-8">
<link rel="stylesheet" href="webjars/bootstrap/4.4.1/css/bootstrap.css">

</head>

<body>

	<form name="iscrizioneForm" method = "post" action = "/richiestaIscrizione" modelAttribute ="studenteForm">
		<div class="form-group row">
			<label for="inputNome" class="col-sm-2 col-form-label">Nome</label>
			<div class="col-sm-10">
				<c:choose>
					  <c:when test="${NomeError == null}">
						  
								<input type="text" class="form-control" id="inputNome" name="nome" value = "${studenteForm.nome}">
								
								  </c:when>
					  <c:otherwise>
					    	<input type="text" class="form-control" id="inputNome" name="nome">
					  </c:otherwise>
				</c:choose>
								
				<c:if test = "${NomeError != null}">
						<span class="badge badge-danger">${NomeError}</span>
	
	     			</c:if>
	     			
			
			</div>
		</div>
		
		<div class="form-group row">
			<label for="inputCognome" class="col-sm-2 col-form-label">Cognome</label>
			<div class="col-sm-10">
				<c:choose>
					  <c:when test="${CognomeError == null}">
						  
								<input type="text" class="form-control" id="inputNome" name="cognome" value = "${studenteForm.cognome}">
								
								  </c:when>
					  <c:otherwise>
					    	<input type="text" class="form-control" id="inputNome" name="cognome">
					  </c:otherwise>
				</c:choose>
				
				<c:if test="${CognomeError != null}">
					<span class="badge badge-danger">${CognomeError}</span>

				</c:if>
			</div>
		</div>
		<div class="form-group row">
			<label for="inputIndirizzo" class="col-sm-2 col-form-label">Indirizzo</label>
			<div class="col-sm-10">
			
			<c:choose>
					  <c:when test="${IndirizzoError == null}">
						  
								<input type="text" class="form-control" id="inputIndirizzo" name="indirizzo" value = "${studenteForm.indirizzo}">
								
								  </c:when>
					  <c:otherwise>
					    	<input type="text" class="form-control" id="inputIndirizzo" name="indirizzo">
					  </c:otherwise>
				</c:choose>
				

				<c:if test="${IndirizzoError != null}">
					<span class="badge badge-danger">${IndirizzoError}</span>

				</c:if>
			</div>
		</div>
		<div class="form-group row">
			<label for="inputTelefono" class="col-sm-2 col-form-label">Telefono</label>
			<div class="col-sm-10">
			
				<c:choose>
					  <c:when test="${TelefonoError == null}">
						  
								<input type="text" class="form-control" id="inputTelefono" name="telefono" value = "${studenteForm.telefono}">
								
						</c:when>
					  <c:otherwise>
					    	<input type="text" class="form-control" id="inputTelefono" name="telefono">
					  </c:otherwise>
				</c:choose>
				<c:if test="${TelefonoError != null}">
					<span class="badge badge-danger">${TelefonoError}</span>

				</c:if>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="inputData" class="col-sm-2 col-form-label">Data</label>
			<div class="col-sm-10">
				<c:choose>
					  <c:when test="${DataNascitaError == null}">
						 	<input type="date" class="form-control" id="inputData" name="dataNascita" value = "${studenteForm.dataNascita}">		
						</c:when>
					  <c:otherwise>
					    	<input type="date" class="form-control" id="inputData" name="dataNascita">
					  </c:otherwise>
				</c:choose>
				
				
				

				<c:if test="${DataNascitaError != null}">
					<span class="badge badge-danger">${DataNascitaError}</span>

				</c:if>
			</div>
		</div>

		<div class="row">
			<legend class="col-form-label col-sm-2 pt-0">Sesso</legend>
			<div class="col-sm-10">
			
				<c:choose>
					  <c:when test="${SessoError == null && studenteForm.sesso == 'F'}">
						 	<div class="form-check">
								<input class="form-check-input" type="radio" name="sesso"
									id="maschio" value="M" > <label
									class="form-check-label" for="maschio"> M </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio" name="sesso"
									id="femmina" value="F" checked> <label class="form-check-label"
									for="femmina" > F </label>
							</div>		
						</c:when>
					  <c:otherwise>
					    	<div class="form-check">
								<input class="form-check-input" type="radio" name="sesso"
									id="maschio" value="M" checked> <label
									class="form-check-label" for="maschio"> M </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio" name="sesso"
									id="femmina" value="F"> <label class="form-check-label"
									for="femmina"> F </label>
							</div>
					  </c:otherwise>
				</c:choose>
				

				<c:if test="${SessoError != null}">
					<span class="badge badge-danger">${SessoError}</span>
				</c:if>
			</div>
		</div>

		<div class="form-group row">
			<label for="inputMatricola" class="col-sm-2 col-form-label">Matricola</label>
			<div class="col-sm-10">
			
				<c:choose>
					  <c:when test="${MatricolaError == null}">
						 	<input type="text" class="form-control" id="inputMatricola" name="matricola" value = "${studenteForm.matricola}">		
						</c:when>
					  <c:otherwise>
					  		<input type="text" class="form-control" id="inputMatricola" name="matricola">
					  </c:otherwise>
				</c:choose>
				

				<c:if test="${MatricolaError != null}">
					<span class="badge badge-danger">${MatricolaError}</span>

				</c:if>
			</div>
		</div>

		<div class="form-group row">
		
			<label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
			<div class="col-sm-10">
			
				<c:choose>
					  <c:when test="${EmailError == null}">
						 	<input type="email" class="form-control" id="inputEmail" name = "email" value = "${studenteForm.email}">		
						</c:when>
					  <c:otherwise>
					  		<input type="email" class="form-control"  name = "email" id="inputEmail">
					  </c:otherwise>
				</c:choose>
				

				<c:if test="${EmailError != null}">
					<span class="badge badge-danger">${EmailError}</span>

				</c:if>
			</div>
		</div>
		<div class="form-group row">
			<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
			<div class="col-sm-10">
			
				<c:choose>
					  <c:when test="${PasswordError == null}">
						 	<input type="password" class="form-control" id="inputPassword" name="password" value = "${studenteForm.password}">		
						</c:when>
					  <c:otherwise>
					  		<input type="password" class="form-control" id="inputPassword" name="password">
					  </c:otherwise>
				</c:choose>
		
				<c:if test="${PasswordError != null}">
					<span class="badge badge-danger">${PasswordError}</span>

				</c:if>
			</div>
		</div>
		<div class="form-group row">
			<label for="inputConfermaPassword" class="col-sm-2 col-form-label">Conferma
				Password</label>
			<div class="col-sm-10">
			
				<c:choose>
					  <c:when test="${ConfermaPasswordError == null}">
						 	<input type="password" class="form-control" id="inputConfermaPassword" name="confermaPsw" value = "${studenteForm.confermaPsw}">		
						</c:when>
					  <c:otherwise>
					  		<input type="password" class="form-control" id="inputConfermaPassword" name="confermaPsw">
					  </c:otherwise>
				</c:choose>
				
				<c:if test="${ConfermaPasswordError != null}"> <span class="badge badge-danger">${ConfermaPasswordError}</span>

				</c:if>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-2">Conferma regolamento sulla privacy</div>
			<div class="col-sm-10">
				<div class="form-check">
				
					<c:choose>
					  <c:when test="${CondizioniError == null}">
						 	<input class="form-check-input" type="checkbox" id="accetto"  name="condizioni" checked> <label class="form-check-label" for="accetto"> Accetto </label>
						 	 <a href="https://www.garanteprivacy.it/il-testo-del-regolamento">Regolamento privacy</a>		
						</c:when>
					  <c:otherwise>
					  		<input class="form-check-input" type="checkbox" id="accetto"  name="condizioni"> <label class="form-check-label" for="accetto"> Accetto </label>
						 	 <a href="https://www.garanteprivacy.it/il-testo-del-regolamento">Regolamento privacy</a>		
					  </c:otherwise>
					</c:choose>
					
						
					<c:if test="${CondizioniError != null}"> <span class="badge badge-danger">${CondizioniError}</span></c:if>
				</div>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary">Registrati</button>
			</div>
		</div>
	</form>

</body>
</html>
