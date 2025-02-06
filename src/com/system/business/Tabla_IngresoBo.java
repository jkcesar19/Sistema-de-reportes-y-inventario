
package com.system.business;

import com.system.conexion.Conexion;
import com.system.identity.implementation.Tabla_IngresoImpldao;
import com.system.identity.interfaces.Tabla_IngresoDao;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author llagu
 */
public class Tabla_IngresoBo {
    public static DefaultTableModel ListaTable() throws Exception {
        DefaultTableModel materialTableModel = null;
        Connection con = Conexion.getConexion();
        try {
            Tabla_IngresoDao usuarioDao = new Tabla_IngresoImpldao(con);
            Vector datoUsuario = usuarioDao.Lista();
            Vector columnas = new Vector();

            columnas.add("ARTICULO");
            columnas.add("UNIDAD");
            columnas.add("PRECIO");
            columnas.add("SUB T");
            columnas.add("DESCUENTO");
            columnas.add("IGV");
            columnas.add("TOTAL");
            columnas.add("STOCK I");
            columnas.add("STOCK F");

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
