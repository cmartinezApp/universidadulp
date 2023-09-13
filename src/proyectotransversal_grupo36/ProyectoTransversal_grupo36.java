
package proyectotransversal_grupo36;

import AccesoADatos.Conexion;


public class ProyectoTransversal_grupo36 {

    
    public static void main(String[] args) {
        Conexion.getConexion();
        System.out.println("Conexión establecida");
        Conexion.cerrarConexion();
    }
    
}//borre algunos comentarios y agregue este
