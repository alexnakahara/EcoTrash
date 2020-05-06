package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		int id = Integer.parseInt(request.getParameter("id_cliente"));
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		String data = request.getParameter("dt_agendamento");

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");

		try {
			
			AgendamentoDAO dao = new AgendamentoDAO();
			Date parsedDate = dateFormat.parse(data);
			Agendamento agendamento = new Agendamento(id, parsedDate, descricao, titulo);
			
			if(dao.cadastrar(agendamento)) {
			saida.print("<div>Agendamento feito com sucesso</div>");
			} else {
				saida.print("<div>Houve um erro no agendamento, tente novamente!</div>");
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/area-cliente.jsp");
			rd.include(request, response);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
