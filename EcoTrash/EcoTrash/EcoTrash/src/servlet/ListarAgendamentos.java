package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Agendamento;
import dao.AgendamentoDAO;

/**
 * Servlet implementation class ListarAgendamentos
 */
@WebServlet("/ListarAgendamentos.do")
public class ListarAgendamentos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList <Agendamento> listagem = AgendamentoDAO.listarAgendamentosDisponiveis();
		HttpSession session = request.getSession();
		String listar = "<hr>";
		for (Iterator iterator = listagem.iterator(); iterator.hasNext();){

			Agendamento a = (Agendamento) iterator.next(); 
			listar += "<h5> Descrição: " + a.getDesc() + " ID: "+  a.getIdAgendamento() + "</h5><br>";
			listar += "<p> Data de agendamento: " + a.getNome() + "</p><br>"; 
			listar += "<p> Data de agendamento: " + a.getData() + "</p><br>"; 
			listar += "<p>" + a.getTexto() + "<p><br>"; 
			if(a.getIdColetador() == 0) {
				listar += "<p>Disponível<p><br>"; 
				listar += "<form name=\"id\" action=\"AbrirNoticia.do\" method=\"value="+ a.getIdAgendamento() +"/get\" value="+ a.getIdAgendamento() +">";
				listar += "<input name=\"id\" type=\"text\" readonly class=\"form-control-plaintext\" id=\"staticEmail2\" value="+ a.getIdAgendamento() +">" + "<br> <br>";
				listar += "<button type=\"submit\" class=\"btn btn-primary\" >Abrir id "+ a.getIdAgendamento()+"</button>";
				listar += "</form>";
			}else {
				listar += "<p>Indisponível!!<p><br>"; 
			}
			listar += "<hr>";
			
		}
		request.setAttribute("usuario", session.getAttribute("usuario"));
		request.setAttribute("agendamentos", listar);
		RequestDispatcher view = 
		request.getRequestDispatcher("listar.jsp");
		view.forward(request, response);
	}

}
