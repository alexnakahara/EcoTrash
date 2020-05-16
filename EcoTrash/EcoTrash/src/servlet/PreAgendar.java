package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Usuario;

/**
 * Servlet implementation class Agendar
 */
@WebServlet("/PreAgendar.do")
public class PreAgendar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Usuario u = (Usuario) session.getAttribute("usuario");
		request.setAttribute("usuario", u);
		if(u.isPago() == false){
			out.print("Pagamento pendente!!"); 
		}else {
		    RequestDispatcher view = 
		    request.getRequestDispatcher("agendamento.jsp");
		    view.forward(request, response);
		}
	}

}
