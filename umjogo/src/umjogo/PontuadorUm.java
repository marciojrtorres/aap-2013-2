package umjogo;

import baralho.Carta;
import baralho.IPontuador;
import baralho.Carta.Naipe;
import toolkit.List;

public class PontuadorUm implements IPontuador {

	@Override
	public int pontuar(Carta carta) {
		int p = 0;
		switch (carta.naipe()) {
		case COPAS:   p = 1; break; 
		case PAUS:
		case OUROS:
		case ESPADAS: p = 5;
		}		
		return p;
	}

}
