package toolkit;

/**
 * Classe utilitária com métodos para lidar com Strings
 *
 * @author Márcio Torres (marcio.torres@riogrande.ifrs.edu.br)
 * @since JDK 1.5 (versão mínima do Java para compilar)
 */
public class StringUtil {    

    // Princípio da Menor Surpresa
    // Princípio: DRY: Don't Repeat Yourself: NSR: Não Se Repita
    // Refatoração: renomear, introduzir constante,
    // introduzir variável explicativa

    private static final int ASCII_DIFF_UPPER_LOWER  = 32;
    private static final int ASCII_LOWER_START_INDEX = 97;
    private static final int ASCII_LOWER_END_INDEX   = 122;
    private static final int TO_UPPER = 0;
    private static final int TO_LOWER = 1;
    // Refatoração: introduzir método
    private static String changeCase(String s, int caseType) {        
        if (s == null) return null;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];            
            if (caseType == 0 && ehMinusculo(c)) chars[i] = upper(c);
            if (caseType == 1 && ehMaiusculo(c)) chars[i] = lower(c);
        } 
        return new String(chars);
    }    

    // javadoc: /**   */

    /**
     * Este método converte uma String com letras minúsculas
     * para maiúsculas. Números, símbolos e outros não-letras
     * ficam iguais.
     *
     * @param s    É uma String com letras minúsculas
     * @return     A String com letras maiúsculas, caracteres
     *             não-letras retornam iguais e caso a String
     *             de entrada for null retorna null
     */
    public static String upper(String s) {
        return changeCase(s, TO_UPPER);
    }

    public static String lower(String s) {
        return changeCase(s, TO_LOWER);
    }  
    /* não faça isso
    public static String lower(String s) {
        if (s != null) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 65 && chars[i] <= 90) {
                    chars[i] = (char) (chars[i] + ASCII_DIFF_UPPER_LOWER);
                }
            }
            return new String(chars);
        } else {
            return null;
        }        
    } 
    */
     
    // Princípio da Responsabilidade Única (Single Responsibility Principle)
    private static boolean ehMaiusculo(char c) {
        return (c >= 65 && c <= 90) || c == 199 || c == 195;
    }

    private static boolean ehMinusculo(char c) {
        return (c >= ASCII_LOWER_START_INDEX 
                    && c <= ASCII_LOWER_END_INDEX)
                    || c == 231 || c == 227;
    }

    public static char lower(char c) {
        if (ehMaiusculo(c)) {
            c += ASCII_DIFF_UPPER_LOWER;            
        }
        return c;
    }  

    public static char upper(char c) {
         if ((c >= ASCII_LOWER_START_INDEX 
                    && c <= ASCII_LOWER_END_INDEX)
                    || c == 231 || c == 227) {
            c -= ASCII_DIFF_UPPER_LOWER;
        }
        return c;
    }   

    public static String trim(String s) {
    	if (s == null) throw new NullPointerException();
    	//throw new RuntimeException();
        return s;
    }
}