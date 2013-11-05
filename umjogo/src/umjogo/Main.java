package umjogo;

import baralho.Baralho;
import baralho.Carta;
import baralho.IPontuador;

public class Main {
	public static void main(String[] args) {
		
		Baralho baralho = new Baralho();

		baralho.setPontuador(new PontuadorUm());
		
		System.out.println(baralho.getPontos());
		System.out.println(baralho.getPontos());
		
		baralho.setPontuador(new IPontuador() {
			
			@Override
			public int pontuar(Carta carta) {
				return 1000 + carta.cartaValor();
			}
		});
		
		System.out.println(baralho.getPontos());
		System.out.println(baralho.getPontos());
		
	}
}
