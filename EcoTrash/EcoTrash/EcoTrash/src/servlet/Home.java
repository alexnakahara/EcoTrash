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

import beans.*;
import dao.AgendamentoDAO;
import dao.UsuarioDao;

@WebServlet("/Home.do")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = UsuarioDao.consultarUsuario(1);
		HttpSession session = request.getSession();
		session.setAttribute("id", u.getIdUsuario());
		ArrayList <Agendamento> listagem = AgendamentoDAO.listarAgendamentos(u.getIdUsuario());
		String listar = "<hr>";
		for (Iterator iterator = listagem.iterator(); iterator.hasNext();) {
			Agendamento a = (Agendamento) iterator.next(); 
			listar += "<h4>" + a.getDesc() + " ID: "+  a.getIdAgendamento() + "</h4><br>";
			listar += "<h5>" + a.getDesc() + "</h5><br>"; 
			listar += "<p>" + a.getTexto() + "<p><br>"; 
			listar += "<hr>";
			
		}
		request.setAttribute("agendamentos", listar);
		request.setAttribute("usuario", u);
        RequestDispatcher view = 
        request.getRequestDispatcher("home.jsp");
        view.forward(request, response);
	}

}
