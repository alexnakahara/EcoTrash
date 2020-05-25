package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AgendamentoDAO;

@WebServlet("/ServletController.do")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ServletController() {
        super();
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	if (req.getParameter("acao").equals("Logout")) {
			this.logOut(req, resp);
		} else if(req.getParameter("acao").equals("confirmarRetirada")) {
			this.confirmarRetirada(req, resp);
		}
    }
    
	private void confirmarRetirada(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id_colaborador = Integer.parseInt(req.getParameter("id_colaborador"));
		int id_agendamento = Integer.parseInt(req.getParameter("id_agendamento"));
		AgendamentoDAO.confirmarRetirada(id_colaborador,id_agendamento);
		resp.sendRedirect("jsp/area-colaborador.jsp");
	}

	private void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		resp.sendRedirect("login.html");
		
	}
}
