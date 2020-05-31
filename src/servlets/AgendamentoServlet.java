package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AgendamentoDAO;
import models.Agendamento;

@WebServlet("/Agendamento.do")
public class AgendamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AgendamentoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		int id = Integer.parseInt(request.getParameter("id_cliente"));
		PrintWriter out = response.getWriter();
		String data = request.getParameter("dt_agendamento");
		response.setContentType("text/html; charset=UTF-8");
		// recebe nesse formato, tem que estar assim
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		try {
			
			AgendamentoDAO dao = new AgendamentoDAO();
			Date parsedDate = dateFormat.parse(data);
			
			Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
			
			System.out.println("DAaatataa" + timestamp );
			Agendamento agendamento = new Agendamento(id, timestamp, descricao, titulo);
			
			if(dao.cadastrar(agendamento)) {
				response.sendRedirect("jsp/area-usuario.jsp");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Ocorreu um erro no agendamento, tente novamente!');");
				out.println("</script>");
				request.getRequestDispatcher("jsp/area-cliente.jsp").forward(request, response);
			}
					
		} catch (ParseException e) {
			e.printStackTrace();
		}


	}

}
