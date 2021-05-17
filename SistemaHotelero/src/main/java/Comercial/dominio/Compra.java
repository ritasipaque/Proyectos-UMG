/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.dominio;

/**
 *
 * @author SipaqueRitaMaria
 */
public class Compra {
    int Id_compra;
String Id_proveedor;
String Nombre_proveedor;
String Contacto_proveedor;
String Nit_proveedor;
String Id_producto;
String Nombre_producto;
String Precio_producto;
String Cantidad_producto;
String Total_producto;

    public int getId_compra() {
        return Id_compra;
    }

    public void setId_compra(int Id_compra) {
        this.Id_compra = Id_compra;
    }

    public String getId_proveedor() {
        return Id_proveedor;
    }

    public void setId_proveedor(String Id_proveedor) {
        this.Id_proveedor = Id_proveedor;
    }

    public String getNombre_proveedor() {
        return Nombre_proveedor;
    }

    public void setNombre_proveedor(String Nombre_proveedor) {
        this.Nombre_proveedor = Nombre_proveedor;
    }

    public String getContacto_proveedor() {
        return Contacto_proveedor;
    }

    public void setContacto_proveedor(String Contacto_proveedor) {
        this.Contacto_proveedor = Contacto_proveedor;
    }

    public String getNit_proveedor() {
        return Nit_proveedor;
    }

    public void setNit_proveedor(String Nit_proveedor) {
        this.Nit_proveedor = Nit_proveedor;
    }

    public String getId_producto() {
        return Id_producto;
    }

    public void setId_producto(String Id_producto) {
        this.Id_producto = Id_producto;
    }

    public String getNombre_producto() {
        return Nombre_producto;
    }

    public void setNombre_producto(String Nombre_producto) {
        this.Nombre_producto = Nombre_producto;
    }

    public String getPrecio_producto() {
        return Precio_producto;
    }

    public void setPrecio_producto(String Precio_producto) {
        this.Precio_producto = Precio_producto;
    }

    public String getCantidad_producto() {
        return Cantidad_producto;
    }

    public void setCantidad_producto(String Cantidad_producto) {
        this.Cantidad_producto = Cantidad_producto;
    }

    public String getTotal_producto() {
        return Total_producto;
    }

    public void setTotal_producto(String Total_producto) {
        this.Total_producto = Total_producto;
    }

    @Override
    public String toString() {
        return "Compra{" + "Id_compra=" + Id_compra + ", Id_proveedor=" + Id_proveedor + ", Nombre_proveedor=" + Nombre_proveedor + ", Contacto_proveedor=" + Contacto_proveedor + ", Nit_proveedor=" + Nit_proveedor + ", Id_producto=" + Id_producto + ", Nombre_producto=" + Nombre_producto + ", Precio_producto=" + Precio_producto + ", Cantidad_producto=" + Cantidad_producto + ", Total_producto=" + Total_producto + '}';
    }


}
