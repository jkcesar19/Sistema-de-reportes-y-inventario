package com.system.business;

import com.system.conexion.Conexion;
import com.system.identity.implementation.RolImpldao;
import com.system.identity.interfaces.RolDao;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author llagu
 */
public class RolBo {

    public static DefaultComboBoxModel obtenerRol() throws Exception {
        DefaultComboBoxModel unidad = null;
        Connection con = Conexion.getConexion();
        try {
            RolDao unid = new RolImpldao(con);
            Vector vectorUnidad = unid.Lista();
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
