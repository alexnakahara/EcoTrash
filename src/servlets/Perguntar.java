package servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Pergunta;
import models.Usuario;
import dao.PerguntaDAO;
@WebServlet("/Perguntar.do")
public class Perguntar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get Data
		HttpSession session = request.getSession();
		RequestDispatcher view = null;
		Usuario u = (Usuario) session.getAttribute("usuario");
		request.setAttribute("usuario", u);
		int id = (int) session.getAttribute("id");
		String titulo = request.getParameter("tit");
		String desc = request.getParameter("key");
		String texto = request.getParameter("text");   
		request.setAttribute("usuario", u);
		//view = request.getRequestDispatcher("home.jsp");
		//view.forward(request, response);
		
		//New Noticia
		Pergunta n = new Pergunta(0, id, titulo, desc, texto, false);
		
		//Insert Data
		PerguntaDAO.criar(n);
		
	} 
 
}
