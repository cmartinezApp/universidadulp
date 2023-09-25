
package AccesoADatos;

import AccesoADatos.Conexion;
import Entidades.Logueo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class logueoData {
      private Connection con = null;

    public logueoData() {
        con=Conexion.getConexion();
    }
    
public Logueo buscarUsuarioPorContraseña(String contrasenia, String usuario) {
        Logueo loguin = null;
        String sql = "SELECT usuario, contrasenia FROM logueo WHERE usuario=? AND contrasenia =?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasenia);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                loguin = new Logueo();
                loguin.setUsuario(rs.getString("usuario"));
                loguin.setContrasenia(rs.getString("contrasenia"));
               

            } else {
                JOptionPane.showMessageDialog(null, "Error. Usuario o Contraseña incorrecta ...");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());

        }

        return loguin;
    }
}
