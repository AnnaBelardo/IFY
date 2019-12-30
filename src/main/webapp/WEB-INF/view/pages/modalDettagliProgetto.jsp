<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="modal" id="modalDettagliProgetto" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header bg-warning">
				<h5 class="modal-title">Dettagli ${progettoPerDettagli.nome}</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p><b>Ambito</b> <br>${progettoPerDettagli.ambito}</p>
				<p><b>Attività</b> <br>${progettoPerDettagli.attivita}</p>
				<p><b>Conoscenze</b> <br>${progettoPerDettagli.conoscenze}</p>
				<p><b>Data Compilazione:</b> ${progettoPerDettagli.data_compilazione}</p>
				<p><b>Numero massimo partecipanti:</b> ${progettoPerDettagli.max_partecipanti}</p>
				<p><b>Descrizione</b> <br>${progettoPerDettagli.descrizione}</p>
			</div>
			<div class="modal-footer">

				<button type="button" class="btn btn-success modalbutton-conferma btn-danger"
					data-dismiss="modal">Chiudi</button>
			</div>
		</div>
	</div>


</div>

<script>
	$(window).on('load', function() {
		$('#modalDettagliProgetto').modal('show');
	});
</script>