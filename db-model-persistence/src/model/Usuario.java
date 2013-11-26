package model;

import java.util.List;

public class Usuario {

	private Integer id;
	private String email;
	private String senha;
	
	private Perfil perfil;
	
	
	public Perfil getPerfil() {
		// lazy initialization, inicialização tardia/atrasada/preguiçosa
		
		if (id == null && perfil == null) perfil = new Perfil();
		
		if (id != null && perfil == null) {
			perfil = new UsuarioDAO().selectPerfil(this);			
			if (perfil == null) perfil = new Perfil();
		}
		
		return perfil;
	}


	public Integer getId() {
		return id;
	}

	// Fluent API (API fluente)
	public Usuario setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Usuario setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getSenha() {
		return senha;
	}

	public Usuario setSenha(String senha) {
		this.senha = senha;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", senha=" + senha
				+ "]";
	}

	public void save() {
		UsuarioDAO dao = new UsuarioDAO();
		
		if (this.id == null) {
			dao.insert(this);
		} else {
			dao.update(this);
		}
		
		if (perfil != null) {
			dao.updatePerfil(this);
		}
		
	}


	public static Usuario load(int id) {
		UsuarioDAO dao = new UsuarioDAO();
		
		return dao.select(id);
	}


	public static List<Usuario> all() {
		UsuarioDAO dao = new UsuarioDAO();
		
		return dao.select();
	}
	

}
