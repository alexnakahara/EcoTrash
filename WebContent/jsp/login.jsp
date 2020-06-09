<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>EcoTrash</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<!--Boostrap css-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous" />
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css" />
<!-- Fontes awelsome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
	
</head>

<body>
	<header>
		<div class="desk-menu">
			<div class="logo">
				<img class="logo__img" src="${pageContext.request.contextPath}/img/logo3.png" alt="">
			</div>
			<div class="menu">
				<a href="${pageContext.request.contextPath}/index.html" class="menu__text">Home</a> 
				<a href="${pageContext.request.contextPath}/simula.html" class="menu__text">Serviços</a> 
				<a href="${pageContext.request.contextPath}/quemsomos.html" class="menu__text">Quem Somos</a>
			</div>
			<a href="${pageContext.request.contextPath}/jsp/login.jsp" class="login"><i class="fas fa-user"></i></a>
	
		</div>
	
		<div class="mobile-menu">
			<nav class="navbar navbar-light">
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarToggleExternalContent"
					aria-controls="navbarToggleExternalContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			</nav>
			<div class="collapse" id="navbarToggleExternalContent">
				<div class="collapse__menu">
				<a href="${pageContext.request.contextPath}/index.html" class="menu__text">Home</a> 
				<a href="${pageContext.request.contextPath}/simula.html" class="menu__text">Serviços</a> 
				<a href="${pageContext.request.contextPath}/quemsomos.html" class="menu__text">Quem Somos</a>
				<a href="${pageContext.request.contextPath}/jsp/login.jsp" class="menu__text">Entrar</i></a>
				</div>
			</div>
		</div>
	</header>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<div class="fadeIn first">
				<img src="${pageContext.request.contextPath}/img/eco.png" id="icon" alt="User Icon" />
			</div>

			<form method="post" action="${pageContext.request.contextPath}/ServletController.do">
				<input type="hidden" name="acao" value="Login">
				<input type="text" id="email" class="fadeIn second" name="email" placeholder="Digite seu e-mail" /> 
				<input type="password" id="senha" class="fadeIn third" name="senha" placeholder="Digite sua senha" /> 
				<input type="submit" class="fadeIn fourth" value="Entrar" />
			</form>

			<div id="formFooter">
				<a class="underlineHover" href="${pageContext.request.contextPath}/jsp/cadastro.jsp">Não tem cadastro?</a>
			</div>
		</div>
	</div>

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
