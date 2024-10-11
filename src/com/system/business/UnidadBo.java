
package com.system.business;

import com.system.conexion.Conexion;
import com.system.identity.implementation.UnidadImpldao;
import com.system.identity.interfaces.UnidadDao;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author llagu
 */
public class UnidadBo {
      public static DefaultComboBoxModel obtenerUnidad() throws Exception {
        DefaultComboBoxModel persona = null;
        Connection con = Conexion.getConexion();
        try {
            UnidadDao personDao = new UnidadImpldao(con);
            Vector vectorPersona = personDao.Combobox();
            persona = new DefaultComboBoxModel(vectorPersona);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return persona;
    } 
}
