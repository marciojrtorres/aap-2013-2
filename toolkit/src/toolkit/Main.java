package toolkit;

// import estÃ¡tico: importaÃ§Ã£o dos membros da classe
import static java.lang.System.out;
import static toolkit.StringUtil.*;

public class Main {
    public static void main(String[] argumentos) {
        out.println((int)'ç'); // 231
        out.println((int)'Ç'); // 199
        out.println((int)'ã'); // 227
        out.println((int)'Ã'); // 195

        out.println(StringUtil.upper("programação"));
        // "PROGRAMAÃ§Ã£O"
        // 135 Ã§ - 128 Ã‡
        // 198 Ã£ - 199 Ãƒ

        out.println(StringUtil.upper("toolkit"));
        out.println(StringUtil.lower("ASPECTOS"));

        out.println(lower("5tApQ0").equals("5tapq0"));        

        out.println(lower('A')); // lower(char):char
        // out.println(upper('a')); // upper(char):char

        // dada uma entrada a saÃ­da Ã© previsÃ­vel
        // definiÃ§Ã£o da API: definir a interface
        // definir a assinatura do mÃ©todo
        out.println(trim(" prog  ").equals("prog"));
        out.println(trim(" prog av ").equals("prog av"));
        
        // out.println(s);
        //out.println(lower(null)); // devolve o quÃª? null, por enquanto
        //out.println(upper(null)); // devolve o quÃª? null, por enquanto

        out.println(upper('ç'));
        out.println(lower('Ç'));

        // pode ser NPE   // faz o programa quebrar (ver Fail Fast)
        // pode voltar String vazia // nÃ£o quebram
        // pode voltar null // nÃ£o quebram
    }   
}
