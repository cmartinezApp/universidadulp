package AccesoADatos;

import Entidades.*;
import AccesoADatos.*;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;

public class InscripcionData {

    private Connection conn = null;
    private MateriaData matData;
    private AlumnoData aluData;

    public InscripcionData() {
        this.conn = Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion insc){
        String sql = "INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES (?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, null);
            ps.setInt(2, insc.getIdAlumno());
            ps.setInt(3, insc.getIdMateria());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getRow());
                JOptionPane.showMessageDialog(null, "Inscripcion a "+insc.getMateria().getNombre()+" realizada con éxito");
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse: "+ex.getMessage());
        }
    }
    
    public List<Inscripcion> obtenerInscripciones(){
        return null;
    }
    
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id){
        return null;
    }
    
    public List<Materia> obtenerMateriasCursadas(int id){
        return null;
    }
    
    public List<Materia> obtenerMateriasNoCursadas(int id){
        return null;
    }
    
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
        
    }
    
    public void actualizarNota(int idAlumno, int idMateria, double nota){
        MateriaData mat = new MateriaData();
        AlumnoData al = new AlumnoData();
        String sql = "UPDATE inscripcion SET nota=? WHERE idAlumno=? AND idMateria=?";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se modifico la nota de la materia "+mat.buscarMateria(idMateria).getNombre()+" Para el almuno "+al.buscarAlumno(idAlumno).getApellido());
            } else {
                if (mat.buscarMateria(idMateria).equals(null)){
                    JOptionPane.showMessageDialog(null, "No existe la materia.");
                }
                if (al.buscarAlumno(idAlumno).equals(null)){
                    JOptionPane.showMessageDialog(null, "El alumno no existe");
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR");
                }
                
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al modificar la nota: "+ex.getMessage());
        }
    }
    
    public List<Alumno> obtenerAlumnosXMateria(int idMateria){
        return null;
    }
    
}
