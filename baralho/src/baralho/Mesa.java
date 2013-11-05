package baralho;
import toolkit.List;

public class Mesa {
	private List<Carta> cartasNaMesa = new List<Carta>();
	
	
	protected List<Carta> getCartasNaMesa() {
		return cartasNaMesa;
	}
	
	
	public void devolveBaralho(Baralho baralho, int posicao) {
		if (posicao < 0 || posicao > cartasNaMesa.length()) return;
		baralho.devolveTopo(cartasNaMesa.drop(posicao));
	}
	
	
	
	public String mostraMesa() { 
		String mesa = "";
		 for (int i = 0; i < cartasNaMesa.length(); i++) {
			 System.out.println(cartasNaMesa.get(i).valor() + " de " + 
					 cartasNaMesa.get(i).naipe() );
			 mesa += cartasNaMesa.get(i).valor() + " de " + cartasNaMesa.get(i).naipe() + "\n"; 
	     }
		 return mesa;
	 }
	
	/*
	public int somaMesa(){
		int vlr = 0;
		String str = "";
		for (int i = 0; i < this.cartasNaMesa.length(); i++ ) {
			vlr += cartasNaMesa.get(i).valor().values();
			//str += Valor.values();
			vlr += Integer.parseInt(str);
		}
		return vlr;
		
	}
	*/

}
