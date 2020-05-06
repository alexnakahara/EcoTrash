package models;

import java.sql.Date;

public class Usuario {
	//Variables declaration
	private int idUsuario;
	private String cnpj;
	private String cpf;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private Date nacimento;
	private String endere�o;
	private String endNumero;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	
	// Constructors
	public Usuario(int idUsuario, String cnpj, String cpf, String nome, String email, String senha, String telefone,
			Date nacimento, String endere�o, String endNumero, String bairro, String cidade, String uf, String cep) {
		super();
		this.idUsuario = idUsuario;
		this.cnpj = cnpj;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.nacimento = nacimento;
		this.endere�o = endere�o;
		this.endNumero = endNumero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}
	public Usuario(){
		
	}
	
	//Geter's and Seter's
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getNacimento() {
		return nacimento;
	}
	public void setNacimento(Date nacimento) {
		this.nacimento = nacimento;
	}
	public String getEndere�o() {
		return endere�o;
	}
	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}
	public String getEndNumero() {
		return endNumero;
	}
	public void setEndNumero(String endNumero) {
		this.endNumero = endNumero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	

	
	
}
