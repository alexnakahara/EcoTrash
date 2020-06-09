package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
	private UsuarioDao daoUsuario = new UsuarioDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int tipoPerfil = Integer.parseInt(request.getParameter("tipoPerfil"));
		String documento = request.getParameter("documento");
		String nome = request.getParameter("nome");
		String mail = request.getParameter("mail");
		String senha = request.getParameter("senha");
		String fone = request.getParameter("fone");
		String data = request.getParameter("dt_nascimento");
		String endereco = request.getParameter("endereco");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("uf");
		String cep = request.getParameter("cep");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		try {

			Date dataNascimento = dateFormat.parse(data);
			Usuario u = new Usuario(tipoPerfil, documento, nome, mail, senha, fone, dataNascimento, endereco, numero,
					bairro, cidade, uf, cep);

			if (daoUsuario.cadastrar(u)) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Usu�rio cadastrado com sucesso!');");
				out.println("location='jsp/login.jsp';");
				out.println("</script>");
			} else {
				
				out.print("<script> alert('Ocorreu um erro, tente novamente mais tarde!')</script>");
				request.getRequestDispatcher("jsp/cadastro.jsp").include(request, response);
			}

		} catch (ParseException e) {

			e.printStackTrace();
			out.print("<script> alert('Ocorreu um erro, tente novamente mais tarde!')</script>");
			request.getRequestDispatcher("jsp/cadastro.jsp").include(request, response);

		}

	}

}
