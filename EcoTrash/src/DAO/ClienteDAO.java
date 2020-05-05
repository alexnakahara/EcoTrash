package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Cliente;
import DAO.ConnectionFactory;
public class ClienteDAO {
	public static void criar(Cliente cliente) {
		String sqlInsert = "INSERT INTO cliente(id_usuario, id_servico) VALUES (?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			//stm.setInt(1, cliente.getIdCliente());
			stm.setInt(1, cliente.getIdUsuarioCliente());
			stm.setInt(2, cliente.getIdServico());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					cliente.setIdCliente(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
