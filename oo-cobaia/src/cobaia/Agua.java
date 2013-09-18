// Agua.java
package cobaia;
// padrão java bean (get, set, is)
public class Agua {

    private int temperatura;

    public Agua() {
        temperatura = 21;
    }

    public Agua(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public boolean estaSolida() {
        return temperatura <= 0;
    }

    public boolean estaGasosa() {
        return temperatura >= 100;
    }

    public boolean estaLiquida() {
        return !estaSolida() && !estaGasosa();
    }

    public void aquece() {
        temperatura++;
    }

    public void esfria() {
        temperatura--;
    }

    @Override
    public String toString() {
        String estado = "";
        if (estaSolida())  estado = "solida";
        if (estaLiquida()) estado = "liquida";
        if (estaGasosa())  estado = "gasosa";
        return "Agua a " + temperatura + " graus " + estado;
    }

}