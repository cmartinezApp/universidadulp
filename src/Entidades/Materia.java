package Entidades;

public class Materia {

    private int idMateria;
    private String nombre;
    private int anioMateria;
    private Boolean estado;

    public Materia() {
    }

    public Materia(int idMateria, String nombre, int anioMateria, Boolean estado) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.estado = estado;
    }
    
    public Materia(int idMateria, String nombre) {
        this.idMateria = idMateria;
        this.nombre = nombre;
    }

    public Materia(String nombre, int anioMateria, Boolean estado) {
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.estado = estado;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioMateria() {
        return anioMateria;
    }

    public void setAnioMateria(int anioMateria) {
        this.anioMateria = anioMateria;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Materia: " + nombre;
    }

}
