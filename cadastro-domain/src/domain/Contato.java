package domain;

import toolkit.List;

public class Contato {

	private String nome;
	private String telefone;
	
	private List<ContatoChangeListener> ouvintes =
			new List<ContatoChangeListener>();
	
	public void addContatoChangeListener(ContatoChangeListener l) {
		ouvintes.append(l);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		for (int i = 0; i < ouvintes.length(); i++) {
			ContatoChangeListener ouvinte = ouvintes.get(i);
			ouvinte.contatoChange(new ContatoChangeEvent(nome, telefone));
		}
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		for (int i = 0; i < ouvintes.length(); i++) {
			ContatoChangeListener ouvinte = ouvintes.get(i);
			ouvinte.contatoChange(new ContatoChangeEvent(nome, telefone));
		}
		this.telefone = telefone;
	}
}
