package com.system.business;

import com.system.conexion.Conexion;
import com.system.identity.Person;
import com.system.identity.implementation.PersonImpldao;
import com.system.identity.interfaces.PersonDao;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author llagu
 */
public class PersonBo {

    public static DefaultTableModel ListaTable(int ip) throws Exception {
        DefaultTableModel usuarioTableModel = null;
        Connection con = Conexion.getConexion();
        try {
            PersonDao personDao = new PersonImpldao(con);
            Vector datoPerson = personDao.Lista_tipo_persona(ip);
            Vector columnas = new Vector();

            columnas.add("Nombres");
            columnas.add("DNI");
            columnas.add("Dirección");
            columnas.add("Teléfono");
            columnas.add("Correo");

            usuarioTableModel = new DefaultTableModel(datoPerson, columnas);

        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return usuarioTableModel;
    }

    public static boolean grabarPerson(Person objPerson) throws Exception {
        Connection con = null;
        try {
            con = Conexion.getConexion();
            con.setAutoCommit(false);
            PersonDao personDao = new PersonImpldao(con);
            personDao.grabar(objPerson);
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

    public static boolean modificarPerson(Person objPerson) throws Exception {
        Connection con = null;
        try {
            con = Conexion.getConexion();
            con.setAutoCommit(false);
            PersonDao personDao = new PersonImpldao(con);
            personDao.modificar(objPerson);
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

    public static boolean EliminarPerson(Person objPerson) throws Exception {
        Connection con = null;
        try {
            con = Conexion.getConexion();
            con.setAutoCommit(false);
            PersonDao personDao = new PersonImpldao(con);
            personDao.eliminar(objPerson);
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
      public static Person validarPerson(String nom, String dni) throws Exception {
        Connection con = null;
        Person material = null;
        try {
            con = Conexion.getConexion();
            PersonDao personDao = new PersonImpldao(con);
            material = personDao.validarPerson(nom,dni);
            if (material == null) {
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return material;
    }
       public static DefaultComboBoxModel obtenerPersona(int t) throws Exception {
        DefaultComboBoxModel persona = null;
        Connection con = Conexion.getConexion();
        try {
            PersonDao personDao = new PersonImpldao(con);
            Vector vectorPersona = personDao.Combobox(t);
            persona = new DefaultComboBoxModel(vectorPersona);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return persona;
    } 
}
