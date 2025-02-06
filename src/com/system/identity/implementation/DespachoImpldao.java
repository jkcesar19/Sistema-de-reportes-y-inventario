package com.system.identity.implementation;

import com.system.identity.Despacho;
import com.system.identity.interfaces.DespachoDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DespachoImpldao implements DespachoDao {

    private PreparedStatement pst;
    private Statement st;
    private CallableStatement cst;
    private Connection con;
    private Despacho objDespacho;

    public DespachoImpldao(Connection con) {
        this.con = con;
    }

    @Override
    public String NumeroId() {
        String serie = "";
        String sql = "SELECT MAX(id) FROM des_pacho ";
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
        objDespacho = (Despacho) object;
        try {
            String sql = "{CALL,pro_registro_despacho(?,?,?,?)}";
            cst = con.prepareCall(sql);
            cst.setString(1, objDespacho.getId_usuario());
            cst.setString(2, objDespacho.getId_personal());
            cst.setString(3, objDespacho.getDescripcion());
            cst.setInt(4, objDespacho.getNumero());
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
