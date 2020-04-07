package models;

//convenção para campos para ter padrão de nomenclatura com o banco 
//texto: tx_
//numero: nu_
public class Usuario {
private String tx_nome;
private String tx_email;
private String tx_dtnascimento;

public Usuario(String tx_nome, String tx_email, String tx_dtnascimento) {
	this.tx_nome = tx_nome;
	this.tx_email = tx_email;
	this.tx_dtnascimento = tx_dtnascimento;
}

public String getTx_nome() {
	return tx_nome;
}

public void setTx_nome(String tx_nome) {
	this.tx_nome = tx_nome;
}

public String getTx_email() {
	return tx_email;
}

public void setTx_email(String tx_email) {
	this.tx_email = tx_email;
}

public String getTx_dtnascimento() {
	return tx_dtnascimento;
}

public void setTx_dtnascimento(String tx_dtnascimento) {
	this.tx_dtnascimento = tx_dtnascimento;
}


}
