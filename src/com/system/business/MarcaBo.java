
package com.system.business;

import com.system.conexion.Conexion;
import com.system.identity.implementation.MarcaImpldao;
import com.system.identity.interfaces.MarcaDao;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author llagu
 */
public class MarcaBo {
      public static DefaultComboBoxModel obtenerMarca() throws Exception {
        DefaultComboBoxModel unidad = null;
        Connection con = Conexion.getConexion();
        try {
            MarcaDao unid = new MarcaImpldao(con);
            Vector vectorUnidad = unid.Combobox();
            unidad = new DefaultComboBoxModel(vectorUnidad);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return unidad;
    }
}
