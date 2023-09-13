package AccesoADatos;

import Entidades.Materia;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class MateriaData {

    private Connection con = null;

    public MateriaData(Connection con) {
        this.con = con;
    }
    
    public void guardarMateria(Materia materia){
        String sql = "INSERT INTO materia(idMateria, nombre, anio, estado) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, materia.getIdMateria());
            ps.setString(2, materia.getNombre());
            ps.setInt(3, materia.getAnioMateria());
            ps.setBoolean(4, materia.getEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getRow());
                JOptionPane.showMessageDialog(null, "Materia añadida con éxito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia " + ex.getMessage());
        }
    }
    
    public Materia buscarMateria(int id){
        return null;
    }
    
    public void modificarMateria(Materia materia){
        
    }
    
    public void eliminarMateria(int id){
        
    }
    
    public List<Materia> listarMaterias(){
        return null;
    }
}
