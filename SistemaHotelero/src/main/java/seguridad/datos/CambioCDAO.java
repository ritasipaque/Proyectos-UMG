/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.datos;

import seguridad.dominio.CambioContra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diana
 */
public class CambioCDAO {
    private static final String SQL_UPDATE = "UPDATE `umg`.`tbl_login' SET password_login=?  WHERE PK_id_usuario=?";
  
    
    public int update(CambioContra AActualizar){
         Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
//            stmt.setString(1, AActualizar.getUser());    
//            stmt.setString(2, AActualizar.getContra());      
            
            stmt.setString(1, "4561237890 ");    
            stmt.setString(2, "Administrador");      
            
 

            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
}