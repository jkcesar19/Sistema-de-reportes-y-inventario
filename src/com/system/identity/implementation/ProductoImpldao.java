
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
         Vector unidad = new Vector();
        String sql = "SELECT * FROM vista_producto";
        st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next())
        {
            Producto uni = new Producto();
//            uni.setId(rs.getInt("id"));
            uni.setProducto(rs.getString("producto"));
            uni.setProducto(rs.getString("marca"));
            uni.setProducto(rs.getString("caracteristicas"));
            unidad.add(uni);
        }
        return unidad;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
          objProducto = (Producto) object;
        try {
            String sql = "{CALL,pro_registrar_producto(?)}";
            cst = con.prepareCall(sql);
            cst.setString(1, objProducto.getProducto());
            cst.execute();
            cst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
