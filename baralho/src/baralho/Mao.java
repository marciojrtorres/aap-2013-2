package baralho;


import baralho.Baralho;
import baralho.Mesa;
import toolkit.List;

public class Mao {
	
	private List<Carta> cartas = new List<Carta>();
	
		
	public void pegaCartaTopo(Baralho baralho){		
		cartas.append(baralho.pegaTopo());
	}
	
	public void pegaCartaBase(Baralho baralho) {
		cartas.append(baralho.pegaBase());		
	}
	
	public void pegaCartaMeio(Baralho baralho) {
		cartas.append(baralho.pegaMeio());		
	}
	
    public Carta getCarta(int p){
    	if (p < 0 || p > cartas.length()) return null;
    	return cartas.get(p);
    }
	
    
	public void poemNaMesa(Mesa mesa, int posicao) {
		/*
		cartaAux = getCarta(posicao);
		System.out.println("carta: " + cartaAux);
		mesa.getCartasNaMesa().append(cartaAux);
		cartas.drop(posicao);
		*/
		if (posicao < 0 || posicao > cartas.length()) return;
		mesa.getCartasNaMesa().append(cartas.drop(posicao));
	
	}
	
	public void pegaDaMesa(Mesa mesa, int posicao) {
		if (posicao < 0 || posicao > cartas.length()) return;
		this.cartas.append(mesa.getCartasNaMesa().drop(posicao));
		/*
		cartaAux = mesa.cartasNaMesa.get(posicao);
		mesa.cartasNaMesa.drop(posicao);
		cartas.append(cartaAux); */
	}
	
	
	//List<Carta> lista = new List<Carta>();
	
	public int getPontos() {
		int vlr = 0;
		for (int i = 0; i < this.cartas.length(); i++ ) {
			vlr += this.cartas.get(i).cartaValor();
		}
		return vlr;
		
	}
	
	public int numeroCartas(){
		return cartas.length();
	}
	
	
	 public String mostraMao() { 
		 String mao = "";
		 for (int i = 0; i < cartas.length(); i++) {
			 //System.out.println(cartas.get(i).valor() + " de " + cartas.get(i).naipe() );
			 mao += cartas.get(i).valor() + " de " + cartas.get(i).naipe() + "\n"; 
			 
	     }
		 return mao;
	 }
	 
	
	
}
