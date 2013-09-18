package cobaia;

import static java.lang.System.out;

public class Main {
    public static void main(String[] argumentos) {
        
        // um objeto: estado válido ou inválido
        Agua agua = new Agua(50);

        while (!agua.estaSolida()) agua.esfria();

        out.println(agua);        

    }   
}
