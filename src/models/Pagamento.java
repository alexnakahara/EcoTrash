package models;

public class Pagamento implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private int numeroDoCartao, numeroDeSeguranca, plano;

	private String cpf, email, nomeNoCartao;

	public Pagamento() {
	}

	public Pagamento(String email, String cpf, String nomeNoCartao, int numeroDoCartao, int numeroDeSeguranca, int plano) {
		this.email = email;
		this.cpf = cpf;
		this.nomeNoCartao = nomeNoCartao;
		this.numeroDoCartao = numeroDoCartao;
		this.numeroDeSeguranca = numeroDeSeguranca;
		this.plano = plano;
	}

	public int getPlano() {
		return plano;
	}

	public void setPlano(int plano) {
		this.plano = plano;
	}

	public int getNumeroDoCartao() {
		return numeroDoCartao;
	}

	public void setNumeroDoCartao(int numeroDoCartao) {
		this.numeroDoCartao = numeroDoCartao;
	}

	public int getNumeroDeSeguranca() {
		return numeroDeSeguranca;
	}

	public void setNumeroDeSeguranca(int numeroDeSeguranca) {
		this.numeroDeSeguranca = numeroDeSeguranca;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeNoCartao() {
		return nomeNoCartao;
	}

	public void setNomeNoCartao(String nomeNoCartao) {
		this.nomeNoCartao = nomeNoCartao;
	}

}
