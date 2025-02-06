
package com.system.identity.implementation;


import com.system.identity.Detalle_Despacho;
import com.system.identity.interfaces.Detalle_DespachoDao;
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
public class Detalle_DespachoImpldao implements Detalle_DespachoDao{
 private PreparedStatement pst;
    private Statement st;
    private CallableStatement cst;
    private Connection con;
    private Detalle_Despacho objArticulo;

    public Detalle_DespachoImpldao(Connection con) {
        this.con = con;
    }
    
    @Override
    public Vector Lista() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
      objArticulo = (Detalle_Despacho) object;
        try {
            String sql = "{CALL,pro_ingresar_detalle_despacho(?,?,?)}";
            cst = con.prepareCall(sql);
            cst.setInt(1, objArticulo.getId_despacho());
            cst.setInt(2, objArticulo.getId_articulo());
            cst.setInt(3, objArticulo.getCantidad());
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
