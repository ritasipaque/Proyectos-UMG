package Finanzas.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Diego Vásquez
 */
public class AsientoContableDAO extends Conexion {

    public String NroAsiento() {

        String NumeroAsientoContable = "";
        String SQL_Maximo = "SELECT MAX(Codigo_DetalleAsiento) FROM asientocontabledetalle";

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

    public int getCantidadEncabezados() {
        int cantidadRegistros = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT COUNT(codigo_encabezadoasiento) FROM encabezadoasientocontable");
            rs = stmt.executeQuery();

            while (rs.next()) {
                cantidadRegistros = rs.getInt("COUNT(codigo_encabezadoasiento)");
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

    public String[][] RegistrosEncabezado() {

        String[][] matrixClasificacion;
        int i = 0;
        i = getCantidadEncabezados();
        matrixClasificacion = new String[i][1];

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT codigo_encabezadoasiento FROM encabezadoasientocontable");
            rs = stmt.executeQuery();
            int rowCount = 0;

            while (rs.next()) {
                matrixClasificacion[rowCount][0] = rs.getString(1);
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

    public int getCantidadPeriodos() {
        int cantidadRegistros = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT COUNT(codigo_periodofiscal) FROM periodofiscal");
            rs = stmt.executeQuery();

            while (rs.next()) {
                cantidadRegistros = rs.getInt("COUNT(codigo_periodofiscal)");
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

    public String[][] RegistrosPeriodos() {

        String[][] matrixClasificacion;
        int i = 0;
        i = getCantidadEncabezados();
        matrixClasificacion = new String[i][1];

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT Codigo_PeriodoFiscal FROM periodofiscal");
            rs = stmt.executeQuery();
            int rowCount = 0;

            while (rs.next()) {
                matrixClasificacion[rowCount][0] = rs.getString(1);
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
    
    public int getCantidadTipoAsiento() {
        int cantidadRegistros = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT COUNT(codigo_tipoasiento) FROM tipo_asiento");
            rs = stmt.executeQuery();

            while (rs.next()) {
                cantidadRegistros = rs.getInt("COUNT(codigo_tipoasiento)");
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

    public String[] RegistrosTipoAsiento() {

        String[] matrixClasificacion;
        int i = 0;
        i = getCantidadTipoAsiento();
        matrixClasificacion = new String[i];

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT Codigo_TipoAsiento FROM tipo_asiento");
            rs = stmt.executeQuery();
            int rowCount = 0;

            while (rs.next()) {
                matrixClasificacion[rowCount] = rs.getString(1);
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
