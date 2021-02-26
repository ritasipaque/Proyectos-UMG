package seguridad.datos;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import seguridad.datos.Conexion;
import seguridad.dominio.Asignacion_Aplicacion_Perfil;

/**
 *
 * @author leelu
 */
public class Asignacion_Aplicacion_PerfilDAO {
    private static final String SQL_SELECT = "SELECT PK_id_perfil, PK_id_aplicacion, ingresar, consultar, modificar, eliminar, imprimir FROM tbl_perfil_detalle";
    private static final String SQL_INSERT = "INSERT INTO tbl_perfil_detalle(PK_id_perfil, PK_id_aplicacion) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_perfil_detalle SET PK_id_perfil=?, PK_id_aplicacion=? WHERE PK_id_aplicacion = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_perfil_detalle WHERE PK_id_aplicacion=?";
    private static final String SQL_QUERY = "SELECT PK_id_perfil, PK_id_aplicacion FROM tbl_perfil_detalle WHERE PK_id_aplicacion = ?";
    
public List<Asignacion_Aplicacion_Perfil> select2(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Asignacion_Aplicacion_Perfil a_app_usu = null;
        List<Asignacion_Aplicacion_Perfil> personas = new ArrayList<Asignacion_Aplicacion_Perfil>();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                String id_perfil = rs.getString("PK_id_perfil");
                String id_aplicacion = rs.getString("PK_id_aplicacion");
                String ingresar = rs.getString("ingresar");
                String consultar = rs.getString("consultar");
                String modificar = rs.getString("modificar");
                String eliminar = rs.getString("eliminar");
                String imprimir = rs.getString("imprimir");
                
                
                a_app_usu = new Asignacion_Aplicacion_Perfil();
                a_app_usu.setCodigo_Perfil(id_perfil);
                a_app_usu.setCodigo_Aplicacion(id_aplicacion);
                a_app_usu.setIngresar(ingresar);
                a_app_usu.setConsultar(consultar);
                a_app_usu.setModificar(modificar);
                a_app_usu.setEliminar(eliminar);
                a_app_usu.setImprimir(imprimir);
                
                
                personas.add(a_app_usu);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return personas;
    }
    
    
}
