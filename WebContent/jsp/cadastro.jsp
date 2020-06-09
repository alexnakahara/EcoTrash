<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>EcoTrash - Cadastro</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous" />
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
	<div class="container">
		<div class="titulo">
			<h2>Faça seu cadastro</h2>
		</div>
		<form class="form-lg" action="${pageContext.request.contextPath}/CadastrarUsuario.do" method="post">
			<div class="form-group">
				<label for="nome">Nome</label> <input type="text"
					class="form-control" id="nome" name="nome">
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="tipoPerfil">Tipo de Perfil</label> <select
						class="form-control" id="tipoPerfil" name="tipoPerfil">
						<option value="0">Cliente</option>
						<option value="1">Colaborador</option>
					</select>
				</div>
				<div class="form-group col-md-6">
					<label for="documento">Documento(CPF ou CNPJ)</label> <input
						type="text" class="form-control" id="documento"
						placeholder="Digite seu documento de identificação"
						name="documento">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="mail">E-mail</label> <input type="email"
						class="form-control" id="mail"
						placeholder="Insira um E-mail Válido" name="mail">
				</div>
				<div class="form-group col-md-6">
					<label for="senha">Senha</label> <input type="Password"
						class="form-control" id="senha" name="senha">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="fone">Telefone</label> <input type="text"
						class="form-control" id="fone" placeholder="(XX) 9 XXXX-XXXX"
						name="fone">
				</div>
				<div class="form-group col-md-6">
					<label for="dt_nascimento">Data de Nascimento</label> <input
						type="date" class="form-control" id="dt_nascimento"
						placeholder="10/06/1999" name="dt_nascimento">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="endereco">Endereço</label> <input type="text"
						class="form-control" id="endereco" name="endereco">
				</div>
				<div class="form-group col-md-4">
					<label for="bairro">Bairro</label> <input type="text"
						class="form-control" id="bairro" name="bairro">
				</div>
				<div class="form-group col-md-2">
					<label for="nu">Número</label> <input type="text"
						class="form-control" id="nu" name="numero">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="cidade">Cidade</label> <input type="text"
						class="form-control" id="cidade" name="cidade">
				</div>
				<div class="form-group col-md-4">
					<label for="uf">UF</label> <input type="text" class="form-control"
						id="uf" name="uf">
				</div>
				<div class="form-group col-md-2">
					<label for="cep"> CEP</label> <input type="text"
						class="form-control" id="cep" name="cep">
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
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