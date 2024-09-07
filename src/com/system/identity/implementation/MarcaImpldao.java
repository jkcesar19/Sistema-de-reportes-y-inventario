package com.system.identity.implementation;

import com.system.identity.Marca;
import com.system.identity.interfaces.MarcaDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author llagu
 */
public class MarcaImpldao implements MarcaDao{

    private Connection con;
    private Statement st;

    public MarcaImpldao(Connection con) {
        this.con = con;
    }

    @Override
    public Vector Lista() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector Combobox() throws SQLException {
         Vector unidad = new Vector();
        String sql = "SELECT  marca FROM marca";
        st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Marca uni = new Marca();
            uni.setMarca(rs.getString("marca"));
            unidad.add(uni);
        }
        return unidad;
    }

}
