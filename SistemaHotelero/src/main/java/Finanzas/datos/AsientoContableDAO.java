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
            System.out.println("¡ERROR!\n"+ex.toString());
        }

        return NumeroAsientoContable;
    }

}
