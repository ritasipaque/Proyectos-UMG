package Hoteleria.datos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Hoteleria.datos.ConexionHoteleria;
import Hoteleria.dominio.Reservacion;
import Hoteleria.vista.ReservaDeHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leone
 */
public class ReservacionDAO {
    public static String id, entrada, salida;
    private static final String SQL_INSERT = "insert into tbl_reservaciones values(?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT * FROM tbl_reservaciones";
    private static final String SQL_QUERY = "SELECT PK_id_reservacion, PK_DPI, PK_id_habitacion, fecha_reserva, desde, hasta, precio, estado FROM tbl_reservaciones WHERE PK_id_reservacion = ?";
    
    
    public List<Reservacion> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Reservacion reservacion = null;
        List<Reservacion> reservar = new ArrayList<Reservacion>();
        
        try {
            conn = ConexionHoteleria.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                String id_reservacion = rs.getString("PK_id_reservacion");
                String dpi = rs.getString("PK_DPI");
                String id_habitacion = rs.getString("PK_id_habitacion");
                String f_reserva = rs.getString("fecha_reserva");
                String desde = rs.getString("desde");
                String hasta = rs.getString("hasta");
                String precio = rs.getString("precio");
                String estado = rs.getString("estado");
                
                reservacion = new Reservacion();
                reservacion.setId_reservacion(id_reservacion);
                reservacion.setDpi(dpi);
                reservacion.setId_habitacion(id_habitacion);
                reservacion.setF_reserva(f_reserva);
                reservacion.setDesde(desde);
                reservacion.setHasta(hasta);
                reservacion.setPrecio(precio);
                reservacion.setEstado(estado);
                reservar.add(reservacion);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ConexionHoteleria.close(rs);
            ConexionHoteleria.close(stmt);
            ConexionHoteleria.close(conn);
        }
        
        return reservar;
    }
    public List<Reservacion> select2(){
        String SQL_SELECT2="SELECT * FROM tbl_reservaciones WHERE (PK_id_reservacion) AND (desde BETWEEN '"+entrada+"' AND '"+salida+"') or (hasta between '"+entrada+"' AND '"+salida+"') AND (estado BETWEEN '1' AND '2')";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Reservacion reservacion = null;
        List<Reservacion> reservar = new ArrayList<Reservacion>();
        reservacion = new Reservacion();
        try {
            conn = ConexionHoteleria.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT2);
            rs = stmt.executeQuery();
            while(rs.next()){
                String id_reservacion = rs.getString("PK_id_reservacion");
                String dpi = rs.getString("PK_DPI");
                String id_habitacion = rs.getString("PK_id_habitacion");
                String f_reserva = rs.getString("fecha_reserva");
                String desde = rs.getString("desde");
                String hasta = rs.getString("hasta");
                String precio = rs.getString("precio");
                String estado = rs.getString("estado");
                reservacion.setId_reservacion(id_reservacion);
                reservacion.setDpi(dpi);
                reservacion.setId_habitacion(id_habitacion);
                reservacion.setF_reserva(f_reserva);
                reservacion.setDesde(desde);
                reservacion.setHasta(hasta);
                reservacion.setPrecio(precio);
                reservacion.setEstado(estado);
                reservar.add(reservacion);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ConexionHoteleria.close(rs);
            ConexionHoteleria.close(stmt);
            ConexionHoteleria.close(conn);
        }
        
        return reservar;
    }
    
    public Reservacion query(Reservacion reserva) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = ConexionHoteleria.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, reserva.getId_reservacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id_reserva = rs.getString("PK_id_reservacion");
                String dpi = rs.getString("PK_DPI");
                String habitacion = rs.getString("PK_id_habitacion");
                String fecha = rs.getString("fecha_reserva");
                String desde = rs.getString("desde");
                String hasta = rs.getString("hasta");
                String precio = rs.getString("precio");
                String estado = rs.getString("estado");

                reserva = new Reservacion();
                reserva.setId_reservacion(id_reserva);
                reserva.setDpi(dpi);
                reserva.setId_habitacion(habitacion);
                reserva.setF_reserva(fecha);
                reserva.setDesde(desde);
                reserva.setHasta(hasta);
                reserva.setPrecio(precio);
                reserva.setEstado(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConexionHoteleria.close(rs);
            ConexionHoteleria.close(stmt);
            ConexionHoteleria.close(conn);
        }
        return reserva;
    }
    
    public int insert(Reservacion reserva) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ConexionHoteleria.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, reserva.getId_reservacion());
            stmt.setString(2, reserva.getDpi());
            stmt.setString(3, reserva.getId_habitacion());
            stmt.setString(4, reserva.getF_reserva());
            stmt.setString(5, reserva.getDesde());
            stmt.setString(6, reserva.getHasta());
            stmt.setString(7, reserva.getPrecio());
            stmt.setString(8, reserva.getEstado());
           

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
}
