package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import DAO.UsuarioDao;
import beans.Cliente;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Servlet implementation class Cadastrar
 */
@WebServlet("/CadastrarUsuario.do")
public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int idUsuario = 0;
		String cnpj = request.getParameter("cnpj");
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String mail = request.getParameter("mail");
		String senha = request.getParameter("senha");
		String fone = request.getParameter("fone");
		//Date up
		String endereco = request.getParameter("end");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("uf");
		String cep = request.getParameter("cep");
		int idCliente = 123;
		int idClienteUsuario = 12345;
		int idS = 3;
		
		Cliente u = new Cliente(idUsuario, cnpj, cpf, nome, mail, senha, fone, null , endereco, numero, bairro, cidade, uf, cep, idCliente, idClienteUsuario, idS);
		UsuarioDao.cadastrarUsuarioCliente(u);

	}

}
