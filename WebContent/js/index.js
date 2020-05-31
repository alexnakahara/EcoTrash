var glbUser;

function getGlobalUser(user) {
	glbUser = user;
}

function submitAgendar() {
	document.getElementById("formCadastrar").submit();
}

function submitConfirmarRetirada() {
	document.getElementById("formConfirmarRetirada").submit();
}

function openAgendamento(agendamento) {
	const form = document.querySelector('#formConfirmarRetirada');
	const btnConfirm = document.querySelector('#btn-confirmar'); 
	const inputCommand = document.querySelector('#commandAction');
	moment.locale('pt-br');
	document.querySelector('#titleDetalheColeta').innerHTML = `Detalhe da Coleta - [${agendamento.titulo}]`;
	form.style.display ='none';
	document.querySelector('#id_agendamento').value = agendamento.idAgendamento;
	
	if(glbUser == 0 ) {
		console.log('commandAction ==>', inputCommand);
	}
	
	getUser(agendamento);
}



function getUser(agendamento) {
	const bodyData = document.querySelector('.-infoAgendamento');
	const http = new XMLHttpRequest();
	console.log('agendamento ===> ', agendamento);
	const url = window.location.pathname.replace('jsp/area-usuario.jsp', 'ServletController.do');
	// Caso glbUser for um pefil 0 ele quer saber os dados do colaborador que confirmou sua coletar
	// Caso seja um Colaborador ele quer ver os dados do cliente
	const params = `acao=getUsuario&id_usuario=${ glbUser.tipoPerfil == 0 ? agendamento.idColaborador :agendamento.idCliente}`;
	http.open('POST', url, true);
	http.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

	http.onreadystatechange = function() {
		
	    if(http.readyState == 4 && http.status == 200) {
	    	
	    	const user = JSON.parse(http.response);
	    	const data = moment(agendamento.dtAgendada).format('LLL');
	        
	        if (user.nome || user.endereco) { // Garantia que vai ter o dados do usuário
	        	verifyIfConfirmed(agendamento.idColaborador);
	        	const endereco = `${user.endereco}, ${user.endNumero} - ${user.bairro},
	        		${user.cidade}/${user.uf} - ${user.cep}.`;
	        	bodyData.innerHTML= `<div>
						        		<div class="-infoAgendamento__text">Dados do ${glbUser.tipoPerfil == 0 ? 'Colaborador' : 'Cliente'}</div>
							        		<div class="-infoAgendamento__icons">
								        		<i class="fas fa-user"></i>
								        		<div class="-infoAgendamento__icons__text">${user.nome}</div>
								        		<i class="fas fa-phone-alt"></i>
								        		<div class="-infoAgendamento__icons__text">${user.telefone}</div>
								        		<i class="fas fa-map-marker-alt"></i>
								        		<div class="-infoAgendamento__icons__text">${endereco}</div>
							        		</div>
						        		</div>
						        		<div>
							        		<div class="-infoAgendamento__text">Detalhes da solicitação</div>
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
	        	const btnFeedBack =  glbUser != 0 ? 'Não é possível confirmar o agendamento' : 'Delete o Agendamento';
	        	verifyIfConfirmed(agendamento.idColaborador, btnFeedBack);
	        	bodyData.innerHTML= `<div>
						        		<div class="-infoAgendamento__text">Dados do ${glbUser.tipoPerfil == 0 ? 'Colaborador' : 'Cliente'}</div>
							        		<div class="text-center">
									        	<div class="text-justify">
										        	${glbUser.tipoPerfil != 0 ? 'Dados não encontrados, tente novamente mais tarde!' : 
										        	'Seu agendamento de coleta ainda não foi confirmado por nenhum colaborador!'} 
									        	</div>
								        		 <div class="text-justify">
								        		 	${glbUser.tipoPerfil != 0 ? 'Não é possível confirmar um agendamento sem os dados do cliente.' 
								        		 	: 'Caso queira deleta-lo confirme abaixo'}
								        		 </div>
							        		</div>
						        		</div>
						        		<div>
							        		<div class="-infoAgendamento__text">Detalhes da solicitação</div>
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

function verifyIfConfirmed(idColaborador, title='Coleta já confirmada!') {
    const btnConfirm = document.querySelector('#btn-confirmar'); 
   
    if (glbUser.tipoPerfil!= 0) {
		if (idColaborador != 0) { // quer dizer que colaborador já confirmou a retirada
			btnConfirm.disabled = true;
			btnConfirm.title = title;
	
		} else {
			btnConfirm.disabled = false;
		}
    }
	
}
