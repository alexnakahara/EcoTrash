package models;

import java.util.Date;

public class Usuario {
	private int idUsuario;
	private String documento;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private Date nascimento;
	private String endereco;
	private String endNumero;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private int tipoPerfil;
	private String Cnpj_cpf;
	
	public Usuario(int tipoPerfil, String documento, String nome, String email, String senha, String telefone,
			Date nascimento, String endereco, String endNumero, String bairro, String cidade, String uf, String cep) {
		this.tipoPerfil = tipoPerfil;
		this.documento = documento;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.endereco= endereco;
		this.endNumero = endNumero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}
	
	public Usuario(){}

	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
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
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nacimento) {
		this.nascimento = nacimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
	public int getTipoPerfil() {
		return tipoPerfil;
	}
	public void setTipoPerfil(int tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	public String getCnpj_cpf(String Cnpj_cpf) {
		return Cnpj_cpf;
	}
	
	public void setCnpj_cpf(String Cnpj_cpf) {
		this.Cnpj_cpf = Cnpj_cpf;
	}

	public void setPago(boolean boolean1) {
		
	}

	public void setIdServico(int int1) {
		
	}

	public boolean isPago() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getTipoUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getIdServico() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	
	
}
