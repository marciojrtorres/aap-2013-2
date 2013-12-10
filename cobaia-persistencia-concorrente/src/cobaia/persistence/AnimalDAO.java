package cobaia.persistence;

import cobaia.model.Animal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO extends BaseDAO<Animal> {

    public Animal load(int id) {
        try {            
            // BLOQUEIO
            PreparedStatement cmd = prepare("SELECT * FROM animais WHERE id_animal = ? FOR UPDATE"); // para pessimista
            
            // PreparedStatement cmd = prepare("SELECT * FROM animais WHERE id_animal = ?");
             
            cmd.setInt(1, id);
            ResultSet rs = cmd.executeQuery(); 
            if (rs.next()) {               
                return resultSetToModel(rs);
            } else {                
                throw new RuntimeException("O animal com o id " + id + " não foi encontrado");
            }
        } catch (Exception e) {
            System.err.println(e.toString());
            throw new RuntimeException("Não foi possível carregar o animal com o id " + id, e);
        }
    }

    public Animal find(int id) {
        try {
            PreparedStatement cmd = prepare("SELECT * FROM animais WHERE id_animal = ?");
            cmd.setInt(1, id);
            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                return resultSetToModel(rs);
            } else {
                throw new RuntimeException("O animal com o id " + id + " não foi encontrado");
            }
        } catch (Exception e) {
            System.err.println(e.toString());
            throw new RuntimeException("Não foi possível carregar o animal com o id " + id, e);
        }
    }

    public void save(Animal animal) {
        try {
            PreparedStatement cmd = null;
            if (animal.isPersistent()) {
                cmd = prepare("UPDATE animais SET nome = ?, tipo = ?, raca = ?, data_nasc = ?, dono = ? WHERE id_animal = ?");
                cmd.setInt(6, animal.getId());
            } else {
                cmd = prepare("INSERT INTO animais VALUES (DEFAULT, ?, ?, ?, ?, ?)");
            }
            cmd.setString(1, animal.getNome());
            cmd.setString(2, animal.getTipo());
            cmd.setString(3, animal.getRaca());
            cmd.setDate(4, animal.getDataNascimento() == null ? null : new java.sql.Date(animal.getDataNascimento().getTime()));
            cmd.setString(5, animal.getDono());
            if (cmd.executeUpdate() == 0) {
                throw new RuntimeException("O animal " + animal + " não foi salvo");
            }
            
            con.commit(); // para pessimista

        } catch (Exception e) {
            
            try {
                con.rollback();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }            
        	
            System.err.println(e.toString());
            throw new RuntimeException("Não foi possível salvar o animal " + animal, e);
        }
    }

    protected Animal resultSetToModel(ResultSet rs) {
        Animal a = new Animal();
        try {
            a.setId(rs.getInt("id_animal"));
            a.setDataNascimento(rs.getDate("data_nasc"));
            a.setDono(rs.getString("dono"));
            a.setNome(rs.getString("nome"));
            a.setRaca(rs.getString("raca"));
            a.setTipo(rs.getString("tipo"));
        } catch (Exception e) {
            System.err.println(e.toString());
            throw new RuntimeException("Não foi possível carregar o animal a partir do resultset " + rs, e);
        }
        return a;
    }

    public List<Animal> findAll() {
        try {
            List<Animal> animais = new ArrayList<Animal>();

            PreparedStatement cmd = prepare("SELECT * FROM animais");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                animais.add(resultSetToModel(rs));
            }
            return animais;
        } catch (Exception e) {
            System.err.println(e.toString());
            throw new RuntimeException("Não foi possível carregar os animais", e);
        }
    }



    

}
