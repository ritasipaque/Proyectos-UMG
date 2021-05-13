/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;
import Comercial.dominio.Compra;
import Comercial.datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author familia Sipaque
 */
public class CompraDAO {
  private static final String SQL_SELECT = "SELECT Id_compra, Id_proveedor, Nombre_proveedor, Contacto_proveedor, Nit_proveedor, Id_producto, Nombre_producto, Precio_producto, Cantidad_producto, Total_producto FROM tbl_compra";
 private static final String SQL_INSERT = "INSERT INTO tbl_compra (Id_compra, Id_proveedor, Nombre_proveedor, Contacto_proveedor, Nit_proveedor, Id_producto, Nombre_producto, Precio_producto, Cantidad_producto, Total_producto) VALUES(?,?,?,?,?,?,?,?,?,?)";
// private static final String SQL_UPDATE = "UPDATE tbl_proveedor SET   nombre_proveedor= ?, direccion_proveedor= ?, contacto_proveedor= ?, telefono_proveedor= ?, nit_proveedor= ?,  email_proveedor= ?, estatus_proveedor= ?    WHERE PK_id_proveedor= ?";
 private static final String SQL_UPDATE = "UPDATE tbl_compra SET   Id_compra= ?, Id_proveedor= ?, Nombre_proveedor= ?, Contacto_proveedor= ?, Nit_proveedor= ?, Id_producto= ?, Nombre_producto= ?, Precio_producto= ?, Cantidad_producto= ?, Total_producto= ?  WHERE Id_compra= ?";
 private static final String SQL_QUERY = "SELECT Id_compra, Id_proveedor, Nombre_proveedor, Contacto_proveedor, Nit_proveedor, Id_producto, Nombre_producto, Precio_producto, Cantidad_producto, Total_producto FROM tbl_compra WHERE Id_compra= ?";
 private static final String SQL_DELETE = "DELETE FROM tbl_compra WHERE Id_compra=?";


public List<Compra> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Compra proveedor = null;
        List<Compra> proveedores = new ArrayList<Compra>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int Id_compra = rs.getInt("Id_compra");
                String Id_proveedor = rs.getString("Id_proveedor");
                String  Nombre_proveedor = rs.getString("Nombre_proveedor");
                String Contacto_proveedor = rs.getString("Contacto_proveedor");
                String Nit_proveedor = rs.getString("Nit_proveedor");
                String Id_producto = rs.getString("Id_producto");
                String  Nombre_producto = rs.getString("Nombre_producto");
                String  Precio_producto = rs.getString("Precio_producto");
                String  Cantidad_producto = rs.getString("Cantidad_producto");
                 String  Total_producto = rs.getString("Total_producto");
                
                   
                 
                proveedor = new Compra();
                 proveedor.setId_compra(Id_compra);
                proveedor.setId_proveedor(Id_proveedor);
                proveedor.setNombre_proveedor(Nombre_proveedor);
                proveedor.setContacto_proveedor(Contacto_proveedor);
                proveedor.setNit_proveedor(Nit_proveedor);
                proveedor.setId_producto(Id_producto);
                proveedor.setNombre_producto(Nombre_producto);
                proveedor.setPrecio_producto(Precio_producto);
                proveedor.setCantidad_producto(Cantidad_producto);
                proveedor.setTotal_producto(Total_producto);
                proveedores.add(proveedor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return proveedores;
    }

 public int insert(Compra aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, aplicacion.getId_compra());
            stmt.setString(2, aplicacion.getId_proveedor());
            stmt.setString(3, aplicacion.getNombre_proveedor());
            stmt.setString(4, aplicacion.getContacto_proveedor());
            stmt.setString(5, aplicacion.getNit_proveedor());
            stmt.setString(6, aplicacion.getId_producto());
            stmt.setString(7, aplicacion.getNombre_producto());
            stmt.setString(8, aplicacion.getPrecio_producto());
            stmt.setString(9, aplicacion.getCantidad_producto());
            stmt.setString(10, aplicacion.getTotal_producto());
             
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
 public Compra query(Compra moduloC) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, moduloC.getId_compra());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int Id_compra = rs.getInt("Id_compra");
                String Id_proveedor = rs.getString("Id_proveedor");
                String  Nombre_proveedor = rs.getString("Nombre_proveedor");
                String Contacto_proveedor = rs.getString("Contacto_proveedor");
                String Nit_proveedor = rs.getString("Nit_proveedor");
                String Id_producto = rs.getString("Id_producto");
                String  Nombre_producto = rs.getString("Nombre_producto");
                String  Precio_producto = rs.getString("Precio_producto");
                String  Cantidad_producto = rs.getString("Cantidad_producto");
                 String  Total_producto = rs.getString("Total_producto");
                
               
                
                moduloC = new Compra();
                 moduloC.setId_compra(Id_compra);
                moduloC.setId_proveedor(Id_proveedor);
                moduloC.setNombre_proveedor(Nombre_proveedor);
                moduloC.setContacto_proveedor(Contacto_proveedor);
                moduloC.setNit_proveedor(Nit_proveedor);
                moduloC.setId_producto(Id_producto);
                moduloC.setNombre_producto(Nombre_producto);
                moduloC.setPrecio_producto(Precio_producto);
                moduloC.setCantidad_producto(Cantidad_producto);
                moduloC.setTotal_producto(Total_producto);
                
                
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return moduloC;
    }

   
}
