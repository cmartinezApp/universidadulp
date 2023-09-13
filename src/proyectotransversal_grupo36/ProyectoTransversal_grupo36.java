
package proyectotransversal_grupo36;

import AccesoADatos.*;
import Entidades.*;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;


public class ProyectoTransversal_grupo36 {

    
    public static void main(String[] args) {
        Conexion.getConexion();        
        Conexion.cerrarConexion();
    }
    
}
