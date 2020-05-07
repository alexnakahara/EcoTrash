package models;

import java.sql.Timestamp;

public class Agendamento {
	private int idAgendamento;
	private int idCliente;
	private int idColaborador;
	private Timestamp dtAgendada;
	private String titulo;
	private String descricao;
	
	public Agendamento() {}
	//Não coloca o colobarador quando cria
	public Agendamento(int idCliente, Timestamp dtAgendada, String descricao, String tx_titulo) {
		this.idCliente = idCliente;
		this.dtAgendada = dtAgendada;
		this.descricao = descricao;
		this.titulo = tx_titulo;
	}
	
	public int getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(int idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
	}

	public Timestamp getDtAgendada() {
		return dtAgendada;
	}

	public void setDtAgendada(Timestamp dtAgendada) {
		this.dtAgendada = dtAgendada;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	


}
