package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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

}
