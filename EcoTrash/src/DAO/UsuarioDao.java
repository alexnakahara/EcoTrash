package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Cliente;
import beans.Colaborador;

public class UsuarioDao {
	public void cadastrarUsuarioColaborador(Colaborador colaborador) {
		String sqlInsert = "INSERT INTO usuario(id_Usuario, tx_cnpj, tx_cpf, tx_nome, tx_email, tx_senha, tx_telefone, dt_nascimento, tx_endereço, tx_endNumero, tx_bairro, tx_cidade, tx_uf, tx_cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, colaborador.getIdUsuario());
			stm.setString(2, colaborador.getCnpj());
			stm.setString(3, colaborador.getCpf());
			stm.setString(4, colaborador.getNome());
			stm.setString(5, colaborador.getEmail());
			stm.setString(6, colaborador.getSenha());
			stm.setString(7, colaborador.getTelefone());
			stm.setDate(8, colaborador.getNacimento());
			stm.setString(9, colaborador.getEndereço());
			stm.setString(10, colaborador.getEndNumero());
			stm.setString(11, colaborador.getBairro());
			stm.setString(12, colaborador.getCidade());
			stm.setString(13, colaborador.getUf());
			stm.setString(14, colaborador.getCep());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					colaborador.setIdUsuario(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void cadastrarUsuarioCliente(Cliente cliente) {
		String sqlInsert = "INSERT INTO usuarios(tx_cnpj, tx_cpf, tx_nome, tx_email, tx_senha, tx_telefone, dt_nascimento, tx_endereco, tx_endNumero, tx_bairro, tx_cidade, tx_uf, tx_cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			//stm.setInt(1, cliente.getIdUsuario());
			stm.setString(1, cliente.getCnpj());
			stm.setString(2, cliente.getCpf());
			stm.setString(3, cliente.getNome());
			stm.setString(4, cliente.getEmail());
			stm.setString(5, cliente.getSenha());
			stm.setString(6, cliente.getTelefone());
			stm.setDate(7, cliente.getNacimento());
			stm.setString(8, cliente.getEndereço());
			stm.setString(9, cliente.getEndNumero());
			stm.setString(10, cliente.getBairro());
			stm.setString(11, cliente.getCidade());
			stm.setString(12, cliente.getUf());
			stm.setString(13, cliente.getCep());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					cliente.setIdUsuario(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
