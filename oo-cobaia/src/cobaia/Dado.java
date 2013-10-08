package cobaia;

import toolkit.Randomizer;

public class Dado {
    
    private int numero;
    private final int lados;

    public static Dado deDezLados() {
        return lados(10);
    }

    public static Dado lados(int lados) {
        return new Dado(lados);
    }

    public Dado() {        
        this(6); // Dado(6)
    }

    public Dado(int lados) {
        if (lados <= 0) throw new IllegalArgumentException();
        this.lados = lados;
    }

    // consulta: obtém o estado do objeto
    public int getNumero() {
        return numero;
    }

    public int getLados() {
        return lados;
    }

    // comando: não tem retorno
    public void joga() {
        double r = Randomizer.random();        
        numero = (int) (r * lados + 1);
    }

    @Override
    public String toString() {
        return numero + "";
    }
    
}