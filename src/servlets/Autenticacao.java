package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String tx_email = request.getParameter("email");
		String tx_senha = request.getParameter("senha");
		AutenticacaoDAO dao = new AutenticacaoDAO();

		if (dao.autenticarUsuario(tx_email, tx_senha)) {
			Usuario usuario = dao.getUsuario(tx_email, tx_senha);
			String local = null;
			switch (usuario.getTipoPerfil()) {
			case 0: // cliente
				local = "jsp/area-cliente.jsp";
				break;
			case 1: // colaborador
				local = "jsp/area-colaborador.jsp";
				break;
			}
			request.getSession().setAttribute("usuario", usuario);
            response.sendRedirect(local);
            
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('E-mail ou senha inválida!!');");
			out.println("</script>");
			request.getRequestDispatcher("login.html").include(request, response);
		}

		out.close();
	}

}
