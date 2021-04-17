/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;

import Comercial.dominio.Inventario;
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
public class InventarioDAO {
// NO FUNCIONA EL BOTON MODIFICAR 
    
    //Buscar en la BD
     private static final String SQL_SELECT = "SELECT PK_id_articulo, nombre_articulo, caracteristicas_articulo, referencia_fabricante, precio_compra, margen, descuento_compra, decuento_venta, cantidad_articulo,caducidad_articulo FROM tbl_inventario";
    //Insertar en la BD
     private static final String SQL_INSERT = "INSERT INTO tbl_inventario (PK_id_articulo, nombre_articulo, caracteristicas_articulo, referencia_fabricante, precio_compra, margen, descuento_compra, decuento_venta, cantidad_articulo,caducidad_articulo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    //Modificar la BD
     private static final String SQL_UPDATE = "UPDATE tbl_inventario SET nombre_articulo=?, caracteristicas_articulo=?, referencia_fabricante=?, precio_compra=?, margen=?, descuento_compra=?, decuento_venta=?, cantidad_articulo=?, caducidad_articulo=? WHERE PK_id_articulo = ?";
    //Eliminar de la BD
      private static final String SQL_DELETE = "DELETE FROM tbl_inventario WHERE PK_id_articulo=?";
    //Buscar 2 en la BD
    public static final String SQL_QUERY = "SELECT PK_id_articulo, nombre_articulo, caracteristicas_articulo, referencia_fabricante, precio_compra,margen,descuento_compra, decuento_venta, cantidad_articulo, caducidad_articulo FROM tbl_inventario WHERE PK_id_articulo = ?";
    //Buscar 2 en la BD
    public static final String SQL_QUERY2 = "SELECT PK_id_Modulo FROM tbl_modulo";

    public List<Inventario> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Inventario inventario = null;
        List<Inventario> inventarios = new ArrayList<Inventario>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_Inventario = rs.getInt("PK_id_articulo");
                String Nombre_Articulo = rs.getString("nombre_articulo");
                String Caracteristica_Articulo = rs.getString("caracteristicas_articulo");
                String Referecia_fabricante = rs.getString("referencia_fabricante");
                String Precio_Compra = rs.getString("precio_compra");
                String Margen = rs.getString("margen");
                String Descuento_Compra = rs.getString("descuento_compra");
                String Descuento_Venta = rs.getString("decuento_venta");
                String Cantidad_Articulo = rs.getString("cantidad_articulo");
                String Caducidad_Articulo = rs.getString("caducidad_articulo");

                inventario = new Inventario();
                inventario.setId_Inventario(id_Inventario);
                inventario.setNombre_Articulo(Nombre_Articulo);
                inventario.setCaracteristica_Articulo(Caracteristica_Articulo);
                inventario.setReferecia_fabricante(Referecia_fabricante);
                inventario.setPrecio_Compra(Precio_Compra);
                inventario.setMargen(Margen);
                inventario.setDescuento_Compra(Descuento_Compra);
                inventario.setDescuento_Venta(Descuento_Venta);
                inventario.setCantidad_Articulo(Cantidad_Articulo);
                inventario.setCaducidad_Articulo(Caducidad_Articulo);
                inventarios.add(inventario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return inventarios;
    }

    public int insert(Inventario inventario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, inventario.getId_Inventario());
            stmt.setString(2, inventario.getNombre_Articulo());
            stmt.setString(3, inventario.getCaracteristica_Articulo());
            stmt.setString(4, inventario.getReferecia_fabricante());
            stmt.setString(5, inventario.getPrecio_Compra());
            stmt.setString(6, inventario.getMargen());
            stmt.setString(7, inventario.getDescuento_Compra());
            stmt.setString(8, inventario.getDescuento_Compra());
            stmt.setString(9, inventario.getCantidad_Articulo());
            stmt.setString(10, inventario.getCaducidad_Articulo());

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

    public int update(Inventario inventario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, inventario.getId_Inventario());
            stmt.setString(2, inventario.getNombre_Articulo());
            stmt.setString(3, inventario.getCaracteristica_Articulo());
            stmt.setString(4, inventario.getReferecia_fabricante());
            stmt.setString(5, inventario.getPrecio_Compra());
            stmt.setString(6, inventario.getMargen());
            stmt.setString(7, inventario.getDescuento_Compra());
            stmt.setString(8, inventario.getDescuento_Compra());
            stmt.setString(9, inventario.getCantidad_Articulo());
            stmt.setString(10, inventario.getCaducidad_Articulo());

            rows = stmt.executeUpdate();
            //System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Inventario inventario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, inventario.getId_Inventario());
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
    //    public List<Persona> query(Persona persona) { // Si se utiliza un ArrayList

    public Inventario query(Inventario inventario) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Inventario> inventarios = new ArrayList<Inventario>();
        int rows = 0;

        try {

            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, inventario.getId_Inventario());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_Inventario = rs.getInt("PK_id_articulo");
                String Nombre_Articulo = rs.getString("nombre_articulo");
                String Caracteristica_Articulo = rs.getString("caracteristicas_articulo");
                String Referecia_fabricante = rs.getString("referencia_fabricante");
                String Precio_Compra = rs.getString("precio_compra");
                String Margen = rs.getString("margen");
                String Descuento_Compra = rs.getString("descuento_compra");
                String Descuento_Venta = rs.getString("decuento_venta");
                String Cantidad_Articulo = rs.getString("cantidad_articulo");
                String Caducidad_Articulo = rs.getString("caducidad_articulo");

                inventario = new Inventario();
                inventario.setId_Inventario(id_Inventario);
                inventario.setNombre_Articulo(Nombre_Articulo);
                inventario.setCaracteristica_Articulo(Caracteristica_Articulo);
                inventario.setReferecia_fabricante(Referecia_fabricante);
                inventario.setPrecio_Compra(Precio_Compra);
                inventario.setMargen(Margen);
                inventario.setDescuento_Compra(Descuento_Compra);
                inventario.setDescuento_Venta(Descuento_Venta);
                inventario.setCantidad_Articulo(Cantidad_Articulo);
                inventario.setCaducidad_Articulo(Caducidad_Articulo);

                rows++;
            }
            //System.out.println("Registros buscado:" + aplicacion);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return inventario;
    }
}
