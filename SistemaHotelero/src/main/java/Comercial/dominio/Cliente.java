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
public class Cliente {
    
    
  String   Id_cliente;
  String Cliente;
String Nit;  
String Telefono;
String Producto;
String Estatus_Cliente;
String Monto;


    public String getId_cliente() {
        return Id_cliente;
    }

    public void setId_cliente(String Id_cliente) {
        this.Id_cliente = Id_cliente;
    }

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
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public String getEstatus_Cliente() {
        return Estatus_Cliente;
    }

    public void setEstatus_Cliente(String Estatus_Cliente) {
        this.Estatus_Cliente = Estatus_Cliente;
    }

    public String getMonto() {
        return Monto;
    }

    public void setMonto(String Monto) {
        this.Monto = Monto;
    }

  

    @Override
    public String toString() {
        return "Cliente{" + "Id_cliente=" + Id_cliente + ", Cliente=" + Cliente + ", Nit=" + Nit + ", Telefono=" + Telefono + ", Producto=" + Producto + ", Estatus_Cliente=" + Estatus_Cliente + '}';
    }


    
}
