package intro;

// não vamos usar a biblioteca padrão
// com exceção de: String, mas apenas
// com dois métodos:
// toCharArray():char[]   Ex.: "if".toCharArray() => ['i', 'f']
// charAt(int):char       Ex.: "if".charAt(1) => 'f'
//                        mesmo "if".toCharArray()[1]
// e em casos futuros usaremos os wrappers
// Integer, Double, ...

public class Main {
    public static void main(String[] argumentos) {
 
        char[] caracteres = "aspectos".toCharArray(); // teste

        for (int i = 0; i < caracteres.length; i++) {
            System.out.println((int)caracteres[i]);
        }

        System.out.println((char)82);

        for (int i = 0; i < 256; i++) {
            System.out.println(i + " : " + (char)i);            
        }

    }   
}
