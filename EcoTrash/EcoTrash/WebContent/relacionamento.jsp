<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.Noticia" %>
    <%@page import="model.Comentario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Noticia></title>
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
	<link rel="stylesheet" type="text/css" href="css/listar.css">
</head>
<body>
	<%Pergunta n = (Pergunta)request.getAttribute("pergunta"); %>
	<%String recebe = (String)request.getAttribute("resposta"); %>
<div class="container"> 
<br>
	<hr>
	<h2 style="color: white;">RealNews</h2>
	<hr>
	<br>
	<h3 style="color: white;" ><%=n.getTitulo() %></h3>
	<br>
	<h5><%=n.getDescricao() %></h5>
		
		<p><%=n.getText() %><br></p>
	
	<br>
	
		<br>
		<h4>Comentários:</h4>
		<hr>
</div>
	<div class="container">
		<%
		if (recebe == ""){
			out.print("<p> Sem comentários </p>");
		}else
		
			out.print(recebe);
		%>
	</div>
		<form action="Comentar.do" method="post">
		<div class="container" id="form">
			<div class="form-group text-light">
			      <label for="inputEmail4">Nome</label>
			      <input type="text" class="form-control" id="inputEmail4" name="nome">
			    </div>
			<div class="form-group">
				    <label for="exampleFormControlTextarea1">Digite seu comentário!!</label>
				    <textarea class="form-control" id="exampleFormControlTextarea1" rows="6" name="texto"></textarea>
			  </div>
			  <button type="submit" class="btn btn-primary">Enviar</button>
		</div>
	</form>
	
	
	
	
	
<a href="index.html">Menu</a>


</body>
</html>