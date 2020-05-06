package models;

import java.sql.Date;

public class Colaborador extends Usuario {
	private int idColaborador;
	private int idUsuarioColaborador;
	private Date dateCadastro;
	
	public Colaborador(int idUsuario, String cnpj, String cpf, String nome, String email, String senha, String telefone,
			Date nacimento, String endereço, String endNumero, String bairro, String cidade, String uf, String cep,
			int idColaborador, int idUsuarioColaborador, Date dateCadastro) {
		super(idUsuario, cnpj, cpf, nome, email, senha, telefone, nacimento, endereço, endNumero, bairro, cidade, uf,
				cep);
		this.idColaborador = idColaborador;
		idUsuario = idUsuarioColaborador;
		this.dateCadastro = dateCadastro;
	}
	public Colaborador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Colaborador(int idUsuario, String cnpj, String cpf, String nome, String email, String senha, String telefone,
			Date nacimento, String endereço, String endNumero, String bairro, String cidade, String uf, String cep) {
		super(idUsuario, cnpj, cpf, nome, email, senha, telefone, nacimento, endereço, endNumero, bairro, cidade, uf, cep);
		// TODO Auto-generated constructor stub
	}
	public int getIdColaborador() {
		return idColaborador;
	}
	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
	}
	public int getIdUsuarioColaborador() {
		return idUsuarioColaborador;
	}
	public void setIdUsuarioColaborador(int idUsuario2) {
		this.idUsuarioColaborador = idUsuario2;
	}
	public Date getDateCadastro() {
		return dateCadastro;
	}
	public void setDateCadastro(Date dateCadastro) {
		this.dateCadastro = dateCadastro;
	}
	
	
	
}
