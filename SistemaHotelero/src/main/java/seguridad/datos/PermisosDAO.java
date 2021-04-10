package seguridad.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PermisosDAO extends Conexion {

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    private String sqlConsultarUsuario = "SELECT PK_id_usuario FROM tbl_usuario WHERE username_usuario=?";
    private String sqlConsultarAplicacion = "SELECT PK_id_aplicacion FROM tbl_usuario_aplicacion WHERE PK_id_usuario = ?";
    private String sqlCantidaddeApps = "SELECT COUNT(PK_id_aplicacion) FROM tbl_usuario_aplicacion WHERE PK_id_usuario = ?";

    private String[] infoAplicaciones;

    //------------------------------//
    private String nombreUsuario = "";
    //-----------------------------//

    //-----------------------------
    public int getCodigoUsuario() {
        int codigoUsuario = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sqlConsultarUsuario);
            stmt.setString(1, getNombreUsuario());
            rs = stmt.executeQuery();

            while (rs.next()) {
                codigoUsuario = rs.getInt("PK_id_usuario");
            }

        } catch (Exception ex) {
            System.out.println(ex);

        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return codigoUsuario;
    }

    //------------------------------------
    public int getCantidadApps() {
        int cantidadApps = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sqlCantidaddeApps);
            stmt.setInt(1, getCodigoUsuario());
            rs = stmt.executeQuery();

            while (rs.next()) {
                cantidadApps = rs.getInt("COUNT(PK_id_aplicacion)");
            }

        } catch (Exception ex) {
            System.out.println(ex);

        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cantidadApps;
    }
    //--------------------------------

    public String[] AppsdeUsuario() {

        infoAplicaciones = new String[getCantidadApps()];

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sqlConsultarAplicacion);
            stmt.setInt(1, getCodigoUsuario());
            rs = stmt.executeQuery();
            int rowCount = 0;

            while(rs.next()){
                infoAplicaciones[rowCount] = String.valueOf(rs.getInt("PK_id_aplicacion"));
                rowCount++;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return infoAplicaciones;
    }
}