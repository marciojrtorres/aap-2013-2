package tr.apresentacao;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import tr.domain.Produto;
import tr.persistencia.ProdutoDAO;
import tr.persistencia.ProdutoSalvaEvent;
import tr.persistencia.SalvaProdutoListener;

public class ListaProdutoFrame extends JFrame
				implements SalvaProdutoListener {

	private static final long serialVersionUID = 1L;
	
	private ProdutoDAO dao;
	private JTable table;
	
	public ListaProdutoFrame(ProdutoDAO dao) {
		
		this.dao = dao;
		
		populate();
		
		dao.addSalvaProdutoListener(this);
		
		JScrollPane scroll = new JScrollPane(table);
		
		add(scroll, BorderLayout.CENTER);
		
		JButton btAtualizar = new JButton("Atualizar");
		btAtualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				populate();				
			}
		});
		
		add(btAtualizar, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		//setSize(400, 300);
	}

	private void populate() {
		if (table == null) table = new JTable();
		table.setModel(new ProdutoTableModel(dao.lista()));
	}

	public void visible() {
		setVisible(true);
	}
	
	private class ProdutoTableModel extends AbstractTableModel {

		private static final long serialVersionUID = 1L;
		
		private List<Produto> produtos;

		public ProdutoTableModel(List<Produto> produtos) {
			this.produtos = produtos;
		}

		@Override
		public int getRowCount() {
			return produtos.size();
		}

		@Override
		public int getColumnCount() {
			return 2;
		}
		
		@Override
		public String getColumnName(int column) {
			switch (column) {
			case 0: return "Id";
			case 1: return "Descrição";
			}
			return null;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch (columnIndex) {
			case 0: return produtos.get(rowIndex).getId();
			case 1: return produtos.get(rowIndex).getDescricao();
			}
			return null;
		}
		
	}

	@Override
	public void produtoSalvo(ProdutoSalvaEvent produtoSalvaEvent) {
		populate();		
	}
	
	
}
