package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Agendamento;
import beans.Usuario;
import dao.AgendamentoDAO;

/**
 * Servlet implementation class Agendar
 */
@WebServlet("/Agendar.do")
public class Agendar extends HttpServlet {
	private String getDateTime() {
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date(0);
	    return dateFormat.format(date);
	}
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		
		int id = 0;
		int idUsuario = (int) session.getAttribute("id");
		String data = getDateTime();
		String text = request.getParameter("text");
		String nome = request.getParameter("nome");
		String desc = request.getParameter("desc");
		int idColetador = 0;
		
		Agendamento a = new Agendamento(id, idUsuario, idColetador, data, nome, desc, text );
		AgendamentoDAO.agendar(a);

		
	}

}
