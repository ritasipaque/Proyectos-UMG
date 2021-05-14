package Comercial.dominio;


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
public class Factura  {
    
String Cliente;  
String Nit;  
String Telefono; 
String producto; 
 
String Cantidad;  
String  Precio_por_unidad; 
String Monto; 
String TotalmoNto; 

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
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
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getPrecio_por_unidad() {
        return Precio_por_unidad;
    }

    public void setPrecio_por_unidad(String Precio_por_unidad) {
        this.Precio_por_unidad = Precio_por_unidad;
    }

    public String getMonto() {
        return Monto;
    }

    public void setMonto(String Monto) {
        this.Monto = Monto;
    }

    public String getTotalmoNto() {
        return TotalmoNto;
    }

    public void setTotalmoNto(String TotalmoNto) {
        this.TotalmoNto = TotalmoNto;
    }

    @Override
    public String toString() {
        return "Factura{" + "Cliente=" + Cliente + ", Nit=" + Nit + ", Telefono=" + Telefono + ", producto=" + producto + ", Cantidad=" + Cantidad + ", Precio_por_unidad=" + Precio_por_unidad + ", Monto=" + Monto + ", TotalmoNto=" + TotalmoNto + '}';
    }

   

    
 
   
}
