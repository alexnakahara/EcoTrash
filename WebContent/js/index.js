$(document).ready(function() {
	$('#datetimepicker1').datetimepicker();
});

function onSubmitAgendar() {
	document.getElementById("myForm").submit();
}

function openAgendamento(agendamento) {
	moment.locale('pt-br');
	const data = moment(agendamento.dtAgendada).format('LLL');
	document.querySelector('#titleDetalheColeta').innerHTML = `Detalhe da Coleta - [${agendamento.titulo}]`;
	const form = document.querySelector('#myForm');
	form.style.display ='none';
	const bodyData = document.querySelector('.-infoAgendamento');
	document.querySelector('#id_agendamento').value = agendamento.idAgendamento;
	bodyData.innerHTML=`	
							<div class="-infoAgendamento__container">
								<div class="-infoAgendamento__text">Dados do Cliente</div>
								<div class="-infoAgendamento__icons">
									<i class="fas fa-user"></i>
									<div class="-infoAgendamento__icons__text">Nome</div>
									<i class="fas fa-phone-alt"></i>
									<div class="-infoAgendamento__icons__text">Telefone</div>
									<i class="fas fa-map-marker-alt"></i>
									<div class="-infoAgendamento__icons__text">endereço</div>
								</div>
							</div>
							<div class="-infoAgendamento__container">
								<div class="-infoAgendamento__text">Detalhe da solicitação</div>
								<div class="-infoAgendamento__icons">
									<i class="far fa-calendar-alt"></i>
									<div class="-infoAgendamento__icons__text">${data}</div>
									<i class="far fa-trash-alt"></i>
									<div class="-infoAgendamento__icons__text">${agendamento.titulo}</div>
									<i class="far fa-comment-alt"></i>
									<div class="-infoAgendamento__icons__text">${agendamento.descricao}</div>
								</div>
							</div>`;
}

function confirmarAgendamento(id_colaborador, id_agendamento){
	console.log('qui');
}