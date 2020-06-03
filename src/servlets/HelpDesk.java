package servlets;

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

import models.Agendamento;
import models.Pergunta;
import dao.AgendamentoDAO;
import dao.PerguntaDAO;

/**
 * Servlet implementation class HelpDesk
 */
@WebServlet("/HelpDesk.do")
public class HelpDesk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		ArrayList <Pergunta> listagem = PerguntaDAO.listarPerguntas(id);
		request.setAttribute("usuario", session.getAttribute("usuario"));
		request.setAttribute("lista", listagem);
		RequestDispatcher view = 
		request.getRequestDispatcher("HelpDesk.jsp");
		view.forward(request, response);
	
		
	}

}