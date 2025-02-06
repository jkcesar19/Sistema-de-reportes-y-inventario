package com.system.business;

import com.system.conexion.Conexion;
import com.system.identity.implementation.Tabla_SalidaImpldao;
import com.system.identity.interfaces.Tabla_SalidaDao;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author llagu
 */
public class Tabla_SalidaBo {

    public static DefaultTableModel ListaTable() throws Exception {
        DefaultTableModel materialTableModel = null;
        Connection con = Conexion.getConexion();
        try {
            Tabla_SalidaDao usuarioDao = new Tabla_SalidaImpldao(con);
            Vector datoUsuario = usuarioDao.Lista();
            Vector columnas = new Vector();

            columnas.add("PERSONAL");
            columnas.add("ARTICULO");
            columnas.add("CANTIDAD");
            columnas.add("FECHA");

            materialTableModel = new DefaultTableModel(datoUsuario, columnas);

        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return materialTableModel;
    }
}
