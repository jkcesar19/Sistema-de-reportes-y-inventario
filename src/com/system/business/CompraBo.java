package com.system.business;

import com.system.conexion.Conexion;
import com.system.identity.Compra;
import com.system.identity.implementation.CompraImpldao;
import com.system.identity.interfaces.CompraDao;
import java.sql.Connection;

/**
 *
 * @author llagu
 */
public class CompraBo {

    public static String NumId() throws Exception {
        Connection con = null;
        String dato = "";
        try {
            con = Conexion.getConexion();
            con.setAutoCommit(false);
            CompraDao ventaDao = new CompraImpldao(con);
            dato = ventaDao.NumeroId();
            con.commit();
            return dato;
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
      public static boolean grabarCompra(Compra objCompra) throws Exception {
        Connection con = null;
        try {
            con = Conexion.getConexion();
            con.setAutoCommit(false);
            CompraDao prove = new CompraImpldao(con);
            prove.grabar(objCompra);
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
