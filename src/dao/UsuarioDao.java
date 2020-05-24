package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Usuario;

public class UsuarioDao {
	public static void cadastrarUsuario(Usuario colaborador) {
		String sqlInsert = "INSERT INTO usuarios(id_Usuario, tx_cnpj_cpf, tx_nome, tx_email, tx_senha, tx_telefone, dt_nascimento, tx_endereco, tx_endNumero, tx_bairro, tx_cidade, tx_uf, tx_cep, tipoUsuario, isPago, idServico) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, colaborador.getIdUsuario());
			stm.setString(2, colaborador.getCnpj_cpf(sqlInsert));
			stm.setString(3, colaborador.getNome());
			stm.setString(4, colaborador.getEmail());
			stm.setString(5, colaborador.getSenha());
			stm.setString(6, colaborador.getTelefone());
			stm.setDate(7, (Date) colaborador.getNascimento());
			stm.setString(8, colaborador.getEndereco());
			stm.setString(9, colaborador.getEndNumero());
			stm.setString(10, colaborador.getBairro());
			stm.setString(11, colaborador.getCidade());
			stm.setString(12, colaborador.getUf());
			stm.setString(13, colaborador.getCep());
			stm.setString(14, colaborador.getTipoUsuario());
			stm.setBoolean(15, colaborador.isPago());
			stm.setInt(16, colaborador.getIdServico());
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
	}
	public static Usuario consultarUsuario(int id) {
		
		String sqlInsert = "SELECT * FROM usuarios "
				+ " WHERE id_usuario = ? ";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setInt(1, id);
			ResultSet resultado = stm.executeQuery();
			
			Usuario u = new Usuario();
			if (resultado.next()) {
				u.setNome(resultado.getString("tx_nome"));
				u.setCnpj_cpf(resultado.getString("tx_cnpj_cpf"));
				u.setEmail(resultado.getString("tx_email"));
				u.setSenha(resultado.getString("tx_senha"));
				u.setEmail(resultado.getString("tx_telefone"));
				u.setNascimento(resultado.getDate("dt_nascimento"));
				u.setEndereco(resultado.getString("tx_endereco"));
				u.setEndNumero(resultado.getString("tx_endNumero"));
				u.setBairro(resultado.getString("tx_bairro"));
				u.setCidade(resultado.getString("tx_cidade"));
				u.setUf(resultado.getString("tx_uf"));
				u.setCep(resultado.getString("tx_cep"));
				u.setTipoPerfil(resultado.getInt("tipoPerfil"));
				u.setIdServico(resultado.getInt("idServico"));
				u.setPago(resultado.getBoolean("isPago"));
				u.setIdUsuario(id);
			}
			return u;
			
			
		} catch (SQLException ex) {
			
			System.err.println("NÃ£o foi possÃ­vel manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
			
			return null;
		}
	}
	public static Usuario autenticar(Usuario u){
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet resultado = null;
            try {
                con = ConnectionFactory.obtemConexao();
                ps = con.prepareStatement("SELECT * from usuarios WHERE tx_email = ? AND tx_senha = ?");
                ps.setString(1, u.getEmail());
                ps.setString(2, u.getSenha());
                resultado = ps.executeQuery();                
                
                //u = null;
                while (resultado.next()) {
                    u = new Usuario(); 
                    u.setIdUsuario(resultado.getInt("id_usuario"));
    				u.setNome(resultado.getString("tx_nome"));
    				u.setCnpj_cpf(resultado.getString("tx_cnpj_cpf"));
    				u.setEmail(resultado.getString("tx_email"));
    				u.setSenha(resultado.getString("tx_senha"));
    				u.setEmail(resultado.getString("tx_telefone"));
    				u.setNascimento(resultado.getDate("dt_nascimento"));
    				u.setEndereco(resultado.getString("tx_endereco"));
    				u.setEndNumero(resultado.getString("tx_endNumero"));
    				u.setBairro(resultado.getString("tx_bairro"));
    				u.setCidade(resultado.getString("tx_cidade"));
    				u.setUf(resultado.getString("tx_uf"));
    				u.setCep(resultado.getString("tx_cep"));
    				u.setTipoPerfil(resultado.getInt("tipoUsuario"));
    				u.setIdServico(resultado.getInt("idServico"));
    				u.setPago(resultado.getBoolean("isPago"));
    				
                }
                		return u;
            }catch (SQLException ex) {
    			System.err.println("NÃ£o foi possÃ­vel manipular "
    					+ "a tabela Professor.");
    			ex.printStackTrace();
            } catch(Exception ex){
    			System.err.println("NÃ£o foi possÃ­vel manipular "
    					+ "a tabela Professor.");
    			ex.printStackTrace();
            }
        return  null;
   }
}