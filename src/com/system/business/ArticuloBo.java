package com.system.business;

import com.system.conexion.Conexion;
import com.system.identity.Articulo;
import com.system.identity.implementation.ArticuloImpldao;
import com.system.identity.interfaces.ArticuloDao;
import java.sql.Connection;

/**
 *
 * @author llagu
 */
public class ArticuloBo {

    public static boolean grabarArticulo(Articulo objArticulo) throws Exception {
        Connection con = null;
        try {
            con = Conexion.getConexion();
            con.setAutoCommit(false);
            ArticuloDao prove = new ArticuloImpldao(con);
            prove.grabar(objArticulo);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}
