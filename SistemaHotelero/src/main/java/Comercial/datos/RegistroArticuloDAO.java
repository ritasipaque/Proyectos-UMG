/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;

import Comercial.dominio.RegistroArticulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Diana
 */
public class RegistroArticuloDAO {

    private static final String SQL_SELECT = "SELECT PK_id_articulo, fecha_ingreso, nombre_articulo, talla_articuloXS, talla_articuloS, talla_articuloM, talla_articuloL, talla_articuloXL, color_articulo, nombre_proveedor, existencia_articulo FROM tbl_articulos";
    private static final String SQL_INSERT = "INSERT INTO tbl_articulos(PK_id_articulo, fecha_ingreso, nombre_articulo, talla_articuloXS, talla_articuloS, talla_articuloM,  talla_articuloL, talla_articuloXL, color_articulo, nombre_proveedor, existencia_articulo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    //   private static final String SQL_UPDATE = "UPDATE tbl_articulos SET fecha_ingreso=?, nombre_articulo=?, talla_articuloXS=?, talla_articuloS=?, talla_articuloM=?, talla_articuloL=?, talla_articuloXL=?,  color_articulo=?, nombre_proveedor=?, existencia_articulo=?  WHERE PK_id_articulo = ?";
    private static final String SQL_UPDATE = "UPDATE tbl_articulos SET fecha_ingreso=?, nombre_articulo=?, talla_articuloXS=?, talla_articuloS=?, talla_articuloM=?, talla_articuloL=?, talla_articuloXL=?, color_articulo=?, nombre_proveedor=?, existencia_articulo=? WHERE PK_id_articulo=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_articulos WHERE PK_id_articulo=?";
    private static final String SQL_QUERY = "SELECT PK_id_articulo, fecha_ingreso, nombre_articulo, talla_articuloXS, talla_articuloS, talla_articuloM, talla_articuloL, talla_articuloXL, color_articulo, nombre_proveedor, existencia_articulo FROM tbl_articulos WHERE PK_id_articulo = ?";

    public List<RegistroArticulo> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        RegistroArticulo registoarticulo = null;
        List<RegistroArticulo> registoarticulos = new ArrayList<RegistroArticulo>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int PK_id_articulo = rs.getInt("PK_id_articulo");
                String fecha_ingreso = rs.getString("fecha_ingreso");
                String nombre_articulo = rs.getString("nombre_articulo");
                String talla_articuloXS = rs.getString("talla_articuloXS");
                String talla_articuloS = rs.getString("talla_articuloS");
                String talla_articuloM = rs.getString("talla_articuloM");
                String talla_articuloL = rs.getString("talla_articuloL");
                String talla_articuloXL = rs.getString("talla_articuloXL");
                String color_articulo = rs.getString("color_articulo");
                String nombre_proveedor = rs.getString("nombre_proveedor");
                String existencia_articulo = rs.getString("existencia_articulo");

                registoarticulo = new RegistroArticulo();
                registoarticulo.setPK_id_articulo(PK_id_articulo);
                registoarticulo.setFecha_ingreso(fecha_ingreso);
                registoarticulo.setNombre_articulo(nombre_articulo);
                registoarticulo.setTalla_articuloXS(talla_articuloXS);
                registoarticulo.setTalla_articuloS(talla_articuloS);
                registoarticulo.setTalla_articuloM(talla_articuloM);
                registoarticulo.setTalla_articuloL(talla_articuloL);
                registoarticulo.setTalla_articuloXL(talla_articuloXL);
                registoarticulo.setColor_articulo(color_articulo);
                registoarticulo.setNombre_proveedor(nombre_proveedor);
                registoarticulo.setExistencia_articulo(existencia_articulo);
                registoarticulos.add(registoarticulo);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return registoarticulos;
    }

    public int insert(RegistroArticulo registroarticulo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setInt(1, registroarticulo.getPK_id_articulo());
            stmt.setString(2, registroarticulo.getFecha_ingreso());
            stmt.setString(3, registroarticulo.getNombre_articulo());
            stmt.setString(4, registroarticulo.getTalla_articuloXS());
            stmt.setString(5, registroarticulo.getTalla_articuloS());
            stmt.setString(6, registroarticulo.getTalla_articuloM());
            stmt.setString(7, registroarticulo.getTalla_articuloL());
            stmt.setString(8, registroarticulo.getTalla_articuloXL());
            stmt.setString(9, registroarticulo.getColor_articulo());
            stmt.setString(10, registroarticulo.getNombre_proveedor());
            stmt.setString(11, registroarticulo.getExistencia_articulo());

            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public RegistroArticulo query(RegistroArticulo registroarticulo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<RegistroArticulo> registroarticulos = new ArrayList<RegistroArticulo>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, registroarticulo.getPK_id_articulo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int PK_id_articulo = rs.getInt("PK_id_articulo");
                String fecha_ingreso = rs.getString("fecha_ingreso");
                String nombre_articulo = rs.getString("nombre_articulo");
                String talla_articuloXS = rs.getString("talla_articuloXS");
                String talla_articuloS = rs.getString("talla_articuloS");
                String talla_articuloM = rs.getString("talla_articuloM");
                String talla_articuloL = rs.getString("talla_articuloL");
                String talla_articuloXL = rs.getString("talla_articuloXL");
                String color_articulo = rs.getString("color_articulo");
                String nombre_proveedor = rs.getString("nombre_proveedor");
                String existencia_articulo = rs.getString("existencia_articulo");

                registroarticulo = new RegistroArticulo();
                registroarticulo.setFecha_ingreso(fecha_ingreso);
                registroarticulo.setNombre_articulo(nombre_articulo);
                registroarticulo.setTalla_articuloXS(talla_articuloXS);
                registroarticulo.setTalla_articuloS(talla_articuloS);
                registroarticulo.setTalla_articuloM(talla_articuloM);
                registroarticulo.setTalla_articuloL(talla_articuloL);
                registroarticulo.setTalla_articuloXL(talla_articuloXL);
                registroarticulo.setColor_articulo(color_articulo);
                registroarticulo.setNombre_proveedor(nombre_proveedor);
                registroarticulo.setExistencia_articulo(existencia_articulo);

                //empleados.add(empleado); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + empleado);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
//            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return empleados;  // Si se utiliza un ArrayList
        return registroarticulo;
    }

    public int delete(RegistroArticulo registroaplicacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, registroaplicacion.getPK_id_articulo());
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

    public int update(RegistroArticulo registroarticulo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, registroarticulo.getFecha_ingreso());
            stmt.setString(2, registroarticulo.getNombre_articulo());
            stmt.setString(3, registroarticulo.getTalla_articuloXS());
            stmt.setString(4, registroarticulo.getTalla_articuloS());
            stmt.setString(5, registroarticulo.getTalla_articuloM());
            stmt.setString(6, registroarticulo.getTalla_articuloL());
            stmt.setString(7, registroarticulo.getTalla_articuloXL());
            stmt.setString(8, registroarticulo.getColor_articulo());
            stmt.setString(9, registroarticulo.getNombre_proveedor());
            stmt.setString(10, registroarticulo.getExistencia_articulo());
            stmt.setInt(11, registroarticulo.getPK_id_articulo());

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
}
