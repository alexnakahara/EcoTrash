package beans;

public class Pergunta {
	private int id;
	private String nome;
	private String titulo;
	private String text;
	public Pergunta(){
		
	}
	public Pergunta(int id, String nome, String titulo, String text) {
		super();
		this.id = id;
		this.nome = nome;
		this.titulo = titulo;
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
