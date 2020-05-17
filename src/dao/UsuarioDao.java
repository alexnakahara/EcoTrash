package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Usuario;

public class UsuarioDao {

	private Connection conexao;

	public UsuarioDao() {
		this.conexao = ConnectionFactory.obtemConexao();
	}

	public void cadastrar(Usuario usu) {

		String sqlInsert = "INSERT INTO usuario(tipo_perfil, tx_documento, tx_nome, tx_email, tx_senha, tx_telefone, dt_nascimento, tx_endereco,"
				+ " tx_endNumero, tx_bairro, tx_cidade, tx_uf, tx_cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stm = conexao.prepareStatement(sqlInsert)) {

			stm.setInt(1, usu.getTipoPerfil());
			stm.setString(2, usu.getDocumento());
			stm.setString(3, usu.getNome());
			stm.setString(4, usu.getEmail());
			stm.setString(5, usu.getSenha());
			stm.setString(6, usu.getTelefone());
			stm.setDate(7, (Date) usu.getNascimento());
			stm.setString(8, usu.getEndereco());
			stm.setString(9, usu.getEndNumero());
			stm.setString(10, usu.getBairro());
			stm.setString(11, usu.getCidade());
			stm.setString(12, usu.getUf());
			stm.setString(13, usu.getCep());
			stm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Usuario createFastCliente(String documento, String email) {

		String query = "INSERT INTO usuario(tipo_perfil, tx_documento, tx_email) VALUES(0, ?, ?)";

		String getUser = "SELECT * FROM usuario WHERE tx_email =?";

		try (PreparedStatement stm = conexao.prepareStatement(query);
				PreparedStatement stm2 = conexao.prepareStatement(getUser)
		) {

			stm.setString(1, documento);
			stm.setString(2, email);
			stm.execute();
			
			stm2.setString(1, email);
			ResultSet result = stm2.executeQuery();
			Usuario usuario = new Usuario();
			if (result.next()) {
				usuario.setIdUsuario(result.getInt("id_usuario"));
				usuario.setDocumento(result.getString("tx_documento"));
				usuario.setEmail(result.getString("tx_email"));
			}

			return usuario;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
