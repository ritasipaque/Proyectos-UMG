/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.datos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author visitante
 */
public class UsuarioDAO {
    private static final String SQL_SELECT = "SELECT PK_id_usuario, nombre_usuario, apellido_usuarios, password_usuario, cambio_contrasena, ultima_conexion, estado_usuario FROM tbl_usuario";
    private static final String SQL_INSERT = "INSERT INTO tbl_usuario(nombre_usuario, apellido_usuarios, password_usuario, cambio_contrasena, ultima_conexion, estado_usuario) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_usuario SET nombre_usuario=?, apellido_usuarios=?, password_usuario=?, cambio_contrasena=?, ultima_conexion=?, estado_usuario=? WHERE PK_id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_usuario WHERE PK_id_usuario=?";
    private static final String SQL_QUERY = "SELECT PK_id_usuario, nombre_usuario, apellido_usuarios, password_usuario, cambio_contrasena, ultima_conexion, estado_usuario FROM tbl_usuario WHERE PK_id_usuario = ?";
    
    public List<Usuario> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                
                int id_usuario = rs.getInt("PK_id_usuario");
                String nombre_usuario = rs.getString("nombre_usuario");
                String apellido_usuario = rs.getString("apellido_usuarios");
                String password_usuario = rs.getString("password_usuario");
                int cambio_password = rs.getInt("cambio_contrasena");
                int estado_usuario = rs.getInt("estado_usuario");
                
                usuario = new Usuario();
                usuario.setId_usuario(id_usuario);
                usuario.setNombre_usuario(nombre_usuario);
                usuario.setApellido_usuario(apellido_usuario);
                usuario.setPassword_usuario(password_usuario);
                usuario.setCambio_password(cambio_password);
                usuario.setEstado_usuario(estado_usuario);
                
                usuarios.add(usuario);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return usuarios;
    }
    
    public int insert(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getNombre_usuario());
            stmt.setString(2, usuario.getApellido_usuario());
            stmt.setString(3, usuario.getPassword_usuario());
            stmt.setInt(4, usuario.getCambio_password());
            stmt.setInt(5, usuario.getEstado_usuario());
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    public int update(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getNombre_usuario());
            stmt.setString(2, usuario.getPassword_usuario());
            stmt.setInt(3, usuario.getId_usuario());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    public int delete(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getId_usuario());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
        }
        
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
  public int query(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        int rows = 0;
         try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getId_usuario());
            rs = stmt.executeQuery();
            while(rs.next()){
                int id_usuario = rs.getInt("PK_id_usuario");
                String nombre_usuario = rs.getString("nombre_usuario");
                String apellido_usuario = rs.getString("apellido_usuarios");
                String password_usuario = rs.getString("password_usuario");
                int cambio_password = rs.getInt("cambio_contrasena");
                int estado_usuario = rs.getInt("estado_usuario");

                
                usuario = new Usuario();
                usuario.setId_usuario(id_usuario);
                usuario.setNombre_usuario(nombre_usuario);
                usuario.setApellido_usuario(apellido_usuario);
                usuario.setPassword_usuario(password_usuario);
                usuario.setCambio_password(cambio_password);
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
        
        return rows;
    }
    
   
}
