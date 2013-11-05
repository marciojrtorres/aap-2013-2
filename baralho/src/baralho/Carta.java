package baralho;


public class Carta {

    public enum Valor {

    	AS(1), DOIS(2), TRES(3), QUATRO(4), CINCO(5), SEIS(6),
        SETE(7), OITO(8), NOVE(9), DEZ(10), VALETE(11), DAMA(12), REI(13);
        private final int peso;

        Valor(int valor) {
            this.peso = valor;
        }
    }

    public enum Naipe {

        OUROS(1), PAUS(2), ESPADAS(3), COPAS(4);
        private final int valor;

        Naipe(int valor) {
            this.valor = valor;
        }
    }
    
    private final Valor valor;
    private final Naipe naipe;

    public Carta(Valor valor, Naipe naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public Valor valor() {
        return valor;
    }

    public Naipe naipe() {
        return naipe;
    }

    @Override
    public String toString() {
        //return "[" + valor + " de " + naipe + "]";
        return "[" + valor.peso + " de " + naipe + "]";
    }


    public int cartaValor() {
        return valor.peso;
    }

}