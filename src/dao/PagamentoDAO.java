package dao;

import java.sql.Connection;
import models.Pagamento;
import models.Usuario;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PagamentoDAO {

	public static boolean pagar(Pagamento pagamento) {
		UsuarioDao usuDao = new UsuarioDao();
		Usuario usuario = usuDao.createFastCliente(pagamento.getCpf(), pagamento.getEmail());

		if (usuario.equals(null))
			return false;

		String query = "INSERT INTO pagamento2 (dt_pagamento, nome_cartao, nu_cartao, nu_cvv, plano, id_cliente) "
				+ "VALUES (UTC_TIMESTAMP(), ?, ?, ?, ?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(query)) {

			stm.setString(1, pagamento.getNomeNoCartao());
			stm.setInt(2, pagamento.getNumeroDoCartao());
			stm.setInt(3, pagamento.getNumeroDeSegurança());
			stm.setInt(4, pagamento.getPlano());
			stm.setInt(5, usuario.getIdUsuario());

			stm.execute();
			return true;

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular a tabela Pagamento.");
			ex.printStackTrace();
			return false;
		}

	}

}