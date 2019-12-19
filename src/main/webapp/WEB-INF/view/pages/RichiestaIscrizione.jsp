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
					  <c:when test="${studenteForm != null}">
						  
								<input type="text" class="form-control" id="inputNome" name="nome" value = "${studenteForm.nome}">
								
								
								<c:if test = "${NomeError != null}">
										<span class="badge badge-danger">${NomeError}</span>
				
				      			</c:if>
				      			
							
					  </c:when>
					  <c:otherwise>
					    	<input type="text" class="form-control" id="inputNome" name="nome">
					  </c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="inputCognome" class="col-sm-2 col-form-label">Cognome</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputCognome"
					name="cognome">
				<c:if test="${CognomeError != null}">
					<span class="badge badge-danger">${CognomeError}</span>

				</c:if>
			</div>
		</div>
		<div class="form-group row">
			<label for="inputIndirizzo" class="col-sm-2 col-form-label">Indirizzo</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputIndirizzo"
					name="indirizzo">

				<c:if test="${IndirizzoError != null}">
					<span class="badge badge-danger">${IndirizzoError}</span>

				</c:if>
			</div>
		</div>
		<div class="form-group row">
			<label for="inputTelefono" class="col-sm-2 col-form-label">Telefono</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputTelefono"
					name="telefono">

				<c:if test="${TelefonoError != null}">
					<span class="badge badge-danger">${TelefonoError}</span>

				</c:if>
			</div>
		</div>
		<div class="form-group row">
			<label for="inputData" class="col-sm-2 col-form-label">Data</label>
			<div class="col-sm-10">
				<input type="date" class="form-control" id="inputData"
					name="dataNascita">

				<c:if test="${DataNascitaError != null}">
					<span class="badge badge-danger">${DataNascitaError}</span>

				</c:if>
			</div>
		</div>

		<div class="row">
			<legend class="col-form-label col-sm-2 pt-0">Sesso</legend>
			<div class="col-sm-10">
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

				<c:if test="${SessoError != null}">
					<span class="badge badge-danger">${SessoError}</span>
				</c:if>
			</div>
		</div>

		<div class="form-group row">
			<label for="inputMatricola" class="col-sm-2 col-form-label">Matricola</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputMatricola"
					name="matricola">

				<c:if test="${MatricolaError != null}">
					<span class="badge badge-danger">${MatricolaError}</span>

				</c:if>
			</div>
		</div>

		<div class="form-group row">
			<label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="inputEmail"
					name="email">

				<c:if test="${EmailError != null}">
					<span class="badge badge-danger">${EmailError}</span>

				</c:if>
			</div>
		</div>
		<div class="form-group row">
			<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="inputPassword"
					name="password">

				<c:if test="${PasswordError != null}">
					<span class="badge badge-danger">${PasswordError}</span>

				</c:if>
			</div>
		</div>
		<div class="form-group row">
			<label for="inputConfermaPassword" class="col-sm-2 col-form-label">Conferma
				Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control"
					id="inputConfermaPassword" name="confermaPsw">
				<c:if test="${ConfermaPasswordError != null}"> <span class="badge badge-danger">${ConfermaPasswordError}</span>

				</c:if>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-2">Conferma regolamento sulla privacy</div>
			<div class="col-sm-10">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="accetto"
						name="condizioni"> <label class="form-check-label"
						for="accetto"> Accetto </label> <a
						href="https://www.garanteprivacy.it/il-testo-del-regolamento">Regolamento
						privacy</a>
						
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
