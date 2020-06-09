package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Agendamento;

import java.sql.ResultSet;

public class AgendamentoDAO {

	private Connection conexao;

	public AgendamentoDAO() {
		this.conexao = ConnectionFactory.obtemConexao();
	}

	public boolean cadastrar(Agendamento agendamento) {

		String inserir = "INSERT INTO agendamento(id_cliente, dt_agendada, tx_titulo, tx_descricao)	VALUES(?, ?, ?, ?)";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setInt(1, agendamento.getIdCliente());
			pst.setTimestamp(2, new java.sql.Timestamp(agendamento.getDtAgendada().getTime()));
			pst.setString(3, agendamento.getTitulo());
			pst.setString(4, agendamento.getDescricao());
			pst.execute();
			return true;

		} catch (SQLException ex) {

			System.err.println("N�o foi poss�vel cadastrar o agendamento");
			ex.printStackTrace();
			return false;

		}
	}

	public Agendamento getAgendamento(int id_agendamento) {

		String inserir = "SELECT * FROM agendamento WHERE id_agendamento = ? ";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setInt(1, id_agendamento);
			ResultSet resultado = pst.executeQuery();

			Agendamento a = new Agendamento();
			if (resultado.next()) {
				a.setIdAgendamento(resultado.getInt("id_agendamento"));
				a.setTitulo(resultado.getString("tx_titulo"));
				a.setDescricao(resultado.getString("tx_descricao"));
				a.setDtAgendada(resultado.getTimestamp("dt_agendada"));
				a.setIdColaborador(resultado.getInt("id_colaborador"));
				a.setIdCliente(resultado.getInt("id_cliente"));
			}
			return a;

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela Professor.");
			ex.printStackTrace();

			return null;
		}
	}

	public ArrayList<Agendamento> listAgendamentosByCliente(int id_cliente) {

		String inserir = "SELECT * FROM agendamento WHERE id_cliente =?";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
			pst.setInt(1, id_cliente);
			ResultSet resultado = pst.executeQuery();

			ArrayList<Agendamento> lista = new ArrayList<>();
			while (resultado.next()) {
				Agendamento a = new Agendamento();
				a.setIdAgendamento(resultado.getInt("id_agendamento"));
				a.setTitulo(resultado.getString("tx_titulo"));
				a.setDescricao(resultado.getString("tx_descricao"));
				a.setDtAgendada(resultado.getTimestamp("dt_agendada"));
				a.setIdColaborador(resultado.getInt("id_colaborador"));
				a.setIdCliente(resultado.getInt("id_cliente"));
				lista.add(a);
			}
			return lista;

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela Agendamento.");
			ex.printStackTrace();

			return null;
		}
	}
	
	// Lista agendamentos que o colaborador confirmou e os q estão disponiveis
	public ArrayList<Agendamento> listAgendamentosDisponiveis(int id_colaborado) { 
		String query = "SELECT * FROM agendamento WHERE id_colaborador = ?\r\n"
						+ "UNION\r\n"
						+ "SELECT * FROM agendamento WHERE dt_agendada >= UTC_TIMESTAMP() AND id_colaborador IS NULL;";

		try (PreparedStatement pst = conexao.prepareStatement(query)) {

			pst.setInt(1, id_colaborado);
			ResultSet resultado = pst.executeQuery();

			ArrayList<Agendamento> lista = new ArrayList<>();
			while (resultado.next()) {
				Agendamento a = new Agendamento();
				a.setIdAgendamento(resultado.getInt("id_agendamento"));
				a.setTitulo(resultado.getString("tx_titulo"));
				a.setDescricao(resultado.getString("tx_descricao"));
				a.setDtAgendada(resultado.getTimestamp("dt_agendada"));
				a.setIdColaborador(resultado.getInt("id_colaborador"));
				a.setIdCliente(resultado.getInt("id_cliente"));
				lista.add(a);
			}
			return lista;

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela Agendamento.");
			ex.printStackTrace();

			return null;
		}
	}

	public static void confirmarRetirada(int id_colaborador, int id_agendamento) {

		String sqlInsert = "UPDATE agendamento SET id_colaborador = ? WHERE id_agendamento = ? ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, id_colaborador);
			stm.setInt(2, id_agendamento);
			stm.execute();

		} catch (SQLException ex) {

			ex.printStackTrace();

		}
	}
	
	public static void deletarAgendamento(int id_agendamento) {

		String sqlInsert = "DELETE FROM agendamento WHERE id_agendamento= ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, id_agendamento);
			stm.execute();

		} catch (SQLException ex) {

			ex.printStackTrace();

		}
	}
	
}
