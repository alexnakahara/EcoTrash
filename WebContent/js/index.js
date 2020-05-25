$(document).ready(function() {
	$('#datetimepicker1').datetimepicker();
});

function onSubmitAgendar() {
	document.getElementById("myForm").submit();
}

function openAgendamento(agendamento) {
	console.log('agendamento', agendamento);
	moment.locale('pt-br');
	const data = moment(agendamento.dtAgendada).format('LLL');
	console.log(`${data}`);
	
	document.querySelector('#id_agendamento').value = agendamento.idAgendamento;
	
}

function confirmarAgendamento(id_colaborador, id_agendamento){
	console.log('qui');
}