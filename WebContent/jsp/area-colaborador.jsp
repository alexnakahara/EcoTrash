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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/index.js"></script>
</head>
<body>
	<header class="header">
		<div class="header__logo">EcoTrash</div>
		<%
			Usuario u = (Usuario) request.getSession().getAttribute("usuario");
			AgendamentoDAO agendaDao = new AgendamentoDAO();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			ArrayList<Agendamento> listAgenda = agendaDao.listAgendamentosDisponiveis(u.getIdUsuario());
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			boolean a = true;
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
		<div class="who-am-i">Você é um Colaborador!</div>
		<div class="d-flex justify-content-around flex-wrap">
			<%
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
					<div class="row2__text d-flex">
						<div class="font-weight-bold mr-2">Data:</div>
						<%=dateFormat.format(item.getDtAgendada())%>
					</div>
					<div class="row2__text d-flex">
						<div class="font-weight-bold mr-2">Descrição:</div>
						<%=item.getDescricao()%>
					</div>
				</div>
			</div>
			<%
				if (item.getIdColaborador() == 0) {
			%>

			<button class="btn btn-primary" id="btn-confirmar">Confirmar</button>

			<%
				}
			%>
		</div>

		<%
			}
		%>

		<!-- Modal de Agendamento de Coleta-->
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
						<form id="myForm" class="panel-body" method="post"
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
									class="form-control" name="acao" value="confirmarRetirada" />
							</div>
						</form>
						<div class="-infoAgendamento"></div>
					</div>
					<div class="modal-footer d-flex justify-content-center">
						<button type="submit" class="btn btn-danger"
							onclick="onSubmitAgendar()" )>Confirmar Agendamento</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="https://kit.fontawesome.com/e71e2a1db7.js"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>