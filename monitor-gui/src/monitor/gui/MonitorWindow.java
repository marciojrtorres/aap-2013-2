package monitor.gui;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class MonitorWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private final JTextField textFieldFreeSpace;
	

	public MonitorWindow() {
		
		this.setTitle("Monitorador de espaço livre");
		
		this.setLayout(new GridLayout(2, 3));
		
		add(new JLabel("Espaço livre:"));
		textFieldFreeSpace = new JTextField("125");
		add(textFieldFreeSpace);
		add(new JLabel("MiB"));
		
		add(new JLabel("Unidade monitorada:"));
		add(new JLabel("C:\\"));
		
		JButton buttonRefresh = new JButton("Atualiza");
		buttonRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldFreeSpace.setText("130");
			}
		});
		
		add(buttonRefresh);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		
	}

	public void visible() {
		setVisible(true);
	}


}

