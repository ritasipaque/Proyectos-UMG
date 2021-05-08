/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hoteleria.datos;

import Hoteleria.dominio.ObjetoPerdido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leelu
 */
public class ObjetosPerdidosDAO {
    private static final String SQL_INSERT = "insert into tbl_objetosperdidos values(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_objetosperdidos SET Pk_id_habitacion=?,Pk_id_ama_de_llaves=?, fecha_encontrado=?, objeto=? WHERE PK_id_objeto=?";
    private static final String SQL_SELECT = "SELECT Pk_id_objeto, PK_id_habitacion, Pk_id_ama_de_llaves, fecha_encontrado, objeto FROM tbl_objetosperdidos";
    private static final String SQL_QUERY = "SELECT Pk_id_objeto, PK_id_habitacion, Pk_id_ama_de_llaves, fecha_encontrado, objeto FROM tbl_objetosperdidos WHERE PK_id_objeto = ?";
    private static final String SQL_DELETE = "delete from tbl_objetosperdidos where PK_id_objeto = ?";
    
    public int insert(ObjetoPerdido huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ConexionHoteleria.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, huespedes.getIdObjeto());
            stmt.setString(2, huespedes.getHabitacion());
            stmt.setString(3, huespedes.getAma());
            stmt.setString(4, huespedes.getFecha());
            stmt.setString(5, huespedes.getObjeto());
           

            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConexionHoteleria.close(stmt);
            ConexionHoteleria.close(conn);
        }

        return rows;
    }
    
    public int update(ObjetoPerdido huespedes){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = ConexionHoteleria.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(5, huespedes.getIdObjeto());
            stmt.setString(1, huespedes.getHabitacion());
            stmt.setString(2, huespedes.getAma());
            stmt.setString(3, huespedes.getFecha());
            stmt.setString(4, huespedes.getObjeto());

            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ConexionHoteleria.close(stmt);
            ConexionHoteleria.close(conn);
        }
        
        return rows;
    }
    
    public List<ObjetoPerdido> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ObjetoPerdido huespedes = null;
        List<ObjetoPerdido> metodo = new ArrayList<ObjetoPerdido>();
        
        try {
            conn = ConexionHoteleria.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                String idobjeto = rs.getString("PK_id_Objeto");
                String habitacion = rs.getString("PK_id_habitacion");
                String ama = rs.getString("PK_id_ama_de_llaves");
                String fecha = rs.getString("fecha_Encontrado");
                String objeto = rs.getString("objeto");
                
                
                huespedes = new ObjetoPerdido();
                huespedes.setIdObjeto(idobjeto);
                huespedes.setHabitacion(habitacion);
                huespedes.setAma(ama);
                huespedes.setFecha(fecha);
                huespedes.setObjeto(objeto);
                
                
                metodo.add(huespedes);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ConexionHoteleria.close(rs);
            ConexionHoteleria.close(stmt);
            ConexionHoteleria.close(conn);
        }
        
        return metodo;
    }
    
    public ObjetoPerdido query(ObjetoPerdido huespedes) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = ConexionHoteleria.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, huespedes.getIdObjeto());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idobjeto = rs.getString("PK_id_Objeto");
                String habitacion = rs.getString("PK_id_habitacion");
                String ama = rs.getString("PK_id_ama_de_llaves");
                String fecha = rs.getString("fecha_Encontrado");
                String objeto = rs.getString("objeto");
                
                
                huespedes = new ObjetoPerdido();
                huespedes.setIdObjeto(idobjeto);
                huespedes.setHabitacion(habitacion);
                huespedes.setAma(ama);
                huespedes.setFecha(fecha);
                huespedes.setObjeto(objeto);
                System.out.println(huespedes.getHabitacion());
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConexionHoteleria.close(rs);
            ConexionHoteleria.close(stmt);
            ConexionHoteleria.close(conn);
        }
        return huespedes;
    }
    
    public int delete(ObjetoPerdido modulos){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ConexionHoteleria.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, modulos.getIdObjeto());
            rows = stmt.executeUpdate();
            System.out.println("Objeto eliminado:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConexionHoteleria.close(stmt);
            ConexionHoteleria.close(conn);
        }

        return rows;
    }
    
}
