package domain;

public class ContatoChangeEvent {

	private final String telefone;
	private final String nome;

	public ContatoChangeEvent(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getNome() {
		return nome;
	}
	
	

}
