package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) throws Exception {
		
		// #1 Carregar o Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		// #2 Conectar
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost/cobaia", "root", "root");
		
		// #3 Criar um comando
		Statement cmd = con.createStatement();
		
		// #4 Executar o comando
		cmd.execute("INSERT INTO contatos (nome, sobrenome, telefone, email) "
			      + "VALUES ('Bruno', 'Lima', '32345566', 'bruno.lima@furg.br');");
		
		// #5 Fechar tudo
		cmd.close();
		con.close();
		
		System.out.println("Inserido");
		

	}
}
