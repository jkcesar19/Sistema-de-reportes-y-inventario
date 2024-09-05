package com.system.identity.implementation;

import com.system.identity.Usuario;
import com.system.identity.interfaces.UsuarioDao;
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
public class UsuarioImpldao implements UsuarioDao {

    private PreparedStatement pst;
    private Statement st;
    private CallableStatement cst;
    private Connection con;
    private Usuario objUsuario;

    public UsuarioImpldao(Connection con) {
        this.con = con;
    }

    @Override
    public Usuario validarUsuario(String user, String clave) throws SQLException {
        Usuario usuario = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            String sql = "SELECT * FROM vista_usuario "
                    + " WHERE usuario = '" + user + "'  AND password = '" + clave + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setUsuario(rs.getString(2));
                usuario.setPassword(rs.getString(3));
                usuario.setPersona(rs.getString(4));
                usuario.setRol(rs.getString(5));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            } else {
                pst.close();
            }
        }
        return usuario;

    }

    @Override
    public Usuario validarUsuarioId(String per, String user) throws Exception {
       Usuario usuario = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            String sql = "SELECT * FROM vista_usuario "
                    + " WHERE razonsocial = '" + per + "' AND usuario = '" + user + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setUsuario(rs.getString(2));
                usuario.setPassword(rs.getString(3));
                usuario.setPersona(rs.getString(4));
                usuario.setRol(rs.getString(5));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            } else {
                pst.close();
            }
        }
        return usuario;
    

    }

    @Override
    public Vector Lista() throws SQLException {
        Vector lista = new Vector();
        String sql = "SELECT * FROM vista_usuario";
        st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Vector usuario = new Vector();

            usuario.add(rs.getString("usuario"));
            usuario.add(rs.getString("password"));
            usuario.add(rs.getString("razonsocial"));
            usuario.add(rs.getString("rol"));
            lista.add(usuario);
        }
        return lista;

    }

    @Override
    public boolean grabar(Object object) throws SQLException {
         objUsuario = (Usuario) object;
        try {
            String sql = "{CALL,pro_registro_usuario(?,?,?,?)}";
            cst = con.prepareCall(sql);
            cst.setString(1, objUsuario.getUsuario());
            cst.setString(2, objUsuario.getPassword());
            cst.setString(3, objUsuario.getPersona());
            cst.setString(4, objUsuario.getRol());
            cst.execute();
            cst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }

    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
         objUsuario = (Usuario) object;
        try {
            String sql = "{CALL,pro_eliminar_usuario(?)}";
            cst = con.prepareCall(sql);
            cst.setInt(1, objUsuario.getId());
            cst.execute();
            cst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }

    }

    @Override
    public boolean modificar(Object object) throws SQLException {
         objUsuario = (Usuario) object;
        try {
            String sql = "{CALL,pro_actualizar_usuario(?,?,?,?,?)}";
            cst = con.prepareCall(sql);
            cst.setString(1, objUsuario.getUsuario());
            cst.setString(2, objUsuario.getPassword());
            cst.setString(3, objUsuario.getPersona());
            cst.setString(4, objUsuario.getRol());
            cst.setInt(5, objUsuario.getId());
            cst.execute();
            cst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

}
