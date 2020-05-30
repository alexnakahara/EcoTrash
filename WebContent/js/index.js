function onSubmitAgendar() {
	document.getElementById("myForm").submit();
}

function openAgendamento(agendamento) {
	const form = document.querySelector('#myForm');
	moment.locale('pt-br');
	document.querySelector('#titleDetalheColeta').innerHTML = `Detalhe da Coleta - [${agendamento.titulo}]`;
	form.style.display ='none';
	document.querySelector('#id_agendamento').value = agendamento.idAgendamento;
	getUser(agendamento);
}



function getUser(agendamento) {
	const bodyData = document.querySelector('.-infoAgendamento');
	const http = new XMLHttpRequest();
	const url = window.location.pathname.replace('jsp/area-colaborador.jsp', 'ServletController.do');
	const params = `acao=getUsuario&id_cliente=${agendamento.idCliente}`;
	http.open('POST', url, true);
	http.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	http.onreadystatechange = function() {
	    if(http.readyState == 4 && http.status == 200) {
	        const cliente = JSON.parse(http.response);
	        console.log('cliente ', cliente);
	        const endereco = `${cliente.endereco}, ${cliente.endNumero} - ${cliente.bairro},
	         ${cliente.cidade}/${cliente.uf} - ${cliente.cep}.`;
	        const data = moment(agendamento.dtAgendada).format('LLL');
	    	bodyData.innerHTML= `<div>
    								<div class="-infoAgendamento__text">Dados do Cliente</div>
    									<div class="-infoAgendamento__icons">
	    									<i class="fas fa-user"></i>
	    									<div class="-infoAgendamento__icons__text">${cliente.nome}</div>
	    									<i class="fas fa-phone-alt"></i>
	    									<div class="-infoAgendamento__icons__text">${cliente.telefone}</div>
	    									<i class="fas fa-map-marker-alt"></i>
	    									<div class="-infoAgendamento__icons__text">${endereco}</div>
    									</div>
	    							</div>
    							<div>
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
	    } else {
	    	bodyData.innerHTML= 'Desculpe dados não encontrado, tente novamente mais tarde!';
	    }
	}
	
	http.send(params);
}

