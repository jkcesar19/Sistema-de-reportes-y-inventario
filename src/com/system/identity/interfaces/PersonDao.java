package com.system.identity.interfaces;

import com.system.identity.Person;
import java.sql.SQLException;
import java.util.Vector;

public interface PersonDao extends GeneralDao {

    public Vector Combobox(int t) throws SQLException;

    public Vector Lista_tipo_persona(int id) throws SQLException;

    public Person validarPerson(String nom, String dni) throws SQLException;
}
