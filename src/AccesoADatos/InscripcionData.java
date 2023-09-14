package AccesoADatos;

import Entidades.*;
import AccesoADatos.*;
import java.sql.*;
import java.util.List;

public class InscripcionData {

    private Connection conn = null;
    private MateriaData matData;
    private AlumnoData aluData;

    public InscripcionData() {
    }

    void guardarInscripcion(Inscripcion insc){
        
    }
    
    List<Inscripcion> obtenerInscripciones(){
        return null;
    }
    
    List<Inscripcion> obtenerInscripcionesPorAlumno(int id){
        return null;
    }
    
    List<Materia> obtenerMateriasCursadas(int id){
        return null;
    }
    
    List<Materia> obtenerMateriasNoCursadas(int id){
        return null;
    }
    
    void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
        
    }
    
    void actualizarNota(int idAlumno, int idMateria, double nota){
        
    }
    
    List<Alumno> obtenerAlumnosXMateria(int idMateria){
        return null;
    }
    
}
