package Comercial.datos;


import Comercial.dominio.Factura;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PERSONAL
 */
public class facturaDao {
    
   private static final String SQL_INSERT = "INSERT INTO tbl_pedido_factura(Id_cliente,Cliente,Monto,producto , Cantidad ,Precio_por_unidad,telefono,Nit) VALUES(?, ?,?, ?,?, ?,?,?)";
    private static final String SQL_SELECT = "SELECT Id_cliente,Cliente,Monto,producto , Cantidad ,Precio_por_unidad,telefono FROM tbl_pedido_factura";
    private static final String SQL_QUERY = "SELECT Id_cliente,Cliente,Monto,producto , Cantidad ,Precio_por_unidad,telefonoFROM tbl_pedido_factura WHERE Id_cliente = ?";
  private static final String SQL_UPDATE = "UPDATE   tbl_pedido_factura  SET Id_cliente= ?,Cliente=?,Monto=?,Estatus=? ,Id_producto=? ,Detalle=?, Cantidad=? ,Precio_por_unidad =? WHERE id_vendedor = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_pedido_factura WHERE Id_cliente= ?";
  

    /**
     *
     * seleccion de listas de la bitacora
     */
    public List<Factura> select() {
         Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Factura venta = null;
        List<Factura> ventas = new ArrayList<Factura>();
        try {
            /**
             *
             * conecion con sql de selecccion
             */
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                /**
                 *
                 * busqueda de datos de la bitacocora en la de usuarios
                 */
                 String id_cliente  = rs.getString("id_cliente");
                String cliente  = rs.getString("Cliente");
                 String nit = rs.getString("Nit");
                String telefono = rs.getString("telefono");
                  String producto = rs.getString("producto");
                  String cantidad = rs.getString("Cantidad");
                  String  precio = rs.getString("Precio_por_unidad ");
                 String monto = rs.getString("monto");

                /**
                 *
                 * concatenacionde de variables de de busqueda
                 */
                  venta = new Factura();
                  venta.setCliente(cliente);    
                    venta.setNit(nit);
                    venta.setTelefono(telefono);
                    venta.setProducto(producto);                
                    venta.setCantidad(cantidad);
                    venta.setPrecio_por_unidad(precio);
                
                       venta.setMonto(monto);

                    ventas.add(venta);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);

            Conexion.close(conn);
        }
      return ventas;

    }

    /**
     *
     * lista de la bitacora de seleccion de datos a usuario
     */
    public Factura query(Factura venta){
        /**
         *
         * conexion de base de datos
         */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Factura> ventas = new ArrayList<Factura>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
          
            rs = stmt.executeQuery();
            while (rs.next()) {
                /**
                 *
                 * busqueda de datos de la bitacocora en la de usuarios
                 */
                
                  
                 String id_cliente  = rs.getString("id_cliente");
                String cliente  = rs.getString("Cliente");
                 String nit = rs.getString("Nit");
                String telefono = rs.getString("telefono");
                  String producto = rs.getString("producto");
                  
                  
             
                  String cantidad = rs.getString("Cantidad");
                  String  precio = rs.getString("Precio_por_unidad ");
                 
                    String monto = rs.getString("monto");

                /**
                 *
                 * concatenacionde de variables de de busqueda
                 */
                   venta = new Factura();
                 venta.setCliente(cliente);    
                    venta.setNit(nit);
                    venta.setTelefono(telefono);
                    venta.setProducto(producto);                
                    venta.setCantidad(cantidad);
                    venta.setPrecio_por_unidad(precio);
                  
                       venta.setMonto(monto);
                       ventas.add(venta);
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return venta;

    }

    public int insert(Factura insertar) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
             
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
      
            stmt.setString(1,  insertar.getCliente());
            stmt.setString(2,  insertar.getNit());
              stmt.setString(3,   insertar.getTelefono());
            stmt.setString(4,   insertar.getProducto());
                stmt.setString(5,  insertar.getCantidad());
            stmt.setString(6,  insertar.getPrecio_por_unidad());
             stmt.setString(7,  insertar.getTotalmoNto());
                 stmt.setString(8,  insertar.getMonto());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
     
    public int update(Factura insertar) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
             
            
            conn = Conexion.getConnection();
           stmt = conn.prepareStatement(SQL_UPDATE);
          
            
            stmt.setString(1,  insertar.getCliente());
            stmt.setString(2,  insertar.getNit());
              stmt.setString(3,   insertar.getTelefono());
            stmt.setString(4,   insertar.getProducto());
                stmt.setString(5,  insertar.getCantidad());
            stmt.setString(6,  insertar.getPrecio_por_unidad());
             stmt.setString(7,  insertar.getTotalmoNto());
                 stmt.setString(8,  insertar.getMonto());
            System.out.println("ejecutando query: " + SQL_UPDATE);
           
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
     public int delete(Factura insertar) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
             
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
        
          
            stmt.setString(1,  insertar.getCliente());
            stmt.setString(2,  insertar.getNit());
              stmt.setString(3,   insertar.getTelefono());
            stmt.setString(4,   insertar.getProducto());
                stmt.setString(5,  insertar.getCantidad());
            stmt.setString(6,  insertar.getPrecio_por_unidad());
             stmt.setString(7,  insertar.getTotalmoNto());
                 stmt.setString(8,  insertar.getMonto());
           System.out.println("Ejecutando query:" + SQL_DELETE);
           
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    
    
    
    
    
    
    
    
}
