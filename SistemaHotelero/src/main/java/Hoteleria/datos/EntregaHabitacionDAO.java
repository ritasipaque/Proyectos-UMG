/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hoteleria.datos;

import Hoteleria.dominio.EntregaHabitaciones;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
/**
 *
 * @author gegmo
 */
public class EntregaHabitacionDAO {

    private static final String SQL_INSERT = "INSERT INTO tbl_entrega_habitacion(PK_id_entrega, no_factura, PK_id_habitacion,nombre, no_reserva,fecha,estado) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT * FROM tbl_entrega_habitacion";
    private static final String SQL_QUERY = "SELECT PK_id_entrega, no_factura, PK_id_habitacion, nombre, no_reserva, fecha,estado FROM tbl_entrega_habitacion WHERE PK_id_entrega = ?";
    
    public List<EntregaHabitaciones> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        EntregaHabitaciones entrega = null;
        List<EntregaHabitaciones> reservar = new ArrayList<EntregaHabitaciones>();
        
        try {
            conn = ConexionHoteleria.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                String id_entrega = rs.getString("PK_id_entrega");
                String No_factura = rs.getString("no_factura");
                String id_habitacion = rs.getString("PK_id_habitacion");
                String Nombre = rs.getString("nombre");
                String no_reserva = rs.getString("no_reserva");
                String fecha = rs.getString("fecha");
                String estado = rs.getString("estado");
                
                entrega = new EntregaHabitaciones();
                entrega.setPk_id_entrega(id_entrega);
                entrega.setNo_factura(No_factura);
                entrega.setPk_id_habitaciones(id_habitacion);
                entrega.setNombre(Nombre);
                entrega.setNo_reserva(no_reserva);
                entrega.setFecha(fecha);
                entrega.setEstado(estado);
                
                reservar.add(entrega);
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
    public int insert(EntregaHabitaciones entrega) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ConexionHoteleria.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1,entrega.getPk_id_entrega());
            stmt.setString(2,entrega.getNo_factura());
            stmt.setString(3,entrega.getPk_id_habitaciones());
            stmt.setString(4,entrega.getNo_reserva());
            stmt.setString(5,entrega.getFecha());
            stmt.setString(6,entrega.getEstado());
            
    //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConexionHoteleria.close(stmt);
            ConexionHoteleria.close(conn);
        }

        return rows;
    }
    public EntregaHabitaciones query(EntregaHabitaciones habitaciones) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int rows = 0;

        try {

            conn = ConexionHoteleria.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, habitaciones.getPk_id_entrega());
            rs = stmt.executeQuery();

            while (rs.next()) {
                String id_habitacion = rs.getString("Pk_id_entrega");
                String no_facaruta = rs.getString("no_factura");
                String id_habitaciones = rs.getString("PK_id_habitacion");
                String nombre = rs.getString("nombre");
                String no_reserva = rs.getString("no_reserva");
                String fecha = rs.getString("fecha");
                String estado = rs.getString("estado");

                habitaciones = new EntregaHabitaciones();
                habitaciones.setPk_id_entrega(id_habitacion);
                habitaciones.setNo_factura(no_facaruta);
                habitaciones.setPk_id_habitaciones(id_habitaciones);
                habitaciones.setNombre(nombre);
                habitaciones.setNo_reserva(no_reserva);
                habitaciones.setFecha(fecha);
                habitaciones.setEstado(estado);
                rows++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConexionHoteleria.close(rs);
            ConexionHoteleria.close(stmt);
            ConexionHoteleria.close(conn);

        }
        return (habitaciones);
    }
}
            

