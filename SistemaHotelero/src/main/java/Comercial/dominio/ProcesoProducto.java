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
public class ProcesoProducto {
    
    private int PK_id_procesoproducto;
    private String nombre_producto;
    private String nombre_bodega;
    private String existencias_producto;

    public int getPK_id_procesoproducto() {
        return PK_id_procesoproducto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public String getNombre_bodega() {
        return nombre_bodega;
    }

    public String getExistencias_producto() {
        return existencias_producto;
    }

    public void setPK_id_procesoproducto(int PK_id_procesoproducto) {
        this.PK_id_procesoproducto = PK_id_procesoproducto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public void setNombre_bodega(String nombre_bodega) {
        this.nombre_bodega = nombre_bodega;
    }

    public void setExistencias_producto(String existencias_producto) {
        this.existencias_producto = existencias_producto;
    }
//    
//     @Override
//    public String toString() {
//        return "Producto{" + "PK_id_producto=" + PK_id_producto + 
//                ", nombre_producto=" + nombre_producto + 
//                ", precio_producto=" + precio_producto +
//                ", descripcion_producto=" + descripcion_producto + 
//                ", estatus_producto=" + estatus_producto + '}';
//  }
    
}
