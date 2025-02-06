package com.system.identity.implementation;

import com.system.identity.interfaces.Tabla_IngresoDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author llagu
 */
public class Tabla_IngresoImpldao implements Tabla_IngresoDao {

    private Statement st;
    private Connection con;

    public Tabla_IngresoImpldao(Connection con) {
        this.con = con;
    }

    @Override
    public Vector Lista() throws SQLException {
        Vector lista = new Vector();
        String sql = "SELECT p.producto,u.unidad_medida, a.precio, a.sub_total, a.descuento,a.igv, a.total, a.stock_inicial, a.stock_final \n"
                + "FROM articulo a\n"
                + "INNER JOIN producto p ON p.id=a.id_producto\n"
                + "INNER JOIN unidad_medida u ON u.id=a.id_unidad";
        st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Vector salida = new Vector();

            salida.add(rs.getString("p.producto"));
            salida.add(rs.getString("u.unidad_medida"));
            salida.add(rs.getString("a.precio"));
            salida.add(rs.getString("a.sub_total"));
            salida.add(rs.getString("a.descuento"));
            salida.add(rs.getString("a.igv"));
            salida.add(rs.getString("a.total"));
            salida.add(rs.getString("a.stock_inicial"));
            salida.add(rs.getString("a.stock_final"));
            lista.add(salida);
        }
        return lista;
    }

}
