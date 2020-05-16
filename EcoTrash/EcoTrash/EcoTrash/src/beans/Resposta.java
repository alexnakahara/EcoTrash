package beans;

public class Resposta{
	private int id;
	private String nome;
	private String text;
	private int idPergunta;
	
	public Resposta(){
		
	}

	public Resposta(int id, String nome, String text, int idPergunta) {
		super();
		this.id = id;
		this.nome = nome;
		this.text = text;
		this.idPergunta = idPergunta;
	}
	public Resposta(String nome, String text, int idPergunta) {
		super();
		this.nome = nome;
		this.text = text;
		this.idPergunta = idPergunta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getIdPergunta() {
		return idPergunta;
	}

	public void setIdPergunta(int idPergunta) {
		this.idPergunta = idPergunta;
	}
	
		
}