package com.system.identity.interfaces;


import com.system.identity.Usuario;
import java.sql.SQLException;

public interface UsuarioDao extends GeneralDao {

    public Usuario validarUsuario(String user, String clave) throws SQLException;

    public Usuario validarUsuarioId(String per, String user) throws Exception;
}
