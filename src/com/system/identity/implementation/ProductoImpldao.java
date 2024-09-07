
package com.system.identity.implementation;

import com.system.identity.Producto;
import com.system.identity.interfaces.ProductoDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author llagu
 */
public class ProductoImpldao implements ProductoDao{
   private PreparedStatement pst;
    private Statement st;
    private CallableStatement cst;
    private Connection con;
    private Producto objProducto;

    public ProductoImpldao(Connection con) {
        this.con = con;
    }

    @Override
    public Vector Lista() throws SQLException {
       Vector lista = new Vector();
        String sql = "SELECT * FROM vista_producto";
        st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Vector usuario = new Vector();
            usuario.add(rs.getString("producto"));
            usuario.add(rs.getString("marca"));
            usuario.add(rs.getString("caracteristicas"));
            lista.add(usuario);
        }
        return lista;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
          objProducto = (Producto) object;
        try {
            String sql = "{CALL,pro_registro_producto(?,?,?)}";
            cst = con.prepareCall(sql);
            cst.setString(1, objProducto.getProducto());
            cst.setString(2, objProducto.getMarca());
            cst.setString(3, objProducto.getCaracteristicas());
            cst.execute();
            cst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
      
    }

    @Override
    public boolean modificar(Object object) throws SQLException {
          objProducto = (Producto) object;
        try {
            String sql = "{CALL,pro_actualizar_producto(?,?,?,?)}";
            cst = con.prepareCall(sql);
            cst.setString(1, objProducto.getProducto());
            cst.setString(2, objProducto.getMarca());
            cst.setString(3, objProducto.getCaracteristicas());
            cst.setInt(3, objProducto.getId());
            cst.execute();
            cst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Vector Combobox() throws SQLException {
        Vector persona = new Vector();
        String sql = "SELECT producto FROM producto";
        st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Producto per = new Producto();
            per.setProducto(rs.getString("producto"));
            persona.add(per);
        }
        return persona;
    }
    
}
