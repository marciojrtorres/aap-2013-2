package toolkit;

import static java.lang.System.out;
import static toolkit.StringUtil.*;

public class Main {
    public static void main(String[] argumentos) {
        
        List lista = new List();

        out.println(lista.length() == 0);

        out.println(lista.first() == lista.last());

        lista.append("um");

        out.println(lista.first().equals(lista.last()));

        lista.append("dois");
        lista.append("tres");
        lista.prepend("zero");

        out.println(lista.length() == 4);    
        out.println(lista.get(0).equals("zero"));
        out.println(lista.get(1).equals("um"));
        out.println(lista.get(2).equals("dois"));
        out.println(lista.get(3).equals("tres"));

        lista.insert(1, "inserido");

        out.println(lista.length() == 5);    
        out.println(lista.get(1).equals("inserido"));
        out.println(lista.get(0).equals("zero"));
        out.println(lista.get(2).equals("um"));
        out.println(lista.get(3).equals("dois"));
        out.println(lista.get(4).equals("tres"));

        out.println(lista.drop(1).equals("inserido"));

        out.println(lista.length() == 4);    
        out.println(lista.get(0).equals("zero"));
        out.println(lista.get(1).equals("um"));
        out.println(lista.get(2).equals("dois"));
        out.println(lista.get(3).equals("tres"));
        
        out.println(lista.first().equals("zero"));
        out.println(lista.last().equals("tres"));

        lista.insert(0, "inserido");        
        
        out.println(lista.length() == 5);    
        
        out.println(lista.first().equals("inserido"));
        out.println(lista.last().equals("tres"));

        out.println(lista.get(0).equals("inserido"));
        out.println(lista.get(1).equals("zero"));
        out.println(lista.get(2).equals("um"));
        out.println(lista.get(3).equals("dois"));
        out.println(lista.get(4).equals("tres"));

        out.println(lista.drop(2).equals("um"));

        out.println(lista.length() == 4);
        out.println(lista.get(2).equals("dois"));

        lista.wipe();

        out.println(lista.length() == 0);
        
    }   
}
