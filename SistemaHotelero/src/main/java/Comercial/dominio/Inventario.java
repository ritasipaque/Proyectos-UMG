/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.dominio;

/**
 *
 * @author Diana
 */
public class Inventario {

    private int Id_Inventario;
    private String Nombre_Articulo;
    private String Descripcion_Articulo;
    private String Caracteristica_Articulo;
    private String Referecia_fabricante;
    private String Margen;
    private String Precio_Compra;
    private String Descuento_Compra;
    private String Descuento_Venta;
    private String Cantidad_Articulo;
    private String Caducidad_Articulo;

  
   //*****  set 
    public void setId_Inventario(int Id_Inventario) {
        this.Id_Inventario = Id_Inventario;
    }
    

    public void setNombre_Articulo(String Nombre_Articulo) {
        this.Nombre_Articulo = Nombre_Articulo;
    }

    public void setDescripcion_Articulo(String Descripcion_Articulo) {
        this.Descripcion_Articulo = Descripcion_Articulo;
    }

    public void setCaracteristica_Articulo(String Caracteristica_Articulo) {
        this.Caracteristica_Articulo = Caracteristica_Articulo;
    }

    public void setReferecia_fabricante(String Referecia_fabricante) {
        this.Referecia_fabricante = Referecia_fabricante;
    }

   

    public void setMargen(String Margen) {
        this.Margen = Margen;
    }
     public void setPrecio_Compra(String Precio_Compra) {
        this.Precio_Compra = Precio_Compra;
    }

    public void setDescuento_Compra(String Descuento_Compra) {
        this.Descuento_Compra = Descuento_Compra;
    }

    public void setDescuento_Venta(String Descuento_Venta) {
        this.Descuento_Venta = Descuento_Venta;
    }

    public void setCantidad_Articulo(String Cantidad_Articulo) {
        this.Cantidad_Articulo = Cantidad_Articulo;
    }

    public void setCaducidad_Articulo(String Caducidad_Articulo) {
        this.Caducidad_Articulo = Caducidad_Articulo;
    }

   //********* get 

    public int getId_Inventario() {
        return Id_Inventario;
    }

    public String getNombre_Articulo() {
        return Nombre_Articulo;
    }

    public String getDescripcion_Articulo() {
        return Descripcion_Articulo;
    }

    public String getCaracteristica_Articulo() {
        return Caracteristica_Articulo;
    }

    public String getReferecia_fabricante() {
        return Referecia_fabricante;
    }

   

    public String getMargen() {
        return Margen;
    }

     public String getPrecio_Compra() {
        return Precio_Compra;
    }
     
    public String getDescuento_Compra() {
        return Descuento_Compra;
    }

    public String getDescuento_Venta() {
        return Descuento_Venta;
    }

    public String getCantidad_Articulo() {
        return Cantidad_Articulo;
    }

    public String getCaducidad_Articulo() {
        return Caducidad_Articulo;
    }

     @Override
    public String toString() {
        return "Persona{" + "Id_Inventario=" + Id_Inventario + ", Nombre_Articulo=" + Nombre_Articulo 
                + ", Descripcion_Articulo=" + Descripcion_Articulo + ", Referecia_fabricante=" + Referecia_fabricante 
                + ", Margen=" + Margen  + /*Precio_Compra*/     ",Descuento_Compra= "  + Descuento_Compra 
                        + ",Descuento_Venta= "+Descuento_Venta+ ",Cantidad_Articulo=" + Cantidad_Articulo 
                + ", Caducidad_Articulo=" + Caducidad_Articulo +
                        
                '}';

    
  
}
}