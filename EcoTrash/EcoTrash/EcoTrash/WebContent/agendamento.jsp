 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="beans.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
  <head>
    <title>EcoTrash - Cadastro</title>
    <meta charset="utf-8">
	<!--Boostrap css-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <!-- Fontes awelsome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous" />		
	<!-- Font Google-->
	<link href="https://fonts.googleapis.com/css?family=Amatic+SC|Press+Start+2P&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans|Open+Sans+Condensed:300&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Quicksand&display=swap" rel="stylesheet">
	<!--My css-->
	<link rel="stylesheet" type="text/css" href="css/Simula.css">

  </head>
  <body>   
  	<div class="container">
  	<%Usuario u = (Usuario)request.getAttribute("usuario"); %>
  	<h4>Olá <%=u.getNome()%>, já pode continuar com seu agendamento!!</h4>
  <form action="Agendar.do" method="post">
      <div class="form-row">
        <div class="form-group col-md-6">
          <label for="inputEmail4">Nome</label>
          <input type="text" class="form-control" id="inputEmail4" name="nome" placeholder="Digite o nome do reponsável pelo agendamento">
        </div>
        <div class="form-group col-md-6">
          <label for="inputPassword4">Descrição</label>
          <input type="text" class="form-control" id="inputPassword4" placeholder="Dê um nome ao seu agendamento..." name="cnpj">
        </div>
      </div>
      <div class="form-group">
        <label for="exampleFormControlTextarea1">Observações:</label>
        <textarea class="form-control" id="exampleFormControlTextarea1" rows="6" name="text"></textarea>
      </div>
      <button type="submit" class="btn btn-primary">Enviar</button>
    </form>
	</div>


	




<!--=========================================Script========================================================-->


  </body>
</html>