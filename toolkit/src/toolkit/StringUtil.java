package toolkit;

public class StringUtil {    
    // escolher assinatura
    // escolher uma API
    // toUpperCase(String):String
    // toUpper(String):String
    // upper(String):String
    // upcase(String):String

    // entrada inválida:
    // != a-z
    // lanço uma exceção? retorna string vazia?
    // retorna a mesma string que entrou?
    // retorna nulo?


    private static final int ASCII_DIFF_UPPER_LOWER  = 32;
    private static final int ASCII_LOWER_START_INDEX = 97;
    private static final int ASCII_LOWER_END_INDEX   = 122;

    // Refatoração: alterar o código sem alterar a funcionalidade
    // melhorar a qualidade interna do software

    public static String upper(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            boolean ehMinusculo = chars[i] >= ASCII_LOWER_START_INDEX 
                    && chars[i] <= ASCII_LOWER_END_INDEX;

            if (ehMinusculo) {
                chars[i] = (char) (chars[i] - ASCII_DIFF_UPPER_LOWER);
            }

        } 
        return new String(chars);
    }

    // regra fundamental para projetar API's:
    // manter consistente.

    public static String lower(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] = (char) (chars[i] + ASCII_DIFF_UPPER_LOWER);
            }
        }
        return new String(chars);
    }    

    // Code Smell: mau cheiro no código
    // o código funciona, mas há a 
    // percepção de deselegância

    public static String trim(String s) {
        return s;
    }
}