package Finanzas.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/* @author Diego Vásquez*/
public class PartidaContableDAO extends Conexion {

    public String NroPartida() {

        String NumeroAsientoContable = "";
        String SQL_Maximo = "SELECT MAX(Codigo_PartidaContable) FROM partidacontable";

        try {

            Connection conexion = Conexion.getConnection();
            PreparedStatement ps = conexion.prepareStatement(SQL_Maximo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NumeroAsientoContable = rs.getString(1);
            }

        } catch (Exception ex) {
            System.out.println("¡ERROR!\n" + ex.toString());
        }

        return NumeroAsientoContable;
    }

    public int getCantidadRegistros() {
        int cantidadRegistros = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT COUNT(Codigo_PartidaContable) FROM partidacontable");
            rs = stmt.executeQuery();

            while (rs.next()) {
                cantidadRegistros = rs.getInt("COUNT(Codigo_PartidaContable)");
            }

        } catch (Exception ex) {
            System.out.println(ex);

        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cantidadRegistros;
    }

    public String[][] TablaDespliegue() {

        String[][] matrixClasificacion;
        int i = 0;
        i = getCantidadRegistros();
        matrixClasificacion = new String[i][4];

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM partidacontable");
            rs = stmt.executeQuery();
            int rowCount = 0;

            while (rs.next()) {
                matrixClasificacion[rowCount][0] = rs.getString(1);
                matrixClasificacion[rowCount][1] = rs.getString(2);
                matrixClasificacion[rowCount][2] = rs.getString(3);
                matrixClasificacion[rowCount][3] = rs.getString(4);
                rowCount++;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return matrixClasificacion;
    }
}
