package toolkit;

// import estÃ¡tico: importaÃ§Ã£o dos membros da classe
import static java.lang.System.out;
import static toolkit.StringUtil.*;

public class Main {
    public static void main(String[] argumentos) {
        for (int i = 0; i < 100; i++)
            out.println((int)(Randomizer.random() * 6 + 1));
        
    }   
}
