package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Usuario;

public class UsuarioDao {

	private Connection conexao;

	public UsuarioDao() {
		this.conexao = ConnectionFactory.obtemConexao();
	}

	public boolean cadastrar(Usuario usu) { //Se a dataNasc tiver null vai cair no ParseExpection -Servlet CadastrarUsuario
		if(usu.getNome() == null && usu.getDocumento() == null &&
			usu.getEmail() == null && usu.getSenha() == null && 
			usu.getEndereco() == null && usu.getEndNumero() == null &&
			usu.getCep() == null && usu.getBairro() == null && 
			usu.getCidade() == null && usu.getUf() == null &&
			usu.getTelefone() == null) {
			
			return false;
		}

		String sqlInsert = "INSERT INTO usuario(tipo_perfil, tx_documento, tx_nome, tx_email, tx_senha, tx_telefone, dt_nascimento, tx_endereco,"
				+ " tx_endNumero, tx_bairro, tx_cidade, tx_uf, tx_cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stm = conexao.prepareStatement(sqlInsert)) {

			stm.setInt(1, usu.getTipoPerfil());
			stm.setString(2, usu.getDocumento());
			stm.setString(3, usu.getNome());
			stm.setString(4, usu.getEmail());
			stm.setString(5, usu.getSenha());
			stm.setString(6, usu.getTelefone());
			stm.setDate(7, new java.sql.Date(usu.getNascimento().getTime()));
			stm.setString(8, usu.getEndereco());
			stm.setString(9, usu.getEndNumero());
			stm.setString(10, usu.getBairro());
			stm.setString(11, usu.getCidade());
			stm.setString(12, usu.getUf());
			stm.setString(13, usu.getCep());
			stm.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
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
	
	public Usuario getUsuario(int id_usuario) {
		String query = "SELECT * FROM usuario WHERE id_usuario =?";
		
		try (PreparedStatement stm = conexao.prepareStatement(query)) {
			
			stm.setInt(1, id_usuario);
			ResultSet result = stm.executeQuery();
			Usuario u = new Usuario();
			
			if(result.next()) {
				u.setIdUsuario(result.getInt("id_usuario"));
				u.setTipoPerfil(result.getInt("tipo_perfil"));
				u.setNome(result.getString("tx_nome"));
				u.setTelefone(result.getString("tx_telefone"));
				u.setEndereco(result.getString("tx_endereco"));
				u.setEndNumero(result.getString("tx_endNumero"));
				u.setBairro(result.getString("tx_bairro"));
				u.setCep(result.getString("tx_cep"));
				u.setUf(result.getString("tx_uf"));
				u.setCidade(result.getString("tx_cidade"));
			}
			
			return u; 
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
