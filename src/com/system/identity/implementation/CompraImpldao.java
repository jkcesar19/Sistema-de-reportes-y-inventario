package com.system.identity.implementation;

import com.system.identity.Compra;
import com.system.identity.interfaces.CompraDao;
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
public class CompraImpldao implements CompraDao {

    private PreparedStatement pst;
    private Statement st;
    private CallableStatement cst;
    private Connection con;
    private Compra objCompra;

    public CompraImpldao(Connection con) {
        this.con = con;
    }

    @Override
    public String NumeroId() {
        String serie = "";
        String sql = "SELECT MAX(id) FROM compra";
        try {
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                serie = rs.getString(1);
            }
        } catch (SQLException e) {
        }
        return serie;
    }


    @Override
    public Vector Lista() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objCompra = (Compra) object;
        try {
            String sql = "{CALL,pro_registro_compra(?,?,?,?,?,?,?,?,?,?,?)}";
            cst = con.prepareCall(sql);
            cst.setString(1, objCompra.getCodigo());
            cst.setString(2, objCompra.getSerie());
            cst.setString(3, objCompra.getId_proveedor());
            cst.setString(4, objCompra.getId_trabajador());
            cst.setString(5, objCompra.getDescripcion());
            cst.setDouble(6, objCompra.getSub_total());
            cst.setDouble(7, objCompra.getDescuento());
            cst.setDouble(8, objCompra.getIgv());
            cst.setDouble(9, objCompra.getTotal());
            cst.setString(10, objCompra.getArchivo());
            cst.setString(11, objCompra.getFecha_compra());
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
