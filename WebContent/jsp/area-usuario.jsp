<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="models.Agendamento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.AgendamentoDAO"%>
<%@page import="models.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>EcoTrash</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/area-usuario.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
	
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/moment.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/moment.locale.js"></script>
<!-- Para funcionar o component de datepicker -->
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.12.0/moment.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript"
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#datetimepicker1').datetimepicker();
	});
</script>
</head>
<body>
	<header class="header">
		<div class="header__logo">EcoTrash</div>
		<%
			Usuario u = (Usuario) request.getSession().getAttribute("usuario");
			AgendamentoDAO agendaDao = new AgendamentoDAO();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			ArrayList<Agendamento> listAgenda = u.getTipoPerfil() != 0 ? 
				agendaDao.listAgendamentosDisponiveis(u.getIdUsuario()) : agendaDao.listAgendamentosByCliente(u.getIdUsuario());
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
		%>
		<div class="d-flex justify-content-between align-items-center">
			<div class="header__nome">
				Olá,
				<%=u.getNome()%>
			</div>
			<form class="header__sair"
				action="${pageContext.request.contextPath}/ServletController.do"
				method="post">
				<button class="btn" type="submit" name="acao" value="Logout">
					<i class="fas fa-sign-out-alt"></i>
				</button>
			</form>
		</div>
	</header>
	<div class="container">

		<div class="who-am-i"><%= u.getTipoPerfil() == 0 ? "Você é um Cliente" : "Você é um Colaborador" %></div>
		
		<div class="d-flex justify-content-around flex-wrap">
			<% if (u.getTipoPerfil() == 0) {%>
				<div class="item-agendamento" data-toggle="modal" data-target="#modalCadastroAgendamento">
					<div class="col1">
						<i class="far fa-calendar-plus"></i>
					</div>
					<div class="col2">
						<div class="font-weight-bold text-center">Agende uma coleta!</div>
					</div>
				</div>
			<%
			}
				if (listAgenda.isEmpty()) {
					out.print("<div class='empty-content'> Nenhuma coleta disponível no momento!</div>");
				}

				for (Agendamento item : listAgenda) {

					out.print(
							"<div class='item-agendamento' data-toggle='modal' data-target='#modalForm' onclick='openAgendamento("
									+ gson.toJson(item) + ")'>");
					if (item.getIdColaborador() != 0) {
			%>
			<div class="badge-status">
				<span class="badge badge-success"> <i class="fas fa-check"></i>
					<div class="badge-status__text">Confirmado</div>
				</span>
			</div>
			<%
				}
			%>
			<div class="col1">
				<i class="far fa-calendar-alt"></i>
			</div>
			<div class="col2">
				<div class="row1">
					<div class="font-weight-bold"><%=item.getTitulo()%></div>
				</div>
				<div class="row2">
					<div class="row2__text">
						<div class="font-weight-bold mr-2">Data:</div>
						<%=dateFormat.format(item.getDtAgendada())%>
					</div>
					<div class="row2__text">
						<div class="font-weight-bold mr-2">Descrição:</div>
						<%=item.getDescricao()%>
					</div>
				</div>
			</div>
			<% if (u.getTipoPerfil() != 0 && item.getIdColaborador() == 0) { %>

			<button class="btn btn-primary" id="btn-fake">Confirmar</button>

			<% } %>
			
		</div>

		<%
			} // final for
		%>
		
		<!-- Modal Detalhes de Coleta-->
		<div class="modal" tabindex="-1" role="dialog" id="modalForm">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<div class="modal-title" id="titleDetalheColeta"></div>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body" id="modal-agendamento">
						<form id="formConfirmarRetirada" class="panel-body" method="post"
							action="${pageContext.request.contextPath}/ServletController.do">
							<div class="form-group -form-group2">
								<label class="control-label text-center"></label> id_colaborador<input
									type="text" class="form-control" name="id_colaborador"
									value="<%=u.getIdUsuario()%>" />
							</div>

							<div class="form-group -form-group2">
								<label class="control-label">id_agendamento</label> <input
									type="number" class="form-control" name="id_agendamento"
									id="id_agendamento" value="" /> <input type="hidden"
									class="form-control" name="acao" value="confirmarRetirada" id="commandAction"/>
							</div>
						</form>
						<div class="-infoAgendamento"></div>
					</div>
					
					<div class="modal-footer d-flex justify-content-center">
						<button type="submit" class="btn btn-danger" id="btn-confirmar"
							onclick="submitConfirmarRetirada()" )>Confirmar Agendamento</button>
					</div>
					
				</div>
			</div>
		</div>
		
		
		<!-- Modal de Cadastro de Agendamento de Coleta -->
		<% if(u.getTipoPerfil() == 0 ){ %>
		<div class="modal" tabindex="-1" role="dialog" id="modalCadastroAgendamento">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<div class="modal-title">Agendamento</div>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form id="formCadastrar" class="panel-body" method="post" action="${pageContext.request.contextPath}/Agendamento.do">
							<div class="form-group">
								<label class="control-label">Dia e horário de coleta</label> <input
									hidden type="number" class="form-control" name="id_cliente"
									value="<%=u.getIdUsuario()%>" />
								<div class="input-group date" id="datetimepicker1">
									<input type="text" class="form-control" id="dt"
										name="dt_agendamento" /> <span class="input-group-addon">
										<i class="far fa-calendar-alt"></i>
									</span>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label text-center">Título</label> <input
									type="text" class="form-control" name="titulo" id="titulo">
							</div>

							<div class="form-group">
								<label class="control-label">Descrição</label>
								<textarea type="text" class="form-control" name="descricao"
									rows="4" id="descricao"></textarea>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" onclick="submitAgendar()">Agendar</button>
					</div>
				</div>
			</div>
		</div>
		<%} %>
	</div>
	
<script src="${pageContext.request.contextPath}/js/index.js"></script>
<script type="text/javascript">
	const user = <%= gson.toJson(u) %>
	getGlobalUser(user);
</script>
<script src="https://kit.fontawesome.com/e71e2a1db7.js"
	crossorigin="anonymous"></script>
</body>
</html>