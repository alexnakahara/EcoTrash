package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Pagamento;
import dao.PagamentoDAO;

@WebServlet("/PagamentoMensal.do")
public class PagamentoMensal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String nomeCartao = request.getParameter("nome");
		String mail = request.getParameter("mail");
		String cpf = request.getParameter("cpf");
		int numCartao = Integer.parseInt(request.getParameter("numCartao"));
		int cvv = Integer.parseInt(request.getParameter("cvv"));
		int plano = 1;

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		RequestDispatcher view;
		Pagamento p = new Pagamento(mail, cpf, nomeCartao, numCartao, cvv, plano);
		
		if (PagamentoDAO.pagar(p)) {
			out.print("<div style='-aler-success'>Pagamento realizado com sucesso!</div>");
			view = request.getRequestDispatcher("Cadastro.html");

		} else {
			out.print("<div style='-aler-error'>Ocorreu um erro durante o pagamento, tente novamente!</div>");
			view = request.getRequestDispatcher("simula.html");
		}
		view.forward(request, response);
	}

}
