package toolkit;

// import estático: importação dos membros da classe
import static java.lang.System.out;
import static toolkit.StringUtil.*;

public class Main {
    public static void main(String[] argumentos) {
 
        System.out.println(StringUtil.upper("toolkit"));
        System.out.println(StringUtil.lower("ASPECTOS"));

        out.println(lower("5tApQ0").equals("5tapq0"));

        // dada uma entrada a saída é previsível
        // definição da API: definir a interface
        // definir a assinatura do método
        out.println(trim(" prog  ").equals("prog"));
        out.println(trim(" prog av ").equals("prog av"));

    }   
}
