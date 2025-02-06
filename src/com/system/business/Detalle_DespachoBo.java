package com.system.business;

import com.system.conexion.Conexion;
import com.system.identity.Detalle_Despacho;
import com.system.identity.implementation.Detalle_DespachoImpldao;
import com.system.identity.interfaces.Detalle_DespachoDao;
import java.sql.Connection;

/**
 *
 * @author llagu
 */
public class Detalle_DespachoBo {

    public static boolean grabarDetalle_Despacho(Detalle_Despacho objArticulo) throws Exception {
        Connection con = null;
        try {
            con = Conexion.getConexion();
            con.setAutoCommit(false);
            Detalle_DespachoDao prove = new Detalle_DespachoImpldao(con);
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
