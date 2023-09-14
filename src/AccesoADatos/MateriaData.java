package AccesoADatos;

import Entidades.Materia;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.util.List;

public class MateriaData {

    private Connection conn = null;

    public MateriaData(Connection conn) {
        this.conn = conn;
    }

    public void guardarMateria(Materia materia) {
        String sql = "INSERT INTO materia(nombre, anio, estado) VALUES(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.getEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getRow());
                JOptionPane.showMessageDialog(null, "Materia añadida con éxito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia " + ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    public Materia buscarMateria(int id) {
        Materia materia = new Materia();
        String sql = "Select nombre, anio FROM materia Where idMateria = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anio"));
                materia.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe ninguna materia con ese ID");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla materia: " + ex.getMessage());
        }
        return materia;
    }

    public void modificarMateria(Materia materia) {
        String sql = "UPDATE materia SET nombre=?, anio=?, estado=? WHERE idMateria =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.getEstado());
            ps.setInt(4, materia.getIdMateria());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se modifico la Materia " + materia.getNombre());
            } else {
                JOptionPane.showMessageDialog(null, "No existe la materia.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar la materia: " + ex.getMessage());
        }
    }

    public void eliminarMateria(int id) {
        String sql = "DELETE FROM materia WHERE idMateria =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int fila=ps.executeUpdate();
            if(fila==1) {
                JOptionPane.showMessageDialog(null, "Se elimino la Materia ");
            } else {
                JOptionPane.showMessageDialog(null, "No existe la materia.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar la materia: " + ex.getMessage());
        }
    }

    public List<Materia> listarMaterias() {
        List<Materia> lista = new ArrayList<Materia>();
        String sql = "SELECT * FROM materia WHERE estado = 1";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anio"));
                materia.setEstado(true);
                lista.add(materia);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla materia: " + ex.getMessage());
        }
        return lista;
    }

}
