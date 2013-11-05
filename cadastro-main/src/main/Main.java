package main;

import log.Logger;
import gui.Janela;
import web.Server;
import domain.Contato;

public class Main {

	public static void main(String[] args) {
		// Observado/Sujeito: contato
		// Sujeito: aceita os observadores
		// SujeitoListener
		// Evento: alterações de nome e telefone
		// AlteracaoEvent
		// NomeChangeEvent, TelefoneChangeEvent
		// ContatoChangeEvent
		Contato c = new Contato();
		
		Janela gui = new Janela(c);
		gui.visible();
		
		Server web = new Server(c); 
		web.start();	
		
		Logger log = new Logger(c);
		
	}

}
