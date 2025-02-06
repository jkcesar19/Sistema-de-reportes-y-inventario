
package com.system.business;
    
import com.system.conexion.Conexion;
import com.system.identity.Despacho;
import com.system.identity.implementation.DespachoImpldao;
import com.system.identity.interfaces.DespachoDao;

import java.sql.Connection;

public class DespachoBo {
  public static String NumId() throws Exception {
        Connection con = null;
        String dato = "";
        try {
            con = Conexion.getConexion();
            con.setAutoCommit(false);
            DespachoDao ventaDao = new DespachoImpldao(con);
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
  
  public static boolean grabarDespacho(Despacho objDespacho) throws Exception {
        Connection con = null;
        try {
            con = Conexion.getConexion();
            con.setAutoCommit(false);
            DespachoDao personDao = new DespachoImpldao(con);
            personDao.grabar(objDespacho);
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
