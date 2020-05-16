package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Pergunta;
import dao.PerguntaDAO;
@WebServlet("/Perguntar.do")
public class Perguntar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get Data
		Random r = new Random();
		int id = r.nextInt(25);
		String titulo = request.getParameter("tit");
		String desc = request.getParameter("nome");
		String texto = request.getParameter("text");
		
		//New Noticia
		Pergunta n = new Pergunta(id, titulo, desc, texto);
		
		//Insert Data
		PerguntaDAO.criar(n);
		
	} 
 
}