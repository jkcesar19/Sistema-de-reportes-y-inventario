
package com.system.business;

import com.system.conexion.Conexion;
import com.system.identity.Usuario;
import com.system.identity.implementation.UsuarioImpldao;
import com.system.identity.interfaces.UsuarioDao;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author llagu
 */
public class UsuarioBo {
    public static Usuario validarUsuario(String usa, String clave) throws Exception {
        Connection con = null;
        Usuario usuario = null;
        try {
            con = Conexion.getConexion();
            UsuarioDao usuarioDao = new UsuarioImpldao(con);
            usuario = usuarioDao.validarUsuario(usa, clave);
            if (usuario == null) {
                throw new Exception("Usuario y/o Clave incorectos");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return usuario;
    }
     public static DefaultTableModel ListaTable() throws Exception {
        DefaultTableModel materialTableModel = null;
        Connection con = Conexion.getConexion();
        try {
            UsuarioDao usuarioDao = new UsuarioImpldao(con);
            Vector datoUsuario = usuarioDao.Lista();
            Vector columnas = new Vector();

           
            columnas.add("USUARIO");
            columnas.add("PASSWORD");
            columnas.add("PERSONA");
            columnas.add("Rol");

            materialTableModel = new DefaultTableModel(datoUsuario, columnas);

        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return materialTableModel;
    }
     public static boolean grabarUsuario(Usuario objUsuario) throws Exception {
        Connection con = null;
        try {
            con = Conexion.getConexion();
            con.setAutoCommit(false);
            UsuarioDao usuarioDao = new UsuarioImpldao(con);
            usuarioDao.grabar(objUsuario);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
      public static boolean modificarUsuario(Usuario objUsuario) throws Exception {
        Connection con = null;
        try {
            con = Conexion.getConexion();
            con.setAutoCommit(false);
            UsuarioDao usuarioDao = new UsuarioImpldao(con);
            usuarioDao.modificar(objUsuario);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public static boolean eliminarUsuario(Usuario objUsuario) throws Exception {
        Connection con = null;
        try {
            con = Conexion.getConexion();
            con.setAutoCommit(false);
            UsuarioDao usuarioDao = new UsuarioImpldao(con);
            usuarioDao.eliminar(objUsuario);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }


    public static Usuario validarUsuarioId(String per,String user) throws Exception {
    Connection con = null;
        Usuario maquina = null;
        try {
            con = Conexion.getConexion();
            UsuarioDao usuarioDao = new UsuarioImpldao(con);
            maquina = usuarioDao.validarUsuarioId(per,user);
            if (maquina == null) {
                throw new Exception("Usuario y/o Clave incorectos");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return maquina;
    }
}
