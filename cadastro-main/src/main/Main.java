package main;

import gui.Janela;
import web.Server;
import domain.Contato;

public class Main {

	public static void main(String[] args) {
		
		Contato c = new Contato();
		
		Janela gui = new Janela(c);
		gui.visible();
		
		Server web = new Server(c); 
		web.start();
		
	}

}
