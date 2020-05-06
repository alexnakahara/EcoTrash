<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Agendamento"%>
<%@page import="dao.AgendamentoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="css/area-usuario.css">

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
<script src="js/index.js"></script>
</head>
<body>
	<header class="header">
		<div class="header__logo">EcoTrash</div>
		<%
			Usuario u = (Usuario) request.getAttribute("usuario");
			AgendamentoDAO agendaDao = new AgendamentoDAO();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy hh:mm a");
			ArrayList<Agendamento> listAgenda = agendaDao.listAgendamentosByCliente(u.getIdUsuario());
		%>
		<div class="d-flex justify-content-between">
			<div class="header__nome">
				Olá,
				<%=u.getNome()%>
			</div>
			<a href="/EcoTrash" class="header__sair">Sair</a>
		</div>
	</header>
	<div class="container">
		<div>Você é Cliente!</div>
		<div class="d-flex justify-content-around">

			<div class="item-agendamento" data-toggle="modal"
				data-target="#modalForm">
				<div class="col1">
					<i class="far fa-calendar-plus"></i>
				</div>
				<div class="col2">
					<div class="font-weight-bold">Agende mais uma coleta!</div>
				</div>
			</div>
			<%
				if (listAgenda.isEmpty()) {
					out.print("<div> Você não fez nenhum agendamento no momento!</div>");
				}

				for (Agendamento item : listAgenda) {
			%>

			<div class="item-agendamento">
				<div class="col1">
					<i class="far fa-calendar-alt"></i>
				</div>
				<div class="col2">
					<div class="row1">
						<div class="font-weight-bold"><%=item.getTitulo()%></div>
					</div>
					<div class="row2">
						<div class="row2__text">
							<%=item.getDescricao()%>
							<%=dateFormat.format(item.getDtAgendada())%>
						</div>
					</div>
				</div>
			</div>

			<%
				}
			%>

		</div>

		<!-- Modal de Agendamento de Coleta-->
		<div class="modal" tabindex="-1" role="dialog" id="modalForm">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Modal title</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form id="myForm" class="panel-body" method="post"
							action="Agendamento.do">
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
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label text-center">Título</label> <input
											type="text" class="form-control" name="titulo" id="titulo">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">Comentários adicionais</label> <input
											type="text" class="form-control" name="descricao"
											id="descricao">
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary"
							onclick="onSubmitAgendar()">Agendar</button>
					</div>
				</div>
			</div>
		</div>


	</div>
	<script src="https://kit.fontawesome.com/e71e2a1db7.js"
		crossorigin="anonymous"></script>
</body>
</html>