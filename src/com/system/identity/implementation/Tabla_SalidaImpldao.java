package com.system.identity.implementation;

import com.system.identity.interfaces.Tabla_SalidaDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author llagu
 */
public class Tabla_SalidaImpldao implements Tabla_SalidaDao {

    private Statement st;

    private Connection con;

    public Tabla_SalidaImpldao(Connection con) {
        this.con = con;
    }

    @Override
    public Vector Lista() throws SQLException {
        Vector lista = new Vector();
        String sql = "SELECT pe.razonsocial,p.producto, dp.cantidad, d.fecha FROM des_pacho d\n"
                + "INNER JOIN detalle_despacho dp ON d.id = dp.id_despacho \n"
                + "INNER JOIN articulo a ON a.id=dp.id_articulo\n"
                + "INNER JOIN producto p ON p.id=a.id_producto\n"
                + "INNER JOIN persona pe ON pe.id= d.id_personal";
        st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Vector salida = new Vector();

            salida.add(rs.getString("pe.razonsocial"));
            salida.add(rs.getString("p.producto"));
            salida.add(rs.getString("dp.cantidad"));
            salida.add(rs.getString("d.fecha"));
            lista.add(salida);
        }
        return lista;
    }

}
