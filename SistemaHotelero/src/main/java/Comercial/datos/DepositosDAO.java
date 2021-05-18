package Comercial.datos;


import Comercial.dominio.Cliente;
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
    
       private static final String SQL_INSERT = "INSERT INTO depositos(Id_pedido,Cliente,cuenta ,Fecha_inicial,Fecha_final,Nit,telefono,producto ,Detalle, Cantidad) VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT Id_pedido,Cliente,cuenta ,Fecha_inicial ,Fecha_final ,Nit,telefono,producto ,Detalle, Cantidad FROM depositos";
    private static final String SQL_QUERY3 = "SELECT Id_pedido,Cliente,cuenta ,Fecha_inicial ,Fecha_final,Nit,telefono,producto ,Detalle, Cantidad FROM depositos WHERE Id_pedido = ?";
  private static final String SQL_UPDATE = "UPDATE depositos  SET Id_pedido = ? ,Cliente = ? ,cuenta = ? ,Fecha_inicial = ?,Fecha_final = ? ,Nit = ?,telefono = ?,producto = ? , Detalle = ?, Cantidad = ? WHERE Id_pedido";
    private static final String SQL_DELETE = "DELETE FROM depositos WHERE Id_pedido =?";
   private static final String SQL_UPDATE1 = "UPDATE depositos SET  Cliente= ? ,cuenta= ?  ,Fecha_inicial= ? ,Fecha_final= ? ,Nit= ? ,telefono= ? ,producto = ? ,Detalle= ? , Cantidad = ?  WHERE Id_pedido" ;
     public  List<Deposito>  select() {
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
                String id_pedido  = rs.getString("Id_pedido");
                String cliente  = rs.getString("Cliente");
                     String cuenta  = rs.getString("Cuenta");
                         String fecha_inicial  = rs.getString("Fecha_inicial");
                             String fecha_final = rs.getString("Fecha_final");
                                String nit = rs.getString("Nit");
               
                  String   telefono = rs.getString("telefono");
                     String  producto = rs.getString("producto");
                  
                  
                  String detalle  = rs.getString("Detalle");
                  String  cantidad = rs.getString("Cantidad");
             

                /**
                 *
                 * concatenacionde de variables de de busqueda
                 */
              

                  venta = new Deposito();
                  venta.setCliente(cliente);
                    venta.setId_pedido(id_pedido);
                     venta.setCuenta(cuenta);
                      venta.setFecha_inicial(fecha_inicial);
                       venta.setFecha_final(fecha_final);
                     venta.setNit(nit);
                      venta.setTelefono(telefono);
                       venta.setProducto(producto);
                    venta.setDetalle(detalle);
                    venta.setCantidad(cantidad);
                   

                    ventas.add(venta);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);

            Conexion.close(conn);
        }
         
return ventas ;

    }
   public   Deposito query3(Deposito venta){
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
            System.out.println("Ejecutando query:" + SQL_QUERY3);
            stmt = conn.prepareStatement(SQL_QUERY3);
             stmt.setString(1, venta.getId_pedido());
             
          
            rs = stmt.executeQuery();
            while (rs.next()) {
              
                 String id_pedido  = rs.getString("Id_pedido");
                String cliente  = rs.getString("Cliente");
                     String cuenta  = rs.getString("Cuenta");
                         String fecha_inicial  = rs.getString("Fecha_inicial");
                             String fecha_final = rs.getString("Fecha_final");
                                String nit = rs.getString("Nit");
               
                  String   telefono = rs.getString("telefono");
                     String  producto = rs.getString("producto");
                  
                  
                  String detalle  = rs.getString("Detalle");
                  String  cantidad = rs.getString("Cantidad");
             

                /**
                 *
                 * concatenacionde de variables de de busqueda
                 */
              

                  venta = new Deposito();
                  venta.setCliente(cliente);
                    venta.setId_pedido(id_pedido);
                     venta.setCuenta(cuenta);
                      venta.setFecha_inicial(fecha_inicial);
                       venta.setFecha_final(fecha_final);
                     venta.setNit(nit);
                      venta.setTelefono(telefono);
                       venta.setProducto(producto);
                    venta.setDetalle(detalle);
                    venta.setCantidad(cantidad);
                   

                    ventas.add(venta);
                /**
                 *
                 * busqueda de datos de la bitacocora en la de usuarios
                 */
                
               
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
           
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
            stmt.setString(1,  insertar.getId_pedido());
            stmt.setString(2,  insertar.getCliente());       
            stmt.setString(3,   insertar.getCuenta());
               stmt.setString(4,   insertar.getFecha_inicial());
                  stmt.setString(5,   insertar.getFecha_final());
                     stmt.setString(6,   insertar.getNit());
                        stmt.setString(7,   insertar.getTelefono());
                          stmt.setString(8,   insertar.getProducto());
                     stmt.setString(9,  insertar.getDetalle());
                stmt.setString(10,  insertar.getCantidad());
       

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
     
    public int update(Deposito mod) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
        stmt.setString(1,  mod.getId_pedido());
            stmt.setString(2,   mod.getCliente());       
            stmt.setString(3,    mod.getCuenta());
               stmt.setString(4,    mod.getFecha_inicial());
                  stmt.setString(5,    mod.getFecha_final());
                     stmt.setString(6,    mod.getNit());
                        stmt.setString(7,   mod.getTelefono());
                          stmt.setString(8,    mod.getProducto());
                     stmt.setString(9,   mod.getDetalle());
                stmt.setString(9,   mod.getCantidad());
            rows = stmt.executeUpdate();
           
   rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
             System.out.println("Registros buscado:" + mod);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
         
           
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
            stmt.setString(1,  insertar.getId_pedido());
//            stmt.setString(2,  insertar.getCliente());
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
    
      public int update1(Deposito lol) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
             
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE1);
         
            stmt.setString(1,  lol.getCliente());       
            stmt.setString(2,   lol.getCuenta());
               stmt.setString(3,   lol.getFecha_inicial());
                  stmt.setString(4,   lol.getFecha_final());
                     stmt.setString(5,   lol.getNit());
                        stmt.setString(6,   lol.getTelefono());
                          stmt.setString(7,   lol.getProducto());
                     stmt.setString(8, lol.getDetalle());
                stmt.setString(9,  lol.getCantidad());
       

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
      
      
      
      
      
      
}
