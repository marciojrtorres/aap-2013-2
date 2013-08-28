package intro;

import java.util.*;

public class Main {

    // API: Application Programming
    // Interface (Interface de Programação de Aplicativos)

    // Classe -> Componente -> Programa
    // Ex.: String
    // A parte exposta (atributos e métodos) de uma Classe
    // é conhecida como API

    public static void main(String[] argumentos) {
    
    	// Scanner scan = new Scanner(System.in);
    	// System.out.println("Primeiro número: ");
        // String s1 = scan.nextLine();
        // System.out.println("Segundo número: ");        
        // String s2 = scan.nextLine();
        
        // Não vamos fazer entrada de dados,
        // atribuiremos direto no código
        
        // String s1 = "aaa";
        // String s2 = "bbb";

        // int i1 = Integer.parseInt(s1);
        // int i2 = Integer.parseInt(s2);

        // System.out.println(i1 + i2); // == 
        
        // Princípio da Menor Surpresa
        double n = 0.0;

        for (int i = 0; i < 10; i++) {
            n = n + 0.1;
        }

        System.out.println(n);

        // Java, C#, Objective C: tipagem estática
        // o tipo é pré-definido
        // PHP, Python, JavaScript: tipagem dinâmica
    }   

}
