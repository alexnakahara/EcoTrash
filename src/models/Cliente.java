package models;

import java.sql.Date;

public class Cliente extends Usuario {
	private int idCliente;
	private int idUsuarioCliente;
	private int idServico;
	public Cliente() {
		super();
	}
	public Cliente(int idCliente, int idUsuarioCliente, int idServico) {
		this.idCliente = idCliente;
		this.idUsuarioCliente = idUsuarioCliente;
		this.idServico = idServico;
	}
	public Cliente(int idUsuario, String cnpj, String cpf, String nome, String email, String senha, String telefone,
			Date nacimento, String endereco, String endNumero, String bairro, String cidade, String uf, String cep, int tipoPerfil) {
		super(idUsuario, cnpj, cpf, nome, email, senha, telefone, nacimento, endereco, endNumero, bairro, cidade, uf, cep, tipoPerfil);
	}
	public Cliente(int idUsuario, String cnpj, String cpf, String nome, String email, String senha, String telefone,
			Date nacimento, String endereco, String endNumero, String bairro, String cidade, String uf, String cep,
			int idCliente, int idUsuarioCliente, int idServico, int tipoPerfil) {
		super(idUsuario, cnpj, cpf, nome, email, senha, telefone, nacimento, endereco, endNumero, bairro, cidade, uf,
				cep, tipoPerfil );
		this.idCliente = idCliente;
		this.idUsuarioCliente = idUsuarioCliente;
		this.idServico = idServico;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdUsuarioCliente() {
		return idUsuarioCliente;
	}
	public void setIdUsuarioCliente(int idUsuarioCliente) {
		this.idUsuarioCliente = idUsuarioCliente;
	}
	public int getIdServico() {
		return idServico;
	}
	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}
	
}
