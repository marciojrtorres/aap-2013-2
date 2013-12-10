package cobaia.gui;

import cobaia.model.Animal;
import cobaia.persistence.AnimalDAO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author marcio
 */
public class AnimalListarFrame extends javax.swing.JFrame {

    private AnimalDAO dao = new AnimalDAO();

    /** Creates new form AnimalListarFrame */
    public AnimalListarFrame() {
        initComponents();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                dao.close();
            }
        });

        initTable();
        loadTable();

    }

    private void initTable() {
        tabela.setDefaultRenderer(Double.class, new CurrencyColumnRenderer());
    }

    private void loadTable() {
        List<Animal> animais = dao.findAll();
        TableModel tm = new AnimalTableModel(animais);
        //tabela.set
        tabela.setModel(tm);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables


}

class AnimalTableModel extends AbstractTableModel {

    private final List<Animal> animais = new ArrayList<Animal>();

    public AnimalTableModel(List<Animal> animais) {
        this.animais.addAll(animais);
    }

    public int getRowCount() {
        return animais.size();
    }

    public int getColumnCount() {
        return 3;
    }


    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Código";
            case 1:
                return "Nome";
            case 2:
                return "Dono";
        }
        return null;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal a = animais.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return a.getId();
            case 1:
                return a.getNome();
            case 2:
                return a.getDono();
        }
        return null;
    }
}

class CurrencyColumnRenderer extends DefaultTableCellRenderer {

    public CurrencyColumnRenderer() {
        super();
        setHorizontalAlignment(SwingConstants.RIGHT);
    }

    @Override
    protected void setValue(Object value) {        
        Double val = (Double) value;
        setText(NumberFormat.getCurrencyInstance().format(val));
    }
}