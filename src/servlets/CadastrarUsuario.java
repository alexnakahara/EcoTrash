package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UsuarioDao;
import models.Usuario;

@WebServlet("/CadastrarUsuario.do")
public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDao dao;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int tipoPerfil = Integer.parseInt(request.getParameter("tipoPerfil"));
		String documento = request.getParameter("documento");
		String nome = request.getParameter("nome");
		String mail = request.getParameter("mail");
		String senha = request.getParameter("senha");
		String fone = request.getParameter("fone");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		String endereco = request.getParameter("end");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("uf");
		String cep = request.getParameter("cep");
		
		try {
			
			Date dataNascimento = dateFormat.parse(request.getParameter("dt_nascimento"));
			Usuario u = new Usuario(tipoPerfil, documento, nome, mail, senha,fone, dataNascimento, endereco, numero,bairro, cidade, uf, cep);
			dao.cadastrar(u);
			
		} catch (ParseException e) {

			e.printStackTrace();
		}
				
		

	}

}
