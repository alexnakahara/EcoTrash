package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.*;


public class AgendamentoDAO {
	public static void cadastrar(Agendamento a) {
		String sqlInsert = "INSERT INTO agendamento(id_agendamento, id_usuario, dt_agendada, tx_comentarios, nome, idColetador, descricao, horario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, a.getIdAgendamento());
			stm.setInt(2, a.getIdUsuarios());
			stm.setString(3, a.getData());
			stm.setString(4, a.getTexto());
			stm.setString(5, a.getNome());
			stm.setInt(6, a.getIdColetador());
			stm.setString(7, a.getDesc());
			stm.setString(8, a.getHorario());
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
					a.setHorario(resultado.getString("horario"));
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
				a.setIdUsuarios(resultado.getInt("id_usuario"));
				a.setIdColetador(resultado.getInt("idColetador"));
				a.setData(resultado.getString("dt_agendada"));
				a.setNome(resultado.getString("nome"));
				a.setDesc(resultado.getString("descricao"));
				a.setTexto(resultado.getString("tx_comentarios"));
				a.setHorario(resultado.getString("horario"));
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
				a.setHorario(resultado.getString("horario"));
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
	public static ArrayList<Agendamento> listarAgendamentosMaterial(String key) {
		
		String sqlInsert = "SELECT * FROM agendamento "
				+ " WHERE descricao like ?";
		
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setString(1, "%" + key + "%" );
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
				a.setHorario(resultado.getString("horario"));
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
	public static Agendamento consultarAgendamento(int id) {
		
		String sqlInsert = "SELECT * FROM agendamento "
				+ " WHERE id_agendamento = ? ";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setInt(1, id);
			ResultSet resultado = stm.executeQuery();
			
			Agendamento a = new Agendamento();
			if (resultado.next()) {
				a.setIdAgendamento(resultado.getInt("id_agendamento"));
				a.setIdUsuarios(resultado.getInt("id_usuario"));
				a.setIdColetador(resultado.getInt("idColetador"));
				a.setData(resultado.getString("dt_agendada"));
				a.setNome(resultado.getString("nome"));
				a.setDesc(resultado.getString("descricao"));
				a.setTexto(resultado.getString("tx_comentarios"));
				a.setHorario(resultado.getString("horario"));
			}
			return a;
			
			
		} catch (SQLException ex) {
			
			System.err.println("NÃ£o foi possÃ­vel manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
			
			return null;
		}
	}
	public static void alterar(int id, int idUsuario) {
		
		String sqlInsert = "UPDATE agendamento"
				+ "SET idColetador = ?"
				+ " WHERE id_agendamento = ? "; 
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, idUsuario);
			stm.setInt(2, id);
			
			stm.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("NÃ£o foi possÃ­vel manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
			
		}
	}
	public static void alterar2(int idUsuario, Agendamento a) {
		
		String sqlInsert = "UPDATE agendamento "
				+ "SET  descricao = ?, idColetador = ? "
				+ " WHERE id_agendamento = ? "; 
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, a.getDesc());
			stm.setInt(2, idUsuario);
			stm.setInt(3, a.getIdAgendamento());
			
			stm.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("NÃ£o foi possÃ­vel manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
			
		}
	}


}