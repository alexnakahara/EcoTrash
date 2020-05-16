package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.UsuarioDao;
import beans.Usuario;

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
		String cnpj_cpf = request.getParameter("cnpj");
		String nome = request.getParameter("nome");
		String mail = request.getParameter("mail");
		String senha = request.getParameter("senha");
		String fone = request.getParameter("fone");
		//Date up
		String data =  request.getParameter("data");
		String endereco = request.getParameter("end");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro"); 
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("uf"); 
		String cep = request.getParameter("cep");
		String tipo = request.getParameter("tipo");
		int idS = 0;
		if(request.getParameter("servico").equals("Mensal")){
			idS = 1; 
		}else if(request.getParameter("servico").equals("Trimestral")){
			idS = 2;
		}else if(request.getParameter("servico").equals("Anual")){
			 idS = 3;
		} 
		boolean isPago = false;  
		
		Usuario u = new Usuario(idUsuario, cnpj_cpf, nome, mail, senha, fone, data , endereco, numero, bairro, cidade, uf, cep, tipo, idS,  isPago);
		UsuarioDao.cadastrarUsuario(u);

	}

}
