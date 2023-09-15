
package proyectotransversal_grupo36;

import AccesoADatos.*;
import Entidades.*;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;


public class ProyectoTransversal_grupo36 {

    
    public static void main(String[] args) {
        Conexion.getConexion();
        /*Alumno al1 = new Alumno(26596365, "Martínez", "Carlos", LocalDate.of(1989, Month.SEPTEMBER, 3), true);
        Alumno al2 = new Alumno(25963541, "Venturini", "Pablo", LocalDate.of(1987, Month.MARCH, 30), true);
        Alumno al3 = new Alumno(23654896, "Fernández", "Ivanna", LocalDate.of(1989, Month.SEPTEMBER, 5), true);
        AccesoADatos.AlumnoData alu = new AccesoADatos.AlumnoData(Conexion.getConexion());
        alu.guardarAlumno(al1);
        alu.guardarAlumno(al2);
        alu.guardarAlumno(al3);
        Materia mat1 = new Materia("Matemática", 1, true);
        Materia mat2 = new Materia("Inglés", 1, true);
        Materia mat3 = new Materia("Programación I", 2, true);
        AccesoADatos.MateriaData materia = new AccesoADatos.MateriaData(Conexion.getConexion());
        materia.guardarMateria(mat1);
        materia.guardarMateria(mat2);
        materia.guardarMateria(mat3);*/
        
        Conexion.cerrarConexion();
    }
    
}
