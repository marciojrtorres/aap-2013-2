package cobaia.persistence;

import cobaia.model.IModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class BaseDAO<T extends IModel> {

    private static final String URL     = "jdbc:mysql://10.132.214.45:3306/petshop";
    private static final String USUARIO = "aluno";
    private static final String SENHA   = "aluno";
    private static final String DRIVER  = "com.mysql.jdbc.Driver";

    protected Connection con;

    static {
        try {
            
            Class.forName(DRIVER);
            
        } catch (ClassNotFoundException ex) {
            throw new ExceptionInInitializerError("driver indisponivel");
        }
    }

    public BaseDAO() {
        try {

            // MESMA TRANSAÇÃO
            
            con = DriverManager.getConnection(URL, USUARIO, SENHA); // BEGIN AUTOMÁTICO                        
            
            // commit é a submissão do comando (faz!)
            con.setAutoCommit(false); // para pessimista

        } catch (Exception e) {
            System.err.println(e.toString());
            throw new RuntimeException("Não foi possível abrir a conexão", e);
        }
    }

    protected PreparedStatement prepare(String sql) {
        try {
            return con.prepareStatement(sql);
        } catch (Exception e) {
            System.err.println(e.toString());
            throw new RuntimeException("Não foi possível preparar uma declaração", e);
        }
    }

    public void close() {
        try {
            if (con != null) {
                if (!con.isClosed()) {
                    con.close();
                }
            }
        } catch (Exception e) {
            System.err.println(e.toString());
            throw new RuntimeException("Não foi possível fechar a conexão", e);
        }
    }

    protected abstract T resultSetToModel(ResultSet rs);
}

