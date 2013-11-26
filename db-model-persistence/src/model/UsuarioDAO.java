package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

	// (inicializador) construtor estático (roda uma vez só)
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {			
			System.err.println("Driver do Banco não encontrado " + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public void insert(Usuario usuario) {
		
		Connection con = null;
		
		try {
			
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/redesocial",
							"root", "root");
			
			String sql = "INSERT INTO usuarios (email, senha) "
					   + "VALUE (?, ?);";  // ? == placeholder
			
			PreparedStatement cmd = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						
			cmd.setString(1, usuario.getEmail()); // setar o placeholder
			cmd.setString(2, usuario.getSenha()); 
			
			cmd.executeUpdate();
			
			ResultSet key = cmd.getGeneratedKeys(); // retorna o ID gerado
			
			if (key.next()) usuario.setId(key.getInt(1));					
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
			
		} finally {
			
			if (con != null) { // fecha se ela foi aberta
				try {
					
					if ( ! con.isClosed()) con.close(); // fecha se não está fechada
					
				} catch (Exception e) {
					
					throw new RuntimeException(e);
					
				}				
			}						
		}
		
	}

	public void update(Usuario usuario) {
		Connection con = null;
		
		try {
			
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/redesocial",
							"root", "root");
			
			String sql = "UPDATE usuarios SET email = ?, senha = ? "
					   + "WHERE id_usuario = ?";
			
			PreparedStatement cmd = con.prepareStatement(sql);
						
			cmd.setString(1, usuario.getEmail()); // setar o placeholder
			cmd.setString(2, usuario.getSenha()); 
			cmd.setInt(3, usuario.getId());
			
			cmd.executeUpdate();
							
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
			
		} finally {
			
			if (con != null) { // fecha se ela foi aberta
				try {
					
					if ( ! con.isClosed()) con.close(); // fecha se não está fechada
					
				} catch (Exception e) {
					
					throw new RuntimeException(e);
					
				}				
			}						
		}
		
	}

	public void updatePerfil(Usuario usuario) {
		Connection con = null;
		
		try {
			
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/redesocial",
							"root", "root");
			
			String sql = "UPDATE usuarios SET nome = ?, sobrenome = ?, "
					   + "data_nascimento = ?, genero = ? "
					   + "WHERE id_usuario = ?";
			
			PreparedStatement cmd = con.prepareStatement(sql);
						
			cmd.setString(1, usuario.getPerfil().getNome()); // setar o placeholder
			cmd.setString(2, usuario.getPerfil().getSobrenome());
			
			if (usuario.getPerfil().getDataNascimento() == null) {
				cmd.setNull(3, Types.DATE);
			} else {
				cmd.setDate(3, 
						new java.sql.Date(usuario.getPerfil().getDataNascimento().getTime()));
			}
			
			if (usuario.getPerfil().getGenero() == null) {
				cmd.setNull(4, Types.INTEGER);
			} else {
				cmd.setInt(4, usuario.getPerfil().getGenero().ordinal());
			}
					
			cmd.setInt(5, usuario.getId());
			
			cmd.executeUpdate();
							
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
			
		} finally {
			
			if (con != null) { // fecha se ela foi aberta
				try {
					
					if ( ! con.isClosed()) con.close(); // fecha se não está fechada
					
				} catch (Exception e) {
					
					throw new RuntimeException(e);
					
				}				
			}						
		}
		
	}

	
	public Usuario select(int id) {
		Connection con = null;
		
		try {
			
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/redesocial",
							"root", "root");
			
			String sql = "SELECT email, senha FROM usuarios "
					    +"WHERE id_usuario = ?";
			
			PreparedStatement cmd = con.prepareStatement(sql);
			
			cmd.setInt(1, id);
			
			ResultSet result = cmd.executeQuery();
			
			if (result.next()) {
				
				Usuario u = new Usuario();
				
				u.setId(id);
				u.setEmail(result.getString("email"));
				u.setSenha(result.getString("senha"));
				
				return u;
				
			} else {
				
				return null;
				
			}
								
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
			
		} finally {
			
			if (con != null) { // fecha se ela foi aberta
				try {
					
					if ( ! con.isClosed()) con.close(); // fecha se não está fechada
					
				} catch (Exception e) {
					
					throw new RuntimeException(e);
					
				}				
			}						
		}
	}

	public Perfil selectPerfil(Usuario usuario) {
		Connection con = null;
		
		try {
			
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/redesocial",
							"root", "root");
			
			String sql = "SELECT nome, sobrenome, data_nascimento, genero "
					   + "FROM usuarios WHERE id_usuario = ?";
			
			PreparedStatement cmd = con.prepareStatement(sql);
			
			cmd.setInt(1, usuario.getId());
			
			ResultSet r = cmd.executeQuery();
			
			if (r.next()) {
				
				Perfil p = new Perfil();
				
				p.setNome(r.getString("nome"));
				p.setSobrenome(r.getString("sobrenome"));				
				p.setDataNascimento(r.getDate("data_nascimento"));
				p.setGenero(Genero.values()[r.getInt("genero")]);
				
				return p;
				
			} else {
				
				return null;
				
			}
								
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
			
		} finally {
			
			if (con != null) { // fecha se ela foi aberta
				try {
					
					if ( ! con.isClosed()) con.close(); // fecha se não está fechada
					
				} catch (Exception e) {
					
					throw new RuntimeException(e);
					
				}				
			}						
		}
	}

	public List<Usuario> select() {
		Connection con = null;
		
		try {
			
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/redesocial",
							"root", "root");
			
			String sql = "SELECT id_usuario, email, senha FROM usuarios";
			
			PreparedStatement cmd = con.prepareStatement(sql);
	
			
			ResultSet result = cmd.executeQuery();
			
			List<Usuario> usuarios = new ArrayList<Usuario>();
			
			while (result.next()) {
				
				Usuario u = new Usuario();
				
				u.setId(result.getInt("id_usuario"));
				u.setEmail(result.getString("email"));
				u.setSenha(result.getString("senha"));
				
				usuarios.add(u);
				
			} 
			
			return usuarios;
								
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
			
		} finally {
			
			if (con != null) { // fecha se ela foi aberta
				try {
					
					if ( ! con.isClosed()) con.close(); // fecha se não está fechada
					
				} catch (Exception e) {
					
					throw new RuntimeException(e);
					
				}				
			}						
		}
	}

}
