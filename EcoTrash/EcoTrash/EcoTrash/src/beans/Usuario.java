package beans;

import java.sql.Date;

public class Usuario {
	//Variables declaration
	private int idUsuario;
	private String cnpj_cpf;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String nacimento;
	private String endereco;
	private String endNumero;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private String tipoUsuario;
	private int idServico;
	private boolean isPago;
	
	// Constructors
	public Usuario(String email, String senha){
		this.email = email;
		this.senha = senha;
	}
	public Usuario(int idUsuario, String cnpj_cpf, String nome, String email, String senha, String telefone,
			String nacimento, String endereco, String endNumero, String bairro, String cidade, String uf, String cep, String tipoUsuario, int idServico, boolean isPago) {
		super();
		this.idUsuario = idUsuario;
		this.cnpj_cpf = cnpj_cpf;;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.nacimento = nacimento;
		this.endereco = endereco;
		this.endNumero = endNumero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.tipoUsuario = tipoUsuario;
		this.idServico = idServico;
		this.isPago = isPago;
	}
	public int getIdServico() {
		return idServico;
	}
	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}
	public boolean isPago() {
		return isPago;
	}
	public void setPago(boolean isPago) {
		this.isPago = isPago;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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
	public String getCnpj_cpf() {
		return cnpj_cpf;
	}
	public void setCnpj_cpf(String cnpj_cpf) {
		this.cnpj_cpf = cnpj_cpf;
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
	public String getNacimento() {
		return nacimento;
	}
	public void setNacimento(String nacimento) {
		this.nacimento = nacimento;
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
	
	

	
	
}
