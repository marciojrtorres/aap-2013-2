package baralho;


import baralho.Carta.Naipe;
import baralho.Carta.Valor;
import toolkit.List;


public class Baralho {
	
	private static final int PRIMEIRA_CARTA = 0;
	
    private final List<Carta> cartas = new List<Carta>();

	private IPontuador pontuador = new PontuadorPadrao(); 
    
    public Baralho(){
        for (Naipe naipe : Naipe.values()) {
            for (Valor valor : Valor.values()) {    	
            	cartas.append(new Carta(valor, naipe));            	
            }
        }
    }
    
    public void setPontuador(IPontuador pontuador) {
    	this.pontuador = pontuador;
    }

    public void embaralha() {
       // Collections.shuffle(baralho);
    	// baralho.Baralha();
     	
    }
    

    public Carta removeCarta(int indice){
        return cartas.drop(indice);
    }
    
    
    public Carta pegaTopo() {
    	Carta cartaAux;
    	int idCarta = 0;
    	
    	idCarta = cartas.length()-1;
    	cartaAux = cartas.last();
    	removeCarta(idCarta);
    	return cartaAux;
    }
    
    public Carta pegaBase() {
    	Carta cartaAux;
    	
    	cartaAux = cartas.get(PRIMEIRA_CARTA);
    	removeCarta(PRIMEIRA_CARTA);
    	return cartaAux;
    }
    
    public Carta pegaMeio() { 
    	Carta cartaAux;
    	int idCarta = 0;
    	
    	idCarta = cartas.length()/2;
    	cartaAux = cartas.get(idCarta);
    	removeCarta(idCarta);
    	return cartaAux;
    }
    
    public void devolveTopo(Carta carta) {
    	cartas.append(carta);
    }
    
    public int getPontos(){
    	int pontos = 0;
    	for (int i = 0; i < cartas.length(); i++) {
    		pontos += pontuador.pontuar(cartas.get(i));
    	}
		return pontos;
	}
    
    public String mostraBaralho() { 
    	String mostraBaralho = "";
        for (int i = 0; i < cartas.length(); i++) {
            mostraBaralho += cartas.get(i).valor() + " de " + cartas.get(i).naipe() + "\n";
        }
        return mostraBaralho;
    }
    
    private class PontuadorPadrao implements IPontuador {

		@Override
		public int pontuar(Carta carta) {
			return 0;
		}
    	
    }
    
}