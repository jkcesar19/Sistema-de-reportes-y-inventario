package com.system.identity.implementation;

import com.system.identity.Rol;
import com.system.identity.interfaces.RolDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author llagu
 */
public class RolImpldao implements RolDao{

    private Connection con;
    private Statement st;

    public RolImpldao(Connection con) {
        this.con = con;
    }

    @Override
    public Vector Lista() throws SQLException {
        Vector unidad = new Vector();
        String sql = "SELECT id, rol FROM rol";
        st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Rol uni = new Rol();
            uni.setId(rs.getInt("id"));
            uni.setRol(rs.getString("rol"));
            unidad.add(uni);
        }
        return unidad;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
