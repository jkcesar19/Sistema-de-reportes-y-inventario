
package com.system.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author llagu
 */
public class Conexion {
     private static Connection Con = null;

    public static Connection getConexion() throws Exception, ClassCastException {
        Connection Con = null;
        String url = "jdbc:mysql://localhost:3306/dbsystem_004";
        String usuario = "root";
        String clave = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Con = DriverManager.getConnection(url, usuario, clave);
        return Con;

    }

    public static void main(String[] args) {
        try {
            JOptionPane.showMessageDialog(null, "Coneccion correcta");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
