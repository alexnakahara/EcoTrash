package models;

import java.sql.Date;

public class Agendamento {
	private int id_agendamento;
	private int id_cliente;
	private int id_colaborador;
	private Date dt_agendada;
	private String tx_titulo;
	private String tx_descricao;
	
	public Agendamento(int id_cliente, int id_colaborador, Date dt_agendada, String tx_descricao, String tx_titulo) {
		this.id_cliente = id_cliente;
		this.id_colaborador = id_colaborador;
		this.dt_agendada = dt_agendada;
		this.tx_titulo = tx_titulo;
		this.tx_descricao = tx_descricao;
	}

	public Agendamento() {
		// TODO Auto-generated constructor stub
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_colaborador() {
		return id_colaborador;
	}

	public void setId_colaborador(int id_colaborador) {
		this.id_colaborador = id_colaborador;
	}

	public Date getDt_agendada() {
		return dt_agendada;
	}

	public void setDt_agendada(Date dt_agendada) {
		this.dt_agendada = dt_agendada;
	}

	public String getTx_descricao() {
		return tx_descricao;
	}

	public void set_Tx_descricao(String tx_descricao) {
		this.tx_descricao = tx_descricao;
	}

	public int getId_agendamento() {
		return id_agendamento;
	}

	public void setId_agendamento(int id_agendamento) {
		this.id_agendamento = id_agendamento;
	}

	public String getTx_titulo() {
		return tx_titulo;
	}

	public void setTx_titulo(String tx_titulo) {
		this.tx_titulo = tx_titulo;
	}


}
