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
<title>EcoTrash</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/area-cliente.css">
</head>
<body>
	<header class="header">
		<h2>EcoTrash</h2>
		<%
			Usuario u = (Usuario) request.getAttribute("usuario");
			AgendamentoDAO agendaDao = new AgendamentoDAO();
			ArrayList<Agendamento> listAgenda = agendaDao.listAgendamentosByCliente(u.getIdUsuario());
		%>
		<div class="d-flex justify-content-between">
			<div class="header__nome">
				Olá,
				<%=u.getNome()%>
			</div>
			<div class="header__sair">Sair</div>
		</div>
	</header>
	<div class="container">
		<div>Você é Cliente!</div>
		<div class="d-flex justify-content-around">
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
						<div class="row1__title"><%=item.getTx_titulo()%></div>
						<div class="row1__func">
							<div class="row1__func__edit">
								<i class="fas fa-pencil-alt"></i>
							</div>
							<div class="row1__func__del">
								<i class="fas fa-trash"></i>
							</div>
						</div>
					</div>
					<div class="row2">
						<div class="row2__text">
							<%=item.getTx_descricao()%>
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