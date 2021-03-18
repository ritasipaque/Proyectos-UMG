/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.datos;
import seguridad.dominio.Modulos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Herbert Leonel Dominguez Chavez 15/02/2021
 */
public class ModulosDAO {

    private static final String SQL_INSERT = "insert into tbl_modulo values(?,?,?,?)";
    private static final String SQL_SELECT = "select * from tbl_modulo where PK_id_Modulo = ?";
    private static final String SQL_DELETE = "delete from tbl_modulo where PK_id_Modulo = ?";  
    private static final String SQL_UPDATE = "UPDATE tbl_modulo SET nombre_modulo=?, descripcion_modulo=?, estado_modulo=? WHERE PK_id_Modulo=?";
    private static final String SQL_QUERY = "SELECT PK_id_Modulo, nombre_modulo, descripcion_modulo, estado_modulo FROM tbl_modulo WHERE PK_id_Modulo = ?";
    

    public int insert(Modulos modulos){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, modulos.getCodigo_modulo());
            stmt.setString(2, modulos.getNombre_modulo());
            stmt.setString(3, modulos.getDescripcion_modulo());
            stmt.setString(4, modulos.getEstado_modulo());
//            System.out.println("ejecutando query:" + SQL_INSERT);
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
    public int update(Modulos modulos){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
//            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, modulos.getNombre_modulo());
            stmt.setString(2, modulos.getDescripcion_modulo());
            stmt.setString(3, modulos.getEstado_modulo());
            stmt.setInt(4, modulos.getCodigo_modulo());
            
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
    public int delete(Modulos modulos){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, modulos.getCodigo_modulo());
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
     public Modulos query(Modulos moduloC) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, moduloC.getCodigo_modulo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_persona = rs.getInt("PK_id_Modulo");
                String nombre = rs.getString("nombre_modulo");
                String apellido = rs.getString("descripcion_modulo");
                String email = rs.getString("estado_modulo");

                moduloC = new Modulos();
                moduloC.setCodigo_modulo(id_persona);
                moduloC.setNombre_modulo(nombre);
                moduloC.setDescripcion_modulo(apellido);
                moduloC.setEstado_modulo(email);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return moduloC;
    }
}
