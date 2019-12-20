<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Registrazione studente</title>
<meta charset="utf-8">
<link rel="stylesheet" href="webjars/bootstrap/4.4.1/css/bootstrap.css">
<link href="<c:url value="/resources/css/formStylePage.css" />" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">
	
		<form class="form-horizontal" role="form" name="iscrizioneForm"
			method="post" action="/richiestaIscrizione"
			modelAttribute="studenteForm">
			<h3>Richiesta iscrizione studente</h3>
			<div class="row">
				<div class="col-6">
					<div class="form-group">
						<div class="col-sm-11">
							<c:choose>
								<c:when test="${NomeError == null}">
									<input type="text" name="nome" id="inputNome"
										placeholder="Nome" class="form-control"
										value="${studenteForm.nome}">
								</c:when>
								<c:otherwise>
									<input type="text" name="nome" id="inputNome" placeholder="Nome" class="form-control is-invalid">
									<span class = "myError">${NomeError}</span>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-11">
							<c:choose>
								<c:when test="${CognomeError == null}">
									<input type="text" name="cognome" id="inputCognome"
										placeholder="Cognome" class="form-control"
										value="${studenteForm.cognome}">
								</c:when>
								<c:otherwise>
									<input type="text" name="cognome" id="inputCognome"
										placeholder="Cognome" class="form-control is-invalid">
										<span class = "myError">${CognomeError}</span>	
								</c:otherwise>
							</c:choose>

						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-11">
							<c:choose>
								<c:when test="${IndirizzoError == null}">
									<input type="text" name="indirizzo" id="inputIndirizzo"
										placeholder="Indirizzo" class="form-control"
										value="${studenteForm.indirizzo}">
								</c:when>
								<c:otherwise>
									<input type="text" name="indirizzo" id="inputIndirizzo"
										placeholder="Indirizzo" class="form-control is-invalid">
									<span class = "myError">${IndirizzoError}</span>
								</c:otherwise>
							</c:choose>

						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-11">

							<c:choose>
								<c:when test="${TelefonoError == null}">
									<input type="text" name="telefono" id="inputTelefono"
										placeholder="Telefono" class="form-control"
										value="${studenteForm.telefono}">
								</c:when>
								<c:otherwise>
									<input type="text" name="telefono" id="inputTelefono"
										placeholder="Telefono" class="form-control is-invalid">
									<span class = "myError">${IndirizzoError}</span>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
					<div class="form-group">
						<label for="inputData" class="col-sm-4 control-label">Data
							Nascita</label>
						<div class="col-sm-11">
							<c:choose>
								<c:when test="${DataNascitaError == null}">
									<input type="date" class="form-control" id="inputData"
										name="dataNascita" value="${studenteForm.dataNascita}">
								</c:when>
								<c:otherwise>
									<input type="date" class="form-control is-invalid" id="inputData"
										name="dataNascita">
									<span class = "myError">${DataNascitaError}</span>
								</c:otherwise>
							</c:choose>
						</div>
					</div>

				</div>
				<div class="col-6">

					<div class="form-group">
						<label class="control-label col-sm-3">Sesso</label>
						<div class="col-sm-11">

							<c:choose>
								<c:when
									test="${SessoError == null && studenteForm.sesso == 'F'}">
									<div class="row">
										<div class="col-sm-4">
											<label class="radio-inline"> <input type="radio"
												name="sesso" id="maschio" value="M"> M
											</label>
										</div>
										<div class="col-sm-4">
											<label class="radio-inline"> <input type="radio"
												name="sesso" id="femmina" value="F" checked> F
											</label>
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="row">
										<div class="col-sm-4">
											<label class="radio-inline"> <input type="radio"
												name="sesso" id="maschio" value="M" checked> M
											</label>
										</div>
										<div class="col-sm-4">
											<label class="radio-inline"> <input type="radio"
												name="sesso" id="femmina" value="F"> F
											</label>
										</div>
										
										<c:if test="${SessoError != null}">
											<span class = "myError">${SessoError}</span>
										</c:if>
									</div>
								</c:otherwise>
							</c:choose>



						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-11">
							<c:choose>
								<c:when test="${MatricolaError == null}">
									<input type="text" name="matricola" id="inputMatricola"
										placeholder="Matricola" class="form-control"
										value="${studenteForm.matricola}">
								</c:when>
								<c:otherwise>
									<input type="text" name="matricola" id="inputMatricola"
										placeholder="Matricola" class="form-control is-invalid">
									<span class = "myError">${MatricolaError}</span>
								</c:otherwise>
							</c:choose>
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-11">
							<c:choose>
								<c:when test="${EmailError == null}">
									<input type="email" name="email" id="inputEmail"
										placeholder="E-mail" class="form-control"
										value="${studenteForm.email}">
								</c:when>
								<c:otherwise>
									<input type="email" name="email" id="inputEmail"
										placeholder="E-mail" class="form-control is-invalid">
									<span class = "myError">${EmailError}</span>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-group">

						<div class="col-sm-11">
							<c:choose>
								<c:when test="${PasswordError == null}">
									<input type="password" name="password" id="inputPassword"
										placeholder="Password" class="form-control"
										value="${studenteForm.password}">
								</c:when>
								<c:otherwise>
									<input type="password" name="password" id="inputPassword"
										placeholder="Password" class="form-control is-invalid"
										class="form-control">
									<span class = "myError">${PasswordError}</span>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-11">
							<c:choose>
								<c:when test="${ConfermaPasswordError == null}">
									<input type="password" name="confermaPsw"
										id="inputConfermaPassword" placeholder="Conferma Password"
										class="form-control" value="${studenteForm.password}">
								</c:when>
								<c:otherwise>
									<input type="password" name="confermaPsw"
										id="inputConfermaPassword" placeholder="Conferma Password"
										class="form-control is-invalid">
									<span class = "myError">${ConfermaPasswordError}</span>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-11">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" id="accetto"
											name="condizioni">
										<label class="form-check-label" for="accetto"> Accetto
										</label>
										<a
											href="https://www.garanteprivacy.it/il-testo-del-regolamento">Regolamento
											privacy</a>


							</div>

							<c:if test="${CondizioniError != null}">
								<span class = "myError">${CondizioniError}</span>
							</c:if>
						</div>
					</div>
				</div>
				<button type="submit" id="reg" class="btn btn-primary btn-block">Registrati</button>
			</div>
		</form>
	</div>
	<!-- ./container -->
	
	
</body>
</html>