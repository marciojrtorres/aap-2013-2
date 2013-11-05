package log;

import domain.Contato;
import domain.ContatoChangeEvent;
import domain.ContatoChangeListener;

public class Logger implements ContatoChangeListener {

	public Logger(Contato c) {
		c.addContatoChangeListener(this);
	}

	@Override
	public void contatoChange(ContatoChangeEvent e) {
		System.out.println("LOG: contato alterado para " 
					+ e.getNome() + ", " + e.getTelefone());
	}
	
}
