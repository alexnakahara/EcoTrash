<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="css/area-usuario.css">
</head>
<body>
	<header class="header">
		<div class="header__logo">EcoTrash</div>
		<%
			Usuario u = (Usuario) request.getAttribute("usuario");
			AgendamentoDAO agendaDao = new AgendamentoDAO();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy hh:mm a");
			ArrayList<Agendamento> listAgenda = agendaDao.listAgendamentosDisponiveis();
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
		<div>Você é Colaborador!</div>
		<div class="d-flex justify-content-around">
			<%
				if (listAgenda.isEmpty()) {
					out.print("<div class='empty-coleta'> Nenhuma coleta disponivel no momento!</div>");
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

	</div>
	<script src="https://kit.fontawesome.com/e71e2a1db7.js"
		crossorigin="anonymous"></script>
</body>
</html>