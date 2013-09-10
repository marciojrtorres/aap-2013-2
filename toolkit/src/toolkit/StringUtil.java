package toolkit;

public class StringUtil {    

    // Princípio da Menor Surpresa
    // Princípio: DRY: Don't Repeat Yourself: NSR: Não Se Repita
    // Refatoração: renomear, introduzir constante,
    // introduzir variável explicativa

    private static final int ASCII_DIFF_UPPER_LOWER  = 32;
    private static final int ASCII_LOWER_START_INDEX = 97;
    private static final int ASCII_LOWER_END_INDEX   = 122;
    
    public static String upper(String s) {
        // if (s == null) return null; // retornar cedo
        if (s == null) {
            throw new NullPointerException("A String não pode ser nula");            
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if (ehMinusculo(chars[i])) {

                chars[i] = (char) (chars[i] - ASCII_DIFF_UPPER_LOWER);
            }

        } 
        return new String(chars);
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
    public static String lower(String s) {
        if (s == null) {
            throw new NullPointerException("A String não pode ser nula");            
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (ehMaiusculo(chars[i])) {
                chars[i] = (char) (chars[i] + ASCII_DIFF_UPPER_LOWER);
            }
        }
        return new String(chars);        
    }   
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
        return s;
    }
}