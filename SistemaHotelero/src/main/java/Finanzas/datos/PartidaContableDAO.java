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
            System.out.println("¡ERROR!\n"+ex.toString());
        }

        return NumeroAsientoContable;
    }
    
}
