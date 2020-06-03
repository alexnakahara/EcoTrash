<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>EcoTrash</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous" />
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-center align-items-center flex-column" style="height: 100vh;">
			<img src="${pageContext.request.contextPath}/img/logo3.png" style="width: 366px;"/>
			<h4>Desculpe ocorreu um erro!</h4>
			<h5>Caso tenha acesso ao EcoTrash efetue o login</h5>
			<a class="btn btn-primary mb-1" href="${pageContext.request.contextPath}/login.html">Ir para o Login</a>
			Exception is: <%=exception%>
		</div>
	</div>
</body>
</html>