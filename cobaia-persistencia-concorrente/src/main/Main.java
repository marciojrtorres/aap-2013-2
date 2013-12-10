package main;

import cobaia.gui.MainFrame;

public class Main {

    public static void main(String[] args) {

    	// LAST WINS: o último vence
    	// PESSIMISTIC LOCK: bloqueio pessimista
    	
    	
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });

    }
}