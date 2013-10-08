package cobaia;

import static java.lang.System.out;
import toolkit.List;

public class Main {
    public static void main(String[] argumentos) {
    
        Cliente cliente = new Cliente();
        cliente.setNome("Gabrieli");

        if (Boolean.TRUE.equals(cliente.isVip())) {
            out.println("eh vip!");
        }

        if ("Gabrieli".equals(cliente.getNome())) {
            out.println("eh a Gabrieli");
        }     
        // polimorfismo paramétrico
        // parametrizar os tipos        
        cliente.getTelefones().append("323345222");
        cliente.getTelefones().append(new Endereco());
        cliente.getTelefones().prepend("99223344");

        String primeiro = (String) cliente.getTelefones().first();
        out.println(primeiro);

    }   
}
