package seguridad.datos;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OtakuGT
 */

public class UsuarioDAO {
    private static final String SQL_SELECT = "SELECT * FROM tbl_usuario";
    private static final String SQL_INSERT = "INSERT INTO tbl_usuario(PK_id_usuario, nombre_usuario, apellido_usuarios, password_usuario, cambio_contrasena, ultima_conexion, estado_usuario) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_usuario SET nombre_usuario=?, apellido_usuarios=?, password_usuario=?, cambio_contrasena=?, ultima_conexion=?, estado_usuario=? WHERE PK_id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_usuario WHERE PK_id_usuario=?";
    Conexion conectar = new Conexion();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Usuario usuario = null;
    
    public List listar(){
         List<Usuario> usuarios = new ArrayList <>();
         try {
             conn=conectar.getConnection();
             stmt=conn.prepareStatement(SQL_SELECT);
             rs=stmt.executeQuery();
             while (rs.next()) {
                 Usuario usr= new Usuario();
                 usr.setId_usuario(rs.getString(1).charAt(0));
                 usr.setNombre_usuario(rs.getString(2));
                 usr.setApellido_usuario(rs.getString(3));
                 usr.setPassword_usuario(rs.getString(4));
                 usr.setCambio_password(rs.getInt(5));
                 usr.setUltima_conexion(rs.getDate(6));
                 usr.setEstado_usuario(rs.getInt(7));
                 usuarios.add(usr);
             }
         }catch (Exception e){
         }
         return usuarios;
    }
    
     public int insert(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, usuario.getId_usuario());
            stmt.setString(2, usuario.getNombre_usuario());
            stmt.setString(3, usuario.getApellido_usuario());
            stmt.setString(4, usuario.getPassword_usuario());
            stmt.setInt(5, usuario.getCambio_password());
            stmt.setDate(6, usuario.getUltima_conexion());
            stmt.setInt(7, usuario.getEstado_usuario());
            stmt.executeUpdate();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
     }
        return 1;
     }
}
       
  
