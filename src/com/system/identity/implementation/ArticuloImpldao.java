package com.system.identity.implementation;

import com.system.identity.Articulo;
import com.system.identity.interfaces.ArticuloDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author llagu
 */
public class ArticuloImpldao implements ArticuloDao {

    private PreparedStatement pst;
    private Statement st;
    private CallableStatement cst;
    private Connection con;
    private Articulo objArticulo;

    public ArticuloImpldao(Connection con) {
        this.con = con;
    }

    @Override
    public Vector Lista() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objArticulo = (Articulo) object;
        try {
            String sql = "{CALL,pro_registro_articulo(?,?,?,?,?,?,?,?)}";
            cst = con.prepareCall(sql);
            cst.setInt(1, objArticulo.getId_compra());
            cst.setString(2, objArticulo.getId_producto());
            cst.setString(3, objArticulo.getId_unidad());
            cst.setInt(4, objArticulo.getCantidad());
            cst.setDouble(5, objArticulo.getPrecio());
            cst.setDouble(6, objArticulo.getSub_total());
            cst.setDouble(7, objArticulo.getDescuento());
            cst.setDouble(8, objArticulo.getTotal());
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
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

}