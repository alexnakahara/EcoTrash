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
	    	
	    	const objResp = JSON.parse(http.response);
	    	const data = moment(agendamento.dtAgendada).format('LLL');
	        const btnConfirm = document.querySelector('#confirmarAgendamento'); 
	        btnConfirm.disabled = false;
	        const cliente = {										
	        		bairro: objResp.bairro,
        			cep: objResp.cep,
        			cidade: objResp.cidade,
        			endNumero: objResp.endNumero,
        			endereco: objResp.endereco,
        			nome: objResp.nome,
        			telefone: objResp.telefone,
        			uf: objResp.uf
	        };

	        if (cliente.nome || cliente.endereco) { // Garantia que vai ter o dados do cliente
	        	verifyIfConfirmed(agendamento.idColaborador, btnConfirm);
	        	const endereco = `${cliente.endereco}, ${cliente.endNumero} - ${cliente.bairro},
	        		${cliente.cidade}/${cliente.uf} - ${cliente.cep}.`;
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
	        	btnConfirm.disabled = true;
	        	btnConfirm.title = 'Não é possível confirmar o agendamento';
	        	bodyData.innerHTML= `<div>
						        		<div class="-infoAgendamento__text">Dados do Cliente</div>
							        		<div class="text-center">
								        		<div class="-infoAgendamento__icons__text">Dados não encontrados, tente novamente mais tarde!</div>
								        		<div class="-infoAgendamento__icons__text">Não é possível confirmar um agendamento sem os dados do cliente.</div>
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
	        }
	    } 
	}
	
	http.send(params);
}

function verifyIfConfirmed(idColaborador, btn){
	
	if (idColaborador != 0 ) {
		btn.disabled = true;
		btn.title = 'Coleta já confirmada!';

	} else {
		btn.disabled = false;
	}
	
}
