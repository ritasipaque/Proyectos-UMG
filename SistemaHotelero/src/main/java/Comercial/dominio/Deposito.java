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
  int  Id_cliente; 
String  Cliente  ;
float  Monto ;
String  Estatus; 
int Id_producto;
String Detalle;
Float Cantidad;
float Precio_por_unidad ;

   
    public int getId_cliente() {
        return Id_cliente;
    }

    public void setId_cliente(int Id_cliente) {
        this.Id_cliente = Id_cliente;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public float getMonto() {
        return Monto;
    }

    public void setMonto(float Monto) {
        this.Monto = Monto;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String Estatus) {
        this.Estatus = Estatus;
    }

    public int getId_producto() {
        return Id_producto;
    }

    public void setId_producto(int Id_producto) {
        this.Id_producto = Id_producto;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public Float getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Float Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getPrecio_por_unidad() {
        return Precio_por_unidad;
    }

    public void setPrecio_por_unidad(float Precio_por_unidad) {
        this.Precio_por_unidad = Precio_por_unidad;
    }

    @Override
    public String toString() {
        return "Deposito{" + "Id_cliente=" + Id_cliente + ", Cliente=" + Cliente + ", Monto=" + Monto + ", Estatus=" + Estatus + ", Id_producto=" + Id_producto + ", Detalle=" + Detalle + ", Cantidad=" + Cantidad + ", Precio_por_unidad=" + Precio_por_unidad + '}';
    }

   

    
}
