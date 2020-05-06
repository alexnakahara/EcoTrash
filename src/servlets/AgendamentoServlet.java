package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgendamentoServlet
 */
@WebServlet("/Agendamento.do")
public class AgendamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendamentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String data = request.getParameter("dt_agendamento");
		String id = request.getParameter("email");
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		 
		 if(id.equals("bccampos105@gmail.com") || id.contentEquals("lexandrade@live.com")) {
			 
			 saida.print( "Agendamento realizado com sucesso!<br> Data de coleta:" + data + "<br>"+ titulo + "<br>" + descricao);
		 } else {
			 saida.print( "<script> alert('O cliente não foi indentificado!')</script> Agendamento negado!<br> Para agendar é necessario ter um serviço volte em mensalidade e faça. ");
		 }
				 
				 
	}

}
