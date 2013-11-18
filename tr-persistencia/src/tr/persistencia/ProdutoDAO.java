package tr.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.domain.Produto;

public class ProdutoDAO {

	public void salva(Produto p) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/tr", "root", "root");

			Statement cmd = con.createStatement();

			cmd.execute("INSERT INTO produtos (descricao) VALUES ('" + p .getDescricao() + "');", Statement.RETURN_GENERATED_KEYS);

			ResultSet generatedKeys = cmd.getGeneratedKeys();
			if (generatedKeys.next()) p.setId(generatedKeys.getInt(1));
			else throw new RuntimeException("Produto não foi salvo");
			
			cmd.close();
			con.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		
	}

	public List<Produto> lista() {
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/tr", "root", "root");

			Statement cmd = con.createStatement();

			ResultSet rows = cmd.executeQuery("SELECT * FROM produtos");

			while (rows.next()) {
				Produto p = new Produto();
				p.setId(rows.getInt("id_produto"));
				p.setDescricao(rows.getString("descricao"));
				produtos.add(p);
			}
			
			cmd.close();
			con.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return produtos;
	}

}