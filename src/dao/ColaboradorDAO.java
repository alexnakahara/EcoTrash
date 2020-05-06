package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Colaborador;
import dao.ConnectionFactory;

public class ColaboradorDAO {
	public int criar(Colaborador colaborador) {
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
			stm.setString(9, colaborador.getEndereco());
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
		sqlInsert = "INSERT INTO colaborador(id_colaborador, id_usuario, dt_cadastro) VALUES (?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, colaborador.getIdColaborador());
			stm.setInt(2, colaborador.getIdUsuarioColaborador());
			stm.setDate(3, colaborador.getDateCadastro());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					colaborador.setIdColaborador(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return colaborador.getIdColaborador();
	}
}
