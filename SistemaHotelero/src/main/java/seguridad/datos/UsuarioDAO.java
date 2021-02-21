package seguridad.datos;

import seguridad.dominio.Usuario;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import seguridad.dominio.Aplicacion;

/**
 *
 * @author OtakuGT
 */

public class UsuarioDAO {
    private static final String SQL_SELECT = "SELECT * FROM tbl_usuario";
    private static final String SQL_INSERT = "INSERT INTO tbl_usuario(PK_id_usuario, nombre_usuario, apellido_usuarios, password_usuario, cambio_contrasena, ultima_conexion, estado_usuario) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_usuario SET nombre_usuario=?, apellido_usuarios=?, password_usuario=?, cambio_contrasena=?, ultima_conexion=?, estado_usuario=? WHERE PK_id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_usuario WHERE PK_id_usuario=?";
    private static final String SQL_QUERY = "SELECT PK_id_usuario, nombre_usuario, apellido_usuarios, password_usuario, cambio_contrasena, ultima_conexion, estado_usuario FROM tbl_usuario WHERE PK_id_usuario = ?";
    
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
                 usr.setId_usuario(rs.getString(1));
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
   public Usuario query(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        int rows=0;
        
         try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, usuario.getId_usuario());
            rs = stmt.executeQuery();
            while(rs.next()){
                //Como jalo un varchar :u?
                String id_usuario = rs.getString("PK_id_usuario");
                String nombre_usuario = rs.getString("nombre_usuario");
                String apellido_usuario = rs.getString("apellido_usuarios");
                String password_usuario = rs.getString("password_usuario");
                int cambio_contrasena = rs.getInt("cambio_contrasena");
                Date ultima_conexion = rs.getDate("ultima_conexion");
                int estado_usuario = rs.getInt("estado_usuario");

                //ESTO ES :U 
                usuario = new Usuario();
                usuario.setId_usuario(id_usuario);
                usuario.setNombre_usuario(nombre_usuario);
                usuario.setApellido_usuario(apellido_usuario);
                usuario.setPassword_usuario(password_usuario);
                usuario.setCambio_password(cambio_contrasena);
                usuario.setUltima_conexion(ultima_conexion);
                usuario.setEstado_usuario(estado_usuario);

               rows++;           
            }
            System.out.println("Registros buscado:" + usuario);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return usuario;
    }
    
    public int delete(Usuario usuario) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, usuario.getId_usuario());
            rows = stmt.executeUpdate();
            //System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
   
     public int update(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getId_usuario());
            stmt.setString(2, usuario.getNombre_usuario());
            stmt.setString(3, usuario.getApellido_usuario());
            stmt.setString(4, usuario.getPassword_usuario());
            stmt.setInt(5, usuario.getCambio_password());
            stmt.setDate(6, usuario.getUltima_conexion());
            stmt.setInt(7, usuario.getEstado_usuario());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
     public int insert(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getId_usuario());
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
       
  
