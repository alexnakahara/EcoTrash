package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UsuarioDao;
import beans.Pagamento;
import DAO.PagamentoDAO;

@WebServlet("/PagamentoMensal.do")
public class PagamentoMensal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//Get Data
		String nomeCartao = request.getParameter("nome");
		String mail = request.getParameter("mail");
		String cpf = request.getParameter("cpf");
		int numCartao = Integer.parseInt(request.getParameter("numCartao"));
		int cvv = Integer.parseInt(request.getParameter("cvv"));
		int plano = 1;
		 //Get Method
	
		
		Pagamento p = new Pagamento(mail, cpf, nomeCartao, numCartao, cvv, plano);
		PagamentoDAO.pagar(p);
		
		RequestDispatcher view = request.getRequestDispatcher("Cadastro.html");
		view.forward(request, response);
	}

}
