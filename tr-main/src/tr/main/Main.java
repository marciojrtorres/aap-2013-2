package tr.main;

import javax.swing.JOptionPane;

import tr.apresentacao.ListaProdutoFrame;
import tr.domain.Produto;
import tr.persistencia.ProdutoDAO;
import tr.web.WebServer;

public class Main {

	public static void main(String[] args) {
		
		ListaProdutoFrame frame = new ListaProdutoFrame();
		frame.visible();
		
		WebServer ws = new WebServer();
		ws.start();

		while (true) {
			String d = JOptionPane.showInputDialog("Descrição:");
			Produto p = new Produto();
			p.setDescricao(d);
			// acessando o Singleton
			ProdutoDAO.getDAO().salva(p);
		}
	}
}
