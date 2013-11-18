package tr.main;

import tr.apresentacao.ListaProdutoFrame;
import tr.web.WebServer;

public class Main {

	public static void main(String[] args) {
		
		ListaProdutoFrame frame = new ListaProdutoFrame();
		frame.visible();
		
		WebServer ws = new WebServer();
		ws.start();

	}

}
