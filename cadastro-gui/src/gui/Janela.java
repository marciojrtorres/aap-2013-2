package gui;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import domain.Contato;


public class Janela extends JFrame {

	private final Contato contato;
	private final JTextField textFieldNome;
	private final JTextField textFieldTelefone;

	public Janela(final Contato c) {
		this.contato = c;
		
		this.setLayout(new GridLayout(3, 2));
		
		add(new JLabel("Nome:"));
		textFieldNome = new JTextField(c.getNome());
		add(textFieldNome);
		
		add(new JLabel("Telefone:"));	
		textFieldTelefone = new JTextField(c.getTelefone());
		add(textFieldTelefone);
		
		JButton buttonSubmit = new JButton("Submete");
		buttonSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c.setNome(textFieldNome.getText());
				c.setTelefone(textFieldTelefone.getText());
			}
		});
		
		JButton buttonRefresh = new JButton("Obtem");
		buttonRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldNome.setText(contato.getNome());
				textFieldTelefone.setText(contato.getTelefone());
			}
		});
		
		add(buttonSubmit);
		add(buttonRefresh);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		//setSize(400, 300);
	}

	public void visible() {
		setVisible(true);
	}


}

