package dao;
import java.sql.Connection;
import models.Pagamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PagamentoDAO {
	private Connection conexao;
	private Pagamento pagamento = new Pagamento();
	
	public PagamentoDAO(){
		this.conexao = ConnectionFactory.obtemConexao();
	}
	
	public static void pagar(Pagamento pagamento) {
		
		String sqlInsert = "INSERT INTO pagamento "
				+ " (CPF, Email, NomeCartao, NumeroCartao, cvv, plano) "
				+ " VALUES (?, ?, ?, ?, ?, ?) ";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			

			stm.setString(1, pagamento.getCpf());
			stm.setString(2, pagamento.getEmail());
			stm.setString(3, pagamento.getNomeNoCartao());
			stm.setInt(4, pagamento.getNumeroDoCartao());
			stm.setInt(5, pagamento.getNumeroDeSegurança());
			stm.setInt(6, pagamento.getPlano());

			
			stm.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Pagamento.");
			ex.printStackTrace();
			
		}
			
	}
	
}