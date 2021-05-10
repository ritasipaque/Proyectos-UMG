package Comercial.datos;


import Comercial.dominio.Deposito;
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


public class DepositosDAO {
    
       private static final String SQL_INSERT = "INSERT INTO   deposito (Id_cliente,Cliente,Monto,Estatus ,Id_producto ,Detalle, Cantidad ,Precio_por_unidad) VALUES(?, ?,?, ?,?, ?,?,?)";
    private static final String SQL_SELECT = "SELECT Id_cliente,Cliente,Monto,Estatus ,Id_producto ,Detalle, Cantidad ,Precio_por_unidad FROM deposito";
    private static final String SQL_QUERY = "SELECT Id_cliente,Cliente,Monto,Estatus ,Id_producto ,Detalle, Cantidad ,Precio_por_unidad FROM deposito WHERE Id_cliente = ?";
  private static final String SQL_UPDATE = "UPDATE   tbl_pedido_factura  SET Id_cliente= ?,Cliente=?,Monto=?,Estatus=? ,Id_producto=? ,Detalle=?, Cantidad=? ,Precio_por_unidad =? WHERE id_vendedor = ?";
    private static final String SQL_DELETE = "DELETE FROM depositos WHERE Id_cliente= ?,Cliente=?,Monto=?,Estatus=? ,Id_producto=? ,Detalle=?, Cantidad=? ,Precio_por_unidad =? WHERE id_vendedor = ?";
  
     public Deposito select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Deposito venta = null;
        List<Deposito> ventas = new ArrayList<Deposito>();
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
                int id_cliente  = rs.getInt("id_cliente");
                String cliente  = rs.getString("Cliente");
               
                int telefono = rs.getInt("telefono");
                  int id_producto = rs.getInt("Id_producto");
                  
                  
                  String detalle  = rs.getString("Detalle");
               float cantidad = rs.getFloat("Cantidad");
                int precio = rs.getInt("Precio_por_unidad ");
                  float monto = rs.getFloat("Totalmonto");

                /**
                 *
                 * concatenacionde de variables de de busqueda
                 */
              

                  venta = new Deposito();
                  venta.setCliente(cliente);
                    venta.setId_cliente(id_cliente);
                 
                    
                    venta.setId_producto(id_producto);
                    venta.setDetalle(detalle);
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

        return venta;
    }
     Deposito query(Deposito venta){
        /**
         *
         * conexion de base de datos
         */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Deposito> ventas = new ArrayList<Deposito>();
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
                
                int id_cliente  = rs.getInt("id_cliente");
                String cliente  = rs.getString("Cliente");
                int nit = rs.getInt("Nit");
                int telefono = rs.getInt("telefono");
                  int id_producto = rs.getInt("Id_producto");
                  
                  
                  String detalle  = rs.getString("Detalle");
                float cantidad = rs.getInt("Cantidad");
                int precio = rs.getInt("Precio_por_unidad ");
                  float monto = rs.getInt("Totalmonto");
                /**
                 *
                 * concatenacionde de variables de de busqueda
                 */
                   venta = new Deposito();
                  venta.setCliente(cliente);
                    venta.setId_cliente(id_cliente);
               
                    venta.setId_producto(id_producto);
                    venta.setDetalle(detalle);
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
     public int insert(Deposito insertar) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
             
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1,  insertar.getId_cliente());
            stmt.setString(2,  insertar.getCliente());       
            stmt.setInt(3,   insertar.getId_producto());
             stmt.setString(4,  insertar.getDetalle());
                stmt.setFloat(5,  insertar.getCantidad());
            stmt.setFloat(6,  insertar.getPrecio_por_unidad());
             stmt.setFloat(7,  insertar.getMonto());

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
     
    public int update(Deposito insertar) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
          stmt.setInt(1,  insertar.getId_cliente());
            stmt.setString(2,  insertar.getCliente());       
            stmt.setInt(3,   insertar.getId_producto());
             stmt.setString(4,  insertar.getDetalle());
                stmt.setFloat(5,  insertar.getCantidad());
            stmt.setFloat(6,  insertar.getPrecio_por_unidad());
             stmt.setFloat(7,  insertar.getMonto());
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
      public int delete(Deposito insertar) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
             
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,  insertar.getId_cliente());
            stmt.setString(2,  insertar.getCliente());
//            stmt.setInt(3,  insertar.getNit());
//            stmt.setInt(4,   insertar.getId_producto());
//             stmt.setString(5,  insertar.getDetalle());
//                stmt.setInt(6,  insertar.getCantidad());
//            stmt.setInt(7,  insertar.getPrecio_por_unidad());
//             stmt.setInt(8,  insertar.getTotalmoNto());
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
