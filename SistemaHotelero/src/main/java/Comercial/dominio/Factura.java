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
int Nit;  
int Teléfono; 
String producto; 
 
int Cantidad;  
int  Precio_por_unidad; 
int Monto; 
int TotalmoNto; 

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public int getNit() {
        return Nit;
    }

    public void setNit(int Nit) {
        this.Nit = Nit;
    }

    public int getTeléfono() {
        return Teléfono;
    }

    public void setTeléfono(int Teléfono) {
        this.Teléfono = Teléfono;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getPrecio_por_unidad() {
        return Precio_por_unidad;
    }

    public void setPrecio_por_unidad(int Precio_por_unidad) {
        this.Precio_por_unidad = Precio_por_unidad;
    }

    public int getMonto() {
        return Monto;
    }

    public void setMonto(int Monto) {
        this.Monto = Monto;
    }

    public int getTotalmoNto() {
        return TotalmoNto;
    }

    public void setTotalmoNto(int TotalmoNto) {
        this.TotalmoNto = TotalmoNto;
    }

   
    

    
 
   
}
