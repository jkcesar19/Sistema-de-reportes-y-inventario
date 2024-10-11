package com.system.identity.implementation;

import com.system.identity.Person;
import com.system.identity.interfaces.PersonDao;
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
public class PersonImpldao implements PersonDao {

    private PreparedStatement pst;
    private Statement st;
    private CallableStatement cst;
    private Connection con;
    private Person objPerson;

    public PersonImpldao(Connection con) {
        this.con = con;
    }

    @Override
    public Vector Combobox(int t) throws SQLException {
        Vector persona = new Vector();
        String sql = "SELECT razonsocial FROM persona WHERE estado = " + 1+" AND id_tipo_persona =" +t;
        st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Person per = new Person();
            per.setRazonsocial(rs.getString("razonsocial"));
            persona.add(per);
        }
        return persona;
    }

    @Override
    public Person validarPerson(String nom, String doc) throws SQLException {
        Person person = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
  //"SELECT `id`, `razonsocial`, `id_tipo_documento`, `num_doc`, `direccion`, `telefono`, `correo`, `id_tipo_persona`, `estado` FROM `persona` WHERE 1"      
        try {
            String sql = "SELECT id FROM persona  WHERE razonsocial = '" + nom + "' AND num_doc = '" + doc + "' AND estado = " + 1;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            if (rs.next()) {
                person = new Person();
                person.setId(rs.getInt("id"));
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
        return person;

    }

    @Override
    public Vector Lista_tipo_persona(int tipo_perosna) throws SQLException {
        Vector listaPerson = new Vector();
        String sql = "SELECT * FROM persona WHERE estado = " + 1 + " AND id_tipo_persona =" + tipo_perosna;
        st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Vector person = new Vector();
//            person.add(rs.getInt("idpersona"));
            person.add(rs.getString("razonsocial"));
            person.add(rs.getString("num_doc"));
            person.add(rs.getString("direccion"));
            person.add(rs.getInt("telefono"));
            person.add(rs.getString("correo"));
//            person.add(rs.getString("estado"));
            listaPerson.add(person);
        }
        return listaPerson;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objPerson = (Person) object;
        try {
            String sql = "{CALL,pro_registro_persona(?,?,?,?,?,?,?)}";
            cst = con.prepareCall(sql);
            cst.setString(1, objPerson.getRazonsocial());
            cst.setInt(2, objPerson.getId_d());
            cst.setString(3, objPerson.getDoc());
            cst.setString(4, objPerson.getDireccion());
            cst.setString(5, objPerson.getTelefono());
            cst.setString(6, objPerson.getCorreo());
            cst.setInt(7, objPerson.getId_p());
            cst.execute();
            cst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        objPerson = (Person) object;
        try {
            String sql = "{CALL,pro_eliminar_persona(?)}";
            cst = con.prepareCall(sql);
            cst.setInt(1, objPerson.getId());
            cst.execute();
            cst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean modificar(Object object) throws SQLException {
        objPerson = (Person) object;
        try {
            String sql = "{CALL,pro_actualizar_persona(?,?,?,?,?,?,?,?)}";
            cst = con.prepareCall(sql);
            cst.setString(1, objPerson.getRazonsocial());
            cst.setString(2, objPerson.getDoc());
            cst.setString(3, objPerson.getDireccion());
            cst.setString(4, objPerson.getTelefono());
            cst.setString(5, objPerson.getCorreo());
            cst.setInt(6, objPerson.getId());
            cst.execute();
            cst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Vector Lista() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

}
