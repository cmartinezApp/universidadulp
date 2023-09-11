package AccesoADatos;

import Entidades.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlumnoData {
private Connection con=null;

    public AlumnoData() {
    }

    public AlumnoData(Connection con) {
        this.con = con;
    }
   public void guardarAlumno(Alumno alumno){ // falta codigo
   } 
   
   public Alumno buscarAlumno(int id){// falta codigo
       Alumno alumno=null;
   return alumno;}
   
   public Alumno buscarAlumnoPorDni(int dni){// falta codigo
   Alumno alumno=null;
   return alumno;}
   
   public List<Alumno> listarAlumnos(){
   List<Alumno> alumnos=new ArrayList<>();
   try{
       String sql="SELECT *FROM alumno WHERE estado =1";
       PreparedStatement ps=con.prepareStatement(sql);
       ResultSet rs=ps.executeQuery();
       while(rs.next()){
       Alumno alumno=new Alumno();
       
       alumno.setIdAlumno(rs.getInt("idAlumno"));
       alumno.setDni(rs.getInt("dni"));
       alumno.setApellido(rs.getString("apellido"));
       alumno.setNombre(rs.getString("nombre"));
       alumno.setFechaDeNaciemiento(rs.getDate("fechaNacimiento").toLocalDate());
       alumno.setEstado(rs.getBoolean("estado"));
       alumnos.add(alumno);
       
   }
       ps.close();
       
   }catch(SQLException ex){
       
   JOptionPane.showMessageDialog(null,"Error al acceder ala atabla Alumnos "+ ex.getMessage());
   }
   
   return alumnos;
   }
   
   
   
  public void modificarAlumno(Alumno alumno){// falta codigo
  }
  
  public void eliminarAlumno(int id){
  }
  
  
  
}
