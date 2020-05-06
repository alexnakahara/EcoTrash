package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Usuario;

@WebServlet("/AreaUsuario")
public class AreaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AreaUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Usuario usuario = (Usuario) request.getAttribute("usuario");
		out.print("<h3>Seja bem-vindo " + usuario.getNome() + "!</h3>");

		out.close();
	}

}
