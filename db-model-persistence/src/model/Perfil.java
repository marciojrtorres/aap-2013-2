package model;

import java.util.Date;

public class Perfil {

	private String nome;
	private String sobrenome;
	private Date dataNascimento;
	private Genero genero;

	public String getNome() {
		return nome;
	}

	public Perfil setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public Perfil setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
		return this;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public Perfil setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}

	public Genero getGenero() {
		return genero;
	}

	public Perfil setGenero(Genero genero) {
		this.genero = genero;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Perfil [nome=" + nome + ", sobrenome=" + sobrenome
				+ ", dataNascimento=" + dataNascimento + ", genero=" + genero
				+ "]";
	}

}
