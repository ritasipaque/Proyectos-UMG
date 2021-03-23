/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import seguridad.dominio.Asignacion_Usuario_Perfil;

/**
 *
 * @author Santiago Martinez
 */
public class Asignacion_Usuario_PerfilDAO {
    
    
    private static final String SQL_SELECT = "SELECT PK_id_usuario, PK_id_perfil FROM tbl_usuario_perfil";
    private static final String SQL_INSERT = "INSERT INTO tbl_usuario_perfil(PK_id_usuario, PK_id_perfil) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_usuario_perfil SET  PK_id_usuario=?,PK_id_perfil=? WHERE PK_id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_usuario_perfil WHERE PK_id_perfil=?";
    private static final String SQL_QUERY = "SELECT PK_id_usuario, PK_id_perfil FROM sedes WHERE tbl_usuario_perfil = ?";

    public List<Asignacion_Usuario_Perfil> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Asignacion_Usuario_Perfil usuario1 = null;
        List<Asignacion_Usuario_Perfil> usuarios = new ArrayList<Asignacion_Usuario_Perfil>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
               
                
                 String usuario = rs.getString("PK_id_usuario");
                 //int perfil  = rs.getInt("PK_id_perfil");
                 String perfil = rs.getString("PK_id_perfil");
                usuario1 = new Asignacion_Usuario_Perfil();
                usuario1.setPK_id_usuario(usuario);   
                usuario1.setPK_id_perfil(perfil);
                            
                usuarios.add(usuario1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return usuarios;
    }

    public int insert(Asignacion_Usuario_Perfil Asignacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setString(1, Asignacion.getPK_id_usuario());
            //stmt.setInt(2, Asignacion.getPK_id_perfil());
           stmt.setString(2, Asignacion.getPK_id_perfil());

           
            rows = stmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Asignacion_Usuario_Perfil Asignacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
           // stmt.setInt(1, Asignacion.getPK_id_perfil());
           stmt.setString(1, Asignacion.getPK_id_perfil());
            stmt.setString(2, Asignacion.getPK_id_usuario());
           

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Asignacion_Usuario_Perfil Asignacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
           // stmt.setInt(1, Asignacion.getPK_id_perfil());
           stmt.setString(1, Asignacion.getPK_id_perfil());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    
}
