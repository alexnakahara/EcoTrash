package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.AgendamentoDAO;
import dao.AutenticacaoDAO;
import dao.UsuarioDao;
import models.Usuario;

@WebServlet("/ServletController.do")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDao daoUsuario = new UsuarioDao();
	
    public ServletController() {
        super();
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	if(req.getParameter("acao").equals("Login")) {
    		
    		this.login(req, resp);
    		
    	} else if (req.getParameter("acao").equals("Logout")) {
    		
			this.logOut(req, resp);
			
		} else if (req.getParameter("acao").equals("cancelarAgendamento")) {
			
			this.cancelarAgendamento(req,resp);
			
		} else if(req.getParameter("acao").equals("confirmarRetirada")) {
			
			this.confirmarRetirada(req, resp);
			
		} else if(req.getParameter("acao").equals("getUsuario")) {
			
			this.getUsuario(req, resp);
		}
    }
    

	private void cancelarAgendamento(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	
		int id_agendamento = Integer.parseInt(req.getParameter("id_agendamento"));
		AgendamentoDAO.deletarAgendamento(id_agendamento);
		resp.sendRedirect("jsp/area-usuario.jsp");
	}

	private void getUsuario(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	
		int id_usuario = Integer.parseInt(req.getParameter("id_usuario"));
		Usuario usuario = daoUsuario.getUsuario(id_usuario);
		
		if(usuario != null) {
			 String json = new Gson().toJson(usuario);
			 resp.setContentType("application/json");
			 resp.setCharacterEncoding("UTF-8");
			 resp.getWriter().write(json);
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	private void confirmarRetirada(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id_colaborador = Integer.parseInt(req.getParameter("id_usuario"));
		int id_agendamento = Integer.parseInt(req.getParameter("id_agendamento"));
		AgendamentoDAO.confirmarRetirada(id_colaborador,id_agendamento);
		resp.sendRedirect("jsp/area-usuario.jsp");
	}

	private void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		resp.sendRedirect("login.html");
		
	}
	
	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		PrintWriter out = resp.getWriter();
		String tx_email = req.getParameter("email");
		String tx_senha = req.getParameter("senha");
		AutenticacaoDAO dao = new AutenticacaoDAO();
		resp.setContentType("text/html");

		if (dao.autenticarUsuario(tx_email, tx_senha)) {
			
			Usuario usuario = dao.getUsuario(tx_email, tx_senha);
			req.getSession().setAttribute("usuario", usuario);
            resp.sendRedirect("jsp/area-usuario.jsp");
            
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('E-mail ou senha inv�lida!!');");
			out.println("</script>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}

		out.close();
		
	}
}
