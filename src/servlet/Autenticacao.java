package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AutenticacaoDAO;
import models.Usuario;

@WebServlet("/Autenticacao.do")
public class Autenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Autenticacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String tx_email = request.getParameter("email");
		String tx_senha = request.getParameter("senha");
		AutenticacaoDAO dao = new AutenticacaoDAO();

		if (dao.autenticarUsuario(tx_email, tx_senha)) {
			request.setAttribute("usuario", dao.getUsuario(tx_email, tx_senha)); // mandando o obj para a servlet
			RequestDispatcher rd = request.getRequestDispatcher("AreaUsuario");
			rd.forward(request, response);
		} else {
			out.print("<center>Desculpe email ou senha inválida!</center>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}

		out.close();
	}

}
