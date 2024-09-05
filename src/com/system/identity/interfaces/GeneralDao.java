package com.system.identity.interfaces;
import java.sql.SQLException;
import java.util.Vector;

public interface GeneralDao {

    public Vector Lista() throws SQLException;

    public boolean grabar(Object object) throws SQLException;

    public boolean eliminar(Object object) throws SQLException;

    public boolean modificar(Object object) throws SQLException;
}
