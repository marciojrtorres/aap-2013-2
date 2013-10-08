package cobaia;

public class Dados {

    private final Dado[] dados;
    
    public Dados() {
        this(2);
    }

    public Dados(int qtdDados) {
        dados = new Dado[qtdDados];
        for (int i = 0; i < qtdDados; i++) {
            dados[i] = new Dado();
        }
    }

    public int getLados() {
        int lados = 0;
        for (Dado dado : dados) {
            lados += dado.getLados();
        }
        return lados;
    }

    public int getNumero() {
        int numero = 0;
        for (Dado dado : dados) {
            numero += dado.getNumero();
        }
        return numero;
    }

    public void joga() {        
        for (Dado dado : dados) dado.joga();
    }

    @Override
    public String toString() {
        return this.getNumero() + "";
    }
}