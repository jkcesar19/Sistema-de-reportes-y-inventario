
package com.system.business;

import com.system.conexion.Conexion;
import com.system.identity.Producto;
import com.system.identity.implementation.ProductoImpldao;
import com.system.identity.interfaces.ProductoDao;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author llagu
 */
public class ProductoBo {
     public static DefaultComboBoxModel obtenerProducto() throws Exception {
        DefaultComboBoxModel producto = null;
        Connection con = Conexion.getConexion();
        try
        {
            ProductoDao productoDao = new ProductoImpldao(con);
            Vector vectorProducto = productoDao.Lista();
            producto = new DefaultComboBoxModel(vectorProducto);
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            if (con != null)
            {
                con.close();
            }
        }
        return producto;
    }
      public static boolean grabarProducto(Producto objProducto) throws Exception {
        Connection con = null;
        try
        {
            con = Conexion.getConexion();
            con.setAutoCommit(false);
            ProductoDao productoDao = new ProductoImpldao(con);
            productoDao.grabar(objProducto);
            con.commit();
            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally
        {
            if (con != null)
            {
                con.close();
            }
        }
    }
}
