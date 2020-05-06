package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Usuario;

import java.sql.ResultSet;

public class AutenticacaoDAO {

	private Connection conexao;

	public AutenticacaoDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public Usuario getUsuario(String tx_email, String tx_senha) {

		String inserir = "SELECT * FROM usuario WHERE tx_email = ? AND tx_senha = ? ";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setString(1, tx_email);
			pst.setString(2, tx_senha);
			ResultSet resultado = pst.executeQuery();

			Usuario u = new Usuario();
			if (resultado.next()) {
				u.setTx_nome(resultado.getString("tx_nome"));
			}

			return u;

		} catch (SQLException ex) {

			System.err.println("N√o foi poss√≠vel manipular " + "a tabela usuario.");
			ex.printStackTrace();

			return null;
		}
	}

	public boolean autenticarUsuario(String tx_email, String tx_senha) {
		
		String inserir = "SELECT * FROM usuario WHERE tx_email = ? AND tx_senha = ? ";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setString(1, tx_email);
			pst.setString(2, tx_senha);
			ResultSet resultado = pst.executeQuery();

			return resultado.next();

		} catch (SQLException ex) {

			System.err.println("N√o foi poss√≠vel manipular " + "a tabela usuario.");
			ex.printStackTrace();

			return false;
		}
	}

}
