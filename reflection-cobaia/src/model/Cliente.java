package model;

import java.util.Date;

public class Cliente {

	@Intervalo(min=1, max=1000)
	private int id;
	
	@NaoNulo // anotação == metadado = dado sobre dados
	private String nome;
	private Date dataNascimento;
	
	@Intervalo(min=11, max=11)
	private String cpf;

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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
