
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="models.Usuario" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
  <head>
    <title>EcoTrash - HelpDesk</title>
                <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!--Boostrap css-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <!-- Fontes awelsome -->
     <script src="https://kit.fontawesome.com/493be4937f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous" />		
	<!-- Font Google-->
	<link href="https://fonts.googleapis.com/css?family=Amatic+SC|Press+Start+2P&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans|Open+Sans+Condensed:300&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Quicksand&display=swap" rel="stylesheet">
	<!--My css-->
  </head>
  <body>
    	<%Usuario u = (Usuario)request.getAttribute("usuario"); %>
  		  	<nav class="navbar navbar-dark bg-dark">
				      <a class="navbar-brand" href="#">
				        <i class="fas fa-trash-alt" class="d-inline-block align-top"></i>
				      <%=u.getNome()%> - Precisa de ajuda?
				      </a>
				    <form action="home.jsp" method="get">
				    <button type="submit" class="btn btn-success">
				      HOME <span class="badge badge-light"></span>
				    </button>
				    </form>
		    </nav>
		    <br>
  	<div class="container">


            <!-- /.modal -->
            <!-- Barra superior com os menus de navegação -->

            <!-- Container Principal -->
            <div id="main" class="container">
                <form action="ListarAgendamentos.do" method="post">
                    <!-- /#top -->
                </form>
                <br>
                <hr/>
                <center><h4>FAQ - EcoTrash</h4></center>
                <hr>
                <br>
				<div class="accordion" id="accordionExample">
				  <div class="card">
				    <div class="card-header" id="headingOne">
				      <h5 class="mb-0">
				        <button class="btn btn collapsed" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
				          Como realizar um agendamento?
				        </button>
				      </h5>
				    </div>
				
				    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
				      <div class="card-body">
						<h6>É muito simples...</h6>
						Após realizar seu login no nosso site, e contratar um plano
						, basta você escolher a opção "Realizar agendamento", coloque
						o tipo de material, uma observação (EX: Trazer luva) e pronto!!
						Agora é só aguardar seu agendamento ser confiramdo por um dos nossos
						coletadores :)
				      </div>
				    </div>
				  </div>
				  <div class="card">
				    <div class="card-header" id="headingTwo">
				      <h5 class="mb-0">
				        <button class="btn btncollapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
				          Coloquei um horário no agendamento, mas ocorreu um imprevisto, o que eu faço?
				        </button>
				      </h5>
				    </div>
				    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
				      <div class="card-body">
				      Logo após que um dos nosso parceiros coletadores confirmarem a sua coleta, vocês verão o contato
				      um do outro, sendo assim, informe seu coletador do ocorrido, e alinhe com ele um melhor horário para 
				      ser realizado a sua coleta!! ;)
				      </div>
				    </div>
				  </div>
				  <div class="card">
				    <div class="card-header" id="headingThree">
				      <h5 class="mb-0">
				        <button class="btn btn collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
				          Meu plano venceu!! E agora?
				        </button>
				      </h5>
				    </div>
				    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
				      <div class="card-body">
				       É simples meu amigo ;) <br>
				       Entre em <a href="#">www.Ecotrash.com.br</a> e realize a sua renovação!!
				       é só você inserir as suas informações para pagamento, assim que o mesmo for confirmado
				       você poderá continuar a agendar as suas coletas!!
				      </div>
				    </div>
				  </div>
				  <div class="card">
				    <div class="card-header" id="headingFour">
				      <h5 class="mb-0">
				        <button class="btn btn collapsed" type="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
				          Como ver os meus agendamento?
				        </button>
				      </h5>
				    </div>
				    <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionExample">
				      <div class="card-body">
				       Após realizar o seu login no nosso site, vá em Agendamentos > Meus Agendamentos,
				       ou então clique na opção "Agendamentos" na barra superior da sua página!! ;)
				      </div>
				    </div>
				  </div>
				  <div class="card">
				    <div class="card-header" id="headingFive">
				      <h5 class="mb-0">
				        <button class="btn btn collapsed" type="button" data-toggle="collapse" data-target="#collapsefive" aria-expanded="false" aria-controls="collapseFive">
				          Como saber que meu agendamento foi confirmado?
				        </button>
				      </h5>
				    </div>
				    <div id="collapseFive" class="collapse" aria-labelledby="headingfive" data-parent="#accordionExample">
				      <div class="card-body">
				       É simples meu amigo ;) <br>
				       Entre em <a href="#">www.Ecotrash.com.br</a> e realize a sua renovação!!
				       é só você inserir as suas informações para pagamento, assim que o mesmo for confirmado
				       você poderá continuar a agendar as suas coletas!!
				      </div>
				    </div>
				  </div>
				  <div class="card">
				    <div class="card-header" id="headingThree">
				      <h5 class="mb-0">
				        <button class="btn btn collapsed" type="button" data-toggle="collapse" data-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
				          Tudo certo com a coleta!! o que faço agora?
				        </button>
				      </h5>
				    </div>
				    <div id="collapseSix" class="collapse" aria-labelledby="headingSix" data-parent="#accordionExample">
				      <div class="card-body">
				       É simples meu amigo ;) <br>
				       Entre em <a href="#">www.Ecotrash.com.br</a> e realize a sua renovação!!
				       é só você inserir as suas informações para pagamento, assim que o mesmo for confirmado
				       você poderá continuar a agendar as suas coletas!!
				      </div>
				    </div>
				  </div>
				  <div class="card">
				    <div class="card-header" id="headingSeven">
				      <h5 class="mb-0">
				        <button class="btn btn collapsed" type="button" data-toggle="collapse" data-target="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
				          Meu plano venceu!! E agora?
				        </button>
				      </h5>
				    </div>
				    <div id="collapseSeven" class="collapse" aria-labelledby="headingSeven" data-parent="#accordionExample">
				      <div class="card-body">
				       É simples meu amigo ;) <br>
				       Entre em <a href="#">www.Ecotrash.com.br</a> e realize a sua renovação!!
				       é só você inserir as suas informações para pagamento, assim que o mesmo for confirmado
				       você poderá continuar a agendar as suas coletas!!
				      </div>
				    </div>
				  </div>
				</div>
				<br>
				<hr>
				<center><h4>Não encontrou? - Dê uma olhadinha nas suas perguntas, ou faça uma!!</h4></center>
				<hr>
				<br>
                <c:if test="${ empty lista}">
                <center>
                	<p class="text-danger"><strong>Você ainda não fez nenhuma pergunta!!</strong>
                	</center>
                </c:if>
                <c:if test="${not empty lista}">
                <div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>Título</th>
                                    <th>Assunto</th>
                                    <th>Pergunta...</th>
                                    <th class="actions">Dê uma olhada</th>
                                </tr>
                            </thead>
                            <tbody>
          					<c:forEach var="listar" items="${lista }">

          					
                                       <tr>
                                            <td>
                                                ${listar.titulo }
                                            </td>
                                            <td>
                                                ${listar.nome }
                                            </td>
                                            <td>
                                                ${listar.text }
                                            </td>
                                            <td class="actions">
                                                <a class="btn btn-success btn-xs" href="ManterCliente.do?acao=Visualizar&id=${cliente.id }">Visualizar</a>
                                                     
                                            </td>
                                        </tr>
                            </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>
                <!-- /#list -->

                </c:if>
                                    <div class="container">
                    							<form action="PrePerguntar.do" method="get">
	                        <div >
	                            <button type="submit" class="btn btn-success btn-lg btn-block">Pergunte-nos Algo</button>
	                            
	                        </div>
	                        <hr>
	                        <br>
	                        <hr>
                        </form>
                    </div>
                <!-- /#bottom -->
            </div>
            <!-- /#main -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
            <script type="text/javascript">
                $("#delete-modal").on('show.bs.modal', function(event) {
                    var button = $(event.relatedTarget); //botao que disparou a modal
                    var recipient = button.data('cliente');
                    $("#id_excluir").val(recipient);
                });
            </script>
	</div>


	




<!--=========================================Script========================================================-->


  </body>
</html>