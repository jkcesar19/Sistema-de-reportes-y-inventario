package com.system.business;

import com.system.conexion.Conexion;
import com.system.identity.Articulo;
import com.system.identity.implementation.ArticuloImpldao;
import com.system.identity.interfaces.ArticuloDao;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

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
    public static DefaultTableModel ListaTable() throws Exception {
        DefaultTableModel usuarioTableModel = null;
        Connection con = Conexion.getConexion();
        try {
            ArticuloDao personDao = new ArticuloImpldao(con);
            Vector datoPerson = personDao.Lista();
            Vector columnas = new Vector();

            columnas.add("ID");
            columnas.add("ARTICULO");
            columnas.add("STOCK");

            usuarioTableModel = new DefaultTableModel(datoPerson, columnas);

        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return usuarioTableModel;
    }
    
     public static boolean ModificarArticulo(Articulo objArticulo) throws Exception {
        Connection con = null;
        try {
            con = Conexion.getConexion();
            con.setAutoCommit(false);
            ArticuloDao prove = new ArticuloImpldao(con);
            prove.modificar(objArticulo);
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
