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
	
	public ArrayList<Agendamento> listAgendamentosByColaborador(int id_colaborador) {

		String inserir = "SELECT * FROM agendamento WHERE id_colaborador =?";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
			pst.setInt(1, id_colaborador);
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
	
	public ArrayList<Agendamento> listAgendamentosDisponiveis() {

		String inserir = "SELECT * FROM agendamento WHERE id_colaborador IS NULL  AND dt_agendada >= UTC_TIMESTAMP()";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
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
}
