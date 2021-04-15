/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;
import Comercial.dominio.Proveedor;
import Comercial.datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author familia Sipaque
 */
public class ProveedorDAO1 {
 private static final String SQL_SELECT = "SELECT PK_id_proveedor, nombre_proveedor, direccion_proveedor, contacto_proveedor, telefono_proveedor, nit_proveedor, email_proveedor, estatus_proveedor FROM tbl_proveedor";
 private static final String SQL_INSERT = "INSERT INTO tbl_proveedor (PK_id_proveedor, nombre_proveedor, direccion_proveedor, contacto_proveedor, telefono_proveedor, nit_proveedor, email_proveedor, estatus_proveedor) VALUES(?,?,?,?,?,?,?,?)";
// private static final String SQL_UPDATE = "UPDATE tbl_proveedor SET   nombre_proveedor= ?, direccion_proveedor= ?, contacto_proveedor= ?, telefono_proveedor= ?, nit_proveedor= ?,  email_proveedor= ?, estatus_proveedor= ?    WHERE PK_id_proveedor= ?";
 private static final String SQL_UPDATE = "UPDATE tbl_proveedor SET   nombre_proveedor= ?, direccion_proveedor= ?, contacto_proveedor= ?, telefono_proveedor= ?,  nit_proveedor= ?, email_proveedor= ?,  estatus_proveedor= ?     WHERE PK_id_proveedor= ?";
 private static final String SQL_QUERY = "SELECT PK_id_proveedor, nombre_proveedor, direccion_proveedor, contacto_proveedor, telefono_proveedor, nit_proveedor, email_proveedor, estatus_proveedor FROM tbl_proveedor WHERE PK_id_proveedor= ?";
 private static final String SQL_DELETE = "DELETE FROM tbl_proveedor WHERE PK_id_proveedor=?";
  
  public List<Proveedor> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Proveedor proveedor = null;
        List<Proveedor> proveedores = new ArrayList<Proveedor>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int PK_id_proveedor = rs.getInt("PK_id_proveedor");
                String nombre_proveedor = rs.getString("nombre_proveedor");
                String direccion_proveedor = rs.getString("direccion_proveedor");
                String contacto_proveedor = rs.getString("contacto_proveedor");
                String telefono_proveedor = rs.getString("telefono_proveedor");
                String nit_proveedor = rs.getString("nit_proveedor");
                String email_proveedor = rs.getString("email_proveedor");
                String estatus_proveedor = rs.getString("estatus_proveedor");
                   
                 
                proveedor = new Proveedor();
                proveedor.setPK_id_proveedor(PK_id_proveedor);
                proveedor.setNombre_proveedor(nombre_proveedor);
                proveedor.setDireccion_proveedor(direccion_proveedor);
                proveedor.setContacto_proveedor(contacto_proveedor);
                proveedor.setTelefono_proveedor(telefono_proveedor);
                proveedor.setNit_proveedor(nit_proveedor);
                proveedor.setEmail_proveedor(email_proveedor);
                proveedor.setEstatus_proveedor(estatus_proveedor);
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
 
 
    public int insert(Proveedor aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, aplicacion.getPK_id_proveedor());
            stmt.setString(2, aplicacion.getNombre_proveedor());
            stmt.setString(3, aplicacion.getDireccion_proveedor());
            stmt.setString(4, aplicacion.getContacto_proveedor());
            stmt.setString(5, aplicacion.getTelefono_proveedor());
            stmt.setString(6, aplicacion.getNit_proveedor());
            stmt.setString(7, aplicacion.getEmail_proveedor());
            stmt.setString(8, aplicacion.getEstatus_proveedor());
             
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
    
     
    public Proveedor query(Proveedor proveedor) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Proveedor> proveedores = new ArrayList<Proveedor>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, proveedor.getPK_id_proveedor());
            rs = stmt.executeQuery();
            while (rs.next()) {
               int PK_id_proveedor= rs.getInt("PK_id_proveedor");
                String nombre_proveedor = rs.getString("nombre_proveedor");
                String direccion_proveedor= rs.getString("direccion_proveedor");
                String contacto_proveedor = rs.getString("contacto_proveedor");
                String telefono_proveedor = rs.getString("telefono_proveedor");
                String nit_proveedor = rs.getString("nit_proveedor");
                String email_proveedor = rs.getString("email_proveedor");
                String estatus_proveedor = rs.getString("estatus_proveedor");
                
                proveedor = new Proveedor();
                proveedor.setNombre_proveedor(nombre_proveedor);
                proveedor.setDireccion_proveedor(direccion_proveedor);
                proveedor.setContacto_proveedor(contacto_proveedor);
                proveedor.setTelefono_proveedor(telefono_proveedor);
                proveedor.setNit_proveedor(nit_proveedor);
                proveedor.setEmail_proveedor(email_proveedor);
                proveedor.setEstatus_proveedor(estatus_proveedor);
                
                //empleados.add(empleado); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + empleado);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return empleados;  // Si se utiliza un ArrayList
        return proveedor;
    } 
    public int delete(Proveedor aplicacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicacion.getPK_id_proveedor());
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
 public int update(Proveedor aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, aplicacion.getNombre_proveedor());
            stmt.setString(2, aplicacion.getDireccion_proveedor());
            stmt.setString(3, aplicacion.getContacto_proveedor());
            stmt.setString(4, aplicacion.getContacto_proveedor());
            stmt.setString(5, aplicacion.getTelefono_proveedor());
            stmt.setString(6, aplicacion.getNit_proveedor());
            stmt.setString(7, aplicacion.getEstatus_proveedor());
            stmt.setInt(8, aplicacion.getPK_id_proveedor());
            
            
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