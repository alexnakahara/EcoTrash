package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Agendamento;
import beans.Usuario;
import dao.AgendamentoDAO;
import dao.UsuarioDao;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");  
		PrintWriter out = response.getWriter();
		Usuario u = new Usuario(email, senha);   
		Usuario u2 = new Usuario();
		u2 = UsuarioDao.autenticar(u);
		RequestDispatcher view = null;
			if(u2.getNome() == null){
				
				        view = request.getRequestDispatcher("simula.html");
			}else{
				HttpSession session = request.getSession();
				session.setAttribute("usuario", u2);
				session.setAttribute("id", u2.getIdUsuario());
				ArrayList <Agendamento> listagem = AgendamentoDAO.listarAgendamentos(u2.getIdUsuario());
				String listar = "<hr>";
				for (Iterator iterator = listagem.iterator(); iterator.hasNext();){

					Agendamento a = (Agendamento) iterator.next(); 
					listar += "<h5> Descrição: " + a.getDesc() + " ID: "+  a.getIdAgendamento() + "</h5><br>";
					listar += "<p> Data de agendamento: " + a.getData() + "</p><br>"; 
					listar += "<p>" + a.getTexto() + "<p><br>"; 
					if(a.getIdColetador() == 0){
						listar += "<p> Nenhum coletador confirmado!!<p><br>";
					}
					listar += "<hr>";
					
				}
				
				if(u2.getTipoUsuario().equals("Cliente") ){
					request.setAttribute("usuario", u2);
					request.setAttribute("agendamentos", listar);
					view = request.getRequestDispatcher("home.jsp");
				}else if(u2.getTipoUsuario().equals("1") ){
					ArrayList <Agendamento> listagem2 = AgendamentoDAO.listarAgendamentosConfirmados(u2.getIdUsuario());
					String listar2 = "<hr>";
					for (Iterator iterator = listagem.iterator(); iterator.hasNext();){

						Agendamento a = (Agendamento) iterator.next(); 
						listar2 += "<h5> Descrição: " + a.getDesc() + " ID: "+  a.getIdAgendamento() + "</h5><br>";
						listar2 += "<p> Data de agendamento: " + a.getNome() + "</p><br>"; 
						listar2 += "<p> Data de agendamento: " + a.getData() + "</p><br>"; 
						listar2 += "<p>" + a.getTexto() + "<p><br>"; 
						listar2 += "<hr>";
						
					}
					request.setAttribute("usuario", u2);
					request.setAttribute("agendamentos", listar2);
					view = request.getRequestDispatcher("homeColaborador.jsp");
				}
				
		        view.forward(request, response);
			}
			
		
	}

}
