package AccesoADatos;

import Entidades.*;
import AccesoADatos.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class InscripcionData {

    private Connection con = null;
    private MateriaData matData = new MateriaData();
    private AlumnoData alumData = new AlumnoData();

    public InscripcionData() {
        this.con = Conexion.getConexion();

    }

    public void guardarInscripcion(Inscripcion insc) {
        try {
            String sql = "INSERT INTO inscripcion(  nota,idAlumno, idMateria) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Inscripcion realizada con exito ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Inscripción  " + ex.getMessage());
        }
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        String sql = "UPDATE inscripcion SET nota=? WHERE idAlumno=? and idMateria=? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int fila = ps.executeUpdate();
            if (fila > 1) {
                JOptionPane.showMessageDialog(null, "Nota actualizada ");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Inscripción  " + ex.getMessage());
        }
    }

    public void borrarInscripcion(int idAlumno, int idMateria) {//BORRADO FISICO DE INCRIPCION
        String sql = "DELETE FROM `inscripcion` WHERE idAlumno=? and idMateria=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int fila = ps.executeUpdate();
            if (fila > 1) {
                JOptionPane.showMessageDialog(null, "Inscripcion eliminada ");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Inscripción  " + ex.getMessage());
        }

    }
    
    public double obtenerNota(int idAlumno, int idMateria){
        String sql = "SELECT nota FROM inscripcion WHERE idAlumno=? and idMateria=?";
        Inscripcion ins = new Inscripcion();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                try{
                    ins.setNota(rs.getDouble("nota"));
                }catch(NullPointerException ex){
                    ins.setNota(0.0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe ninguna materia/alumno con ese ID");
            }
            ps.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Inscripción  " + ex.getMessage());
        }
        
        return ins.getNota();
    }

    public List<Inscripcion> obtenerInscripcion() {
        ArrayList<Inscripcion> cursada = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno alu = new Alumno();
                alu = alumData.buscarAlumno(rs.getInt("IdAlumno"));
                Materia mat = new Materia();
                mat = matData.buscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                cursada.add(insc);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Inscripción  " + ex.getMessage());
        }
        return cursada;
    }

    public List<Inscripcion> obtenerAlumnoPorMateria(int idAl) {
        ArrayList<Inscripcion> cursada = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion WHERE idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAl);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno alu = new Alumno();
                alu = alumData.buscarAlumno(rs.getInt("IdAlumno"));
                Materia mat = new Materia();
                mat = matData.buscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                cursada.add(insc);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Inscripción  " + ex.getMessage());
        }
        return cursada;
    }

    public List<Materia> obtenerMateriaCursada(int idAlu) {
        ArrayList<Materia> materiaCursada = new ArrayList<>();
        String sql = "SELECT inscripcion.idMateria,inscripcion.nota,nombre,anio FROM inscripcion,materia"
                + " WHERE inscripcion.idMateria = materia.idMateria AND inscripcion.idAlumno=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlu);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia mat = new Materia();
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnioMateria(rs.getInt("anio"));
                materiaCursada.add(mat);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Inscripción  " + ex.getMessage());
        }

        return materiaCursada;
    }

    public List<Materia> obtenerMateriasNoCursadas(int idAlu) {
        ArrayList<Materia> materiaNoCursada = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE estado=1 AND idMateria not in ( SELECT idMateria FROM inscripcion WHERE idAlumno =?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlu);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia mat = new Materia();
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnioMateria(rs.getInt("anio"));
                materiaNoCursada.add(mat);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Inscripción  " + ex.getMessage());
        }
        return materiaNoCursada;
    }

    public List<Alumno> obtenerAlumnoPorMaterias(int idMat) {
        ArrayList<Alumno> alumnosPorMateria = new ArrayList<>();
        String sql = "SELECT a.idAlumno,dni,apellido,nombre,fechaNacimiento,estado "
                + "FROM inscripcion i,alumno a WHERE i.idAlumno = a.idAlumno AND a.estado = 1 AND idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMat);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno al = new Alumno();

                al.setIdAlumno(rs.getInt("idAlumno"));
                al.setDni(rs.getInt("dni"));
                al.setApellido(rs.getString("apellido"));
                al.setNombre(rs.getString("nombre"));
                al.setFechaDeNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                al.setEstado(rs.getBoolean("estado"));

                alumnosPorMateria.add(al);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno  " + ex.getMessage());
        }
        return alumnosPorMateria;
    }

}
