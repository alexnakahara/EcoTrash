package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Agendamento;
import beans.Usuario;

public class AgendamentoDAO {
	public static void agendar(Agendamento a) {
		String sqlInsert = "INSERT INTO agendamento(id_agendamento, id_usuario, dt_agendada, tx_comentarios, nome, idColetador, descricao) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, a.getIdAgendamento());
			stm.setInt(2, a.getIdUsuarios());
			stm.setString(3, a.getData());
			stm.setString(4, a.getTexto());
			stm.setString(5, a.getNome());
			stm.setInt(6, a.getIdColetador());
			stm.setString(7, a.getDesc());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					a.setIdAgendamento(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
	}
	public static ArrayList<Agendamento> listarAgendamentos(int idUsuario) {
			
			String sqlInsert = "SELECT * FROM agendamento "
					+ " WHERE id_Usuario = ? ";
			
			
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				
				stm.setInt(1, idUsuario);
				ResultSet resultado = stm.executeQuery();
				
				ArrayList<Agendamento> lista = new ArrayList<>();
				while (resultado.next()) {
					Agendamento a = new Agendamento();
					a.setIdAgendamento(resultado.getInt("id_agendamento"));
					a.setIdColetador(resultado.getInt("idColetador"));
					a.setData(resultado.getString("dt_agendada"));
					a.setNome(resultado.getString("nome"));
					a.setDesc(resultado.getString("descricao"));
					a.setTexto(resultado.getString("tx_comentarios"));
					lista.add(a);
				}
				return lista;
				
			} catch (SQLException ex) {
				
				System.err.println("NÃ£o foi possÃ­vel manipular "
						+ "a tabela Comentario.");
				ex.printStackTrace();
				
				return null;
			}
		}
	public static ArrayList<Agendamento> listarAgendamentosDisponiveis() {
		
		String sqlInsert = "SELECT * FROM agendamento";
		
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			ResultSet resultado = stm.executeQuery();
			
			ArrayList<Agendamento> lista = new ArrayList<>();
			while (resultado.next()) {
				Agendamento a = new Agendamento();
				a.setIdAgendamento(resultado.getInt("id_agendamento"));
				a.setIdColetador(resultado.getInt("idColetador"));
				a.setData(resultado.getString("dt_agendada"));
				a.setNome(resultado.getString("nome"));
				a.setDesc(resultado.getString("descricao"));
				a.setTexto(resultado.getString("tx_comentarios"));
				lista.add(a);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("NÃ£o foi possÃ­vel manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
			return null;
		}
	}
	public static ArrayList<Agendamento> listarAgendamentosConfirmados(int idColaborador) {
		
		String sqlInsert = "SELECT * FROM agendamento "
				+ " WHERE idColetador = ? ";
		
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setInt(1, idColaborador);
			ResultSet resultado = stm.executeQuery();
			
			ArrayList<Agendamento> lista = new ArrayList<>();
			while (resultado.next()) {
				Agendamento a = new Agendamento();
				a.setIdAgendamento(resultado.getInt("id_agendamento"));
				a.setIdColetador(resultado.getInt("idColetador"));
				a.setData(resultado.getString("dt_agendada"));
				a.setNome(resultado.getString("nome"));
				a.setDesc(resultado.getString("descricao"));
				a.setTexto(resultado.getString("tx_comentarios"));
				lista.add(a);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("NÃ£o foi possÃ­vel manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
			return null;
		}
	}
}