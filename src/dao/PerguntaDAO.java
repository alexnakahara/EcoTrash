package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Pergunta;



public class PerguntaDAO{
	public static void criar(Pergunta pergunta) {	
		String sqlInsert = "INSERT INTO perguntaHome"
				+ " (idUsuario, isRep, nome, titulo, texto) "
				+ " VALUES (?, ?, ?, ?, ?) ";	
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, pergunta.getIdUsuario());
			stm.setBoolean(2, pergunta.isResp());
			stm.setString(3, pergunta.getNome());
			stm.setString(4, pergunta.getTitulo());
			stm.setString(5, pergunta.getText());
	
			stm.execute();
			 
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela noticia.");
			ex.printStackTrace();
			
		}
			
	}
	
	public void excluir(int id) {
		
		String sqlInsert = "DELETE FROM pergunta "
				+ " WHERE id = ? ";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setInt(1, id);
			
			stm.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("NÃ£o foi possÃ­vel manipular "
					+ "a tabela noticia.");
			ex.printStackTrace();
		}
	}
	public static Pergunta consultar(int id) {
		
		String sqlInsert = "SELECT * FROM pergunta "
				+ " WHERE id = ? ";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setInt(1, id);
			ResultSet resultado = stm.executeQuery();
			
			Pergunta n = new Pergunta();
			if (resultado.next()) {
				n.setTitulo(resultado.getString("titulo"));
				n.setNome(resultado.getString("nome"));
				n.setText(resultado.getString("texto"));
				n.setId(id);
			}
			return n;
			
			
		} catch (SQLException ex) {
			
			System.err.println("NÃ£o foi possÃ­vel manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
			
			return null;
		}
	}
	public void alterar(Pergunta pergunta) {
		
		String sqlInsert = "UPDATE pergunta "
				+ "SET nome = ?, titulo = ?, texto = ? "
				+ " WHERE id = ? "; 
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, pergunta.getNome());
			stm.setString(2, pergunta.getTitulo());
			stm.setString(3, pergunta.getText());
			stm.setInt(4, pergunta.getId());
			
			stm.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("NÃ£o foi possÃ­vel manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
			
		}
	}
	public ArrayList<Pergunta> listarPerguntas() {
		
		String sqlInsert = "SELECT * FROM pergunta";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			ResultSet resultado = stm.executeQuery();
			
			ArrayList<Pergunta> lista = new ArrayList<>();
			while (resultado.next()) {
				Pergunta n = new Pergunta();
				n.setId(resultado.getInt("id"));
				n.setNome(resultado.getString("nome"));
				n.setTitulo(resultado.getString("titulo"));
				n.setText(resultado.getString("texto"));
				lista.add(n);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("NÃ£o foi possÃ­vel manipular "
					+ "a tabela Noticia.");
			ex.printStackTrace();
			
			return null;
		}
	}
	public static ArrayList<Pergunta> listarPerguntas(int id) {
		
		String sqlInsert = "SELECT * FROM perguntaHome WHERE idUsuario = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, id);
			stm.execute();
			ResultSet resultado = stm.executeQuery();
			
			ArrayList<Pergunta> lista = new ArrayList<>();
			while (resultado.next()) {
				Pergunta n = new Pergunta();
				n.setId(resultado.getInt("id"));
				n.setResp(resultado.getBoolean("isRep"));
				n.setNome(resultado.getString("nome"));
				n.setTitulo(resultado.getString("titulo"));
				n.setText(resultado.getString("texto"));
				lista.add(n);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("NÃ£o foi possÃ­vel manipular "
					+ "a tabela Noticia.");
			ex.printStackTrace();
			
			return null;
		}
	}
}
