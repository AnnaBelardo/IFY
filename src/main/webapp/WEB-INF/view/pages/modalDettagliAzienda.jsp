<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="modal" id="modalDettagliAzienda" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header bg-warning">
				<h5 class="modal-title">Dettagli ${AziendaPerDettagli.ragioneSociale}</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p><b>Descrizione</b> <br>${AziendaPerDettagli.descrizione}</p>
				<p><b>Partita Iva</b> <br>${AziendaPerDettagli.pIva}</p>
				<p><b>Email</b> <br>${DelegatoPerDettagli.email}</p>
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
		$('#modalDettagliAzienda').modal('show');
	});
</script>