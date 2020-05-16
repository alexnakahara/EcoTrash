package beans;

public class Agendamento {
	private int idAgendamento;
	private int idUsuarios;
	private int idColetador;
	private String data;
	private String nome;
	private String desc;
	private String texto;
	public Agendamento(int idAgendamento, int idUsuarios, int idColetador, String data, String nome, String desc,
			String texto) {
		super();
		this.idAgendamento = idAgendamento;
		this.idUsuarios = idUsuarios;
		this.idColetador = idColetador;
		this.data = data;
		this.nome = nome;
		this.desc = desc;
		this.texto = texto;
	}

	public int getIdColetador() {
		return idColetador;
	}
	public void setIdColetador(int idColetador) {
		this.idColetador = idColetador;
	}
	public Agendamento(int idAgendamento, int idUsuarios, int idColetador, String data, String texto) {
		super();
		this.idAgendamento = idAgendamento;
		this.idUsuarios = idUsuarios;
		this.idColetador = idColetador;
		this.data = data;
		this.texto = texto;
	}

	public Agendamento(int idAgendamento, int idUsuarios, String data, String texto) {
		super();
		this.idAgendamento = idAgendamento;
		this.idUsuarios = idUsuarios;
		this.data = data;
		this.texto = texto;
	}
	public Agendamento() {
		super();
	}
	@Override
	public String toString() {
		return "Agendamento [idAgendamento=" + idAgendamento + ", idUsuarios=" + idUsuarios + ", data=" + data
				+ ", texto=" + texto + "]";
	}
	public int getIdAgendamento() {
		return idAgendamento;
	}
	public void setIdAgendamento(int idAgendamento) {
		this.idAgendamento = idAgendamento;
	}
	public int getIdUsuarios() {
		return idUsuarios;
	}
	public void setIdUsuarios(int idUsuarios) {
		this.idUsuarios = idUsuarios;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
