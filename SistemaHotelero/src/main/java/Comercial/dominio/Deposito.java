package Comercial.dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PERSONAL
 */
public class Deposito {
 String  Id_pedido; 
String  Cliente  ;
String Cuenta;
String Fecha_inicial;
String Fecha_final;
String Nit;
String Telefono;
String Producto;
String Detalle;
String Cantidad;

    public String getId_pedido() {
        return Id_pedido;
    }

    public void setId_pedido(String Id_pedido) {
        this.Id_pedido = Id_pedido;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getCuenta() {
        return Cuenta;
    }

    public void setCuenta(String Cuenta) {
        this.Cuenta = Cuenta;
    }

    public String getFecha_inicial() {
        return Fecha_inicial;
    }

    public void setFecha_inicial(String Fecha_inicial) {
        this.Fecha_inicial = Fecha_inicial;
    }

    public String getFecha_final() {
        return Fecha_final;
    }

    public void setFecha_final(String Fecha_final) {
        this.Fecha_final = Fecha_final;
    }

    public String getNit() {
        return Nit;
    }

    public void setNit(String Nit) {
        this.Nit = Nit;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

    @Override
    public String toString() {
        return "Deposito{" + "Id_pedido=" + Id_pedido + ", Cliente=" + Cliente + ", Cuenta=" + Cuenta + ", Fecha_inicial=" + Fecha_inicial + ", Fecha_final=" + Fecha_final + ", Nit=" + Nit + ", Telefono=" + Telefono + ", Producto=" + Producto + ", Detalle=" + Detalle + ", Cantidad=" + Cantidad + '}';
    }

    


    
}
