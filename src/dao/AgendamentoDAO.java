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
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Agendamento agendamento) {

		String inserir = "INSERT INTO agendamento(id_cliente, dt_agendada, tx_titulo, tx_descricao)"
						+ "	VALUES(?, ?, ?, ?)";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setInt(1, agendamento.getId_cliente());
			pst.setDate(2,agendamento.getDt_agendada());
			pst.setString(3, agendamento.getTx_titulo());
			pst.setString(4, agendamento.getTx_descricao());
			pst.execute();

		} catch (SQLException ex) {

			System.err.println("N�o foi poss�vel cadastrar o agendamento");
			ex.printStackTrace();

		}
	}

	public Agendamento getAgendamento(int id_agendamento) {

		String inserir = "SELECT * FROM agendamento " + " WHERE id_agendamento = ? ";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setInt(1, id_agendamento);
			ResultSet resultado = pst.executeQuery();

			Agendamento a = new Agendamento();
			if (resultado.next()) {
				a.setDt_agendada(resultado.getDate("dt_agendada"));
				a.setTx_titulo(resultado.getString("tx_titulo"));
				a.set_Tx_descricao(resultado.getString("tx_descricao"));
				a.setId_agendamento(id_agendamento);
				a.setId_cliente(resultado.getInt("id_cliente"));
			}
			return a;

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela Professor.");
			ex.printStackTrace();

			return null;
		}
	}

	public ArrayList<Agendamento> listAgendamentos() {

		String inserir = "SELECT * FROM agendamento";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			ResultSet resultado = pst.executeQuery();

			ArrayList<Agendamento> lista = new ArrayList<>();
			while (resultado.next()) {
				Agendamento a = new Agendamento();
				a.setDt_agendada(resultado.getDate("dt_agendada"));
				a.setTx_titulo(resultado.getString("tx_titulo"));
				a.set_Tx_descricao(resultado.getString("tx_descricao"));
				a.setId_agendamento(resultado.getInt("id_agendamento"));
				a.setId_cliente(resultado.getInt("id_cliente"));
				lista.add(a);
			}
			return lista;

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela Agendamento.");
			ex.printStackTrace();

			return null;
		}
	}
	/*
	 * public int alterar(Professor professor) {
	 * 
	 * String inserir = "UPDATE professor " + "SET cpf = ?, nome = ?, endereco = ? "
	 * + " WHERE matricula = ? ";
	 * 
	 * try ( PreparedStatement pst = conexao.prepareStatement(inserir) ) {
	 * 
	 * pst.setString(1, professor.getCpf()); pst.setString(2, professor.getNome());
	 * pst.setString(3, professor.getEndereco()); pst.setInt(4,
	 * professor.getMatricula());
	 * 
	 * pst.execute(); return 1;
	 * 
	 * } catch (SQLException ex) {
	 * 
	 * System.err.println("Não foi possível manipular " + "a tabela Professor.");
	 * ex.printStackTrace(); return 0; } } /* public int excluir(Professor
	 * professor) {
	 * 
	 * String inserir = "DELETE FROM professor " + " WHERE matricula = ? ";
	 * 
	 * try ( PreparedStatement pst = conexao.prepareStatement(inserir) ) {
	 * 
	 * pst.setInt(1, professor.getMatricula());
	 * 
	 * pst.execute(); return 1; } catch (SQLException ex) {
	 * 
	 * System.err.println("Não foi possível manipular " + "a tabela Professor.");
	 * ex.printStackTrace(); return 0; } }
	 */

}
