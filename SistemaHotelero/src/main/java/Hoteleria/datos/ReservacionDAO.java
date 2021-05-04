package Hoteleria.datos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Hoteleria.datos.ConexionHoteleria;
import Hoteleria.dominio.Reservacion;
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
    private static final String SQL_SELECT = "SELECT PK_id_reservacion, PK_DPI, PK_id_trabajado, PK_id_habitacion, fecha_reserva, desde, hasta FROM tbl_reservaciones";
    
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
                String id_trabajador = rs.getString("PK_id_trabajado");
                String id_habitacion = rs.getString("PK_id_habitacion");
                String f_reserva = rs.getString("fecha_reserva");
                String desde = rs.getString("desde");
                String hasta = rs.getString("hasta");
                
                reservacion = new Reservacion();
                reservacion.setId_reservacion(id_reservacion);
                reservacion.setDpi(dpi);
                reservacion.setId_trabajador(id_trabajador);
                reservacion.setId_habitacion(id_habitacion);
                reservacion.setF_reserva(f_reserva);
                reservacion.setDesde(desde);
                reservacion.setHasta(hasta);
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
}
