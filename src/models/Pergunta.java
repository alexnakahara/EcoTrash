package models;

public class Pergunta {
	private int id;
	private int idUsuario;
	private String nome;
	private String titulo;
	private String text;
	boolean isResp;
	public Pergunta(){
		
	}
	public Pergunta(int id, int idUsuario, String nome, String titulo, String text, boolean isResp) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.titulo = titulo;
		this.text = text;
		this.isResp = isResp;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getId() { 
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isResp() {
		return isResp;
	}
	public void setResp(boolean isResp) {
		this.isResp = isResp;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
