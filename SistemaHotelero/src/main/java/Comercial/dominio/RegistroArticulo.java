/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.dominio;

import java.util.logging.Logger;

/**
 *
 * @author Diana
 */
public class RegistroArticulo {

    int PK_id_articulo;
    String fecha_ingreso;
    String nombre_articulo;
    String talla_articuloXS;
    String talla_articuloS;
    String talla_articuloM;
    String talla_articuloL;
    String talla_articuloXL;
    String color_articulo;
    String nombre_proveedor;
    String existencia_articulo;

    public int getPK_id_articulo() {
        return PK_id_articulo;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public String getNombre_articulo() {
        return nombre_articulo;
    }

    public String getTalla_articuloXS() {
        return talla_articuloXS;
    }

    public String getTalla_articuloS() {
        return talla_articuloS;
    }

    public String getTalla_articuloM() {
        return talla_articuloM;
    }

    public String getTalla_articuloL() {
        return talla_articuloL;
    }

    public String getTalla_articuloXL() {
        return talla_articuloXL;
    }

    public String getColor_articulo() {
        return color_articulo;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public String getExistencia_articulo() {
        return existencia_articulo;
    }

    public void setPK_id_articulo(int PK_id_articulo) {
        this.PK_id_articulo = PK_id_articulo;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public void setNombre_articulo(String nombre_articulo) {
        this.nombre_articulo = nombre_articulo;
    }

    public void setTalla_articuloXS(String talla_articuloXS) {
        this.talla_articuloXS = talla_articuloXS;
    }

    public void setTalla_articuloS(String talla_articuloS) {
        this.talla_articuloS = talla_articuloS;
    }

    public void setTalla_articuloM(String talla_articuloM) {
        this.talla_articuloM = talla_articuloM;
    }

    public void setTalla_articuloL(String talla_articuloL) {
        this.talla_articuloL = talla_articuloL;
    }

    public void setTalla_articuloXL(String talla_articuloXL) {
        this.talla_articuloXL = talla_articuloXL;
    }

    public void setColor_articulo(String color_articulo) {
        this.color_articulo = color_articulo;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public void setExistencia_articulo(String existencia_articulo) {
        this.existencia_articulo = existencia_articulo;
    }
    
  

    @Override
    public String toString() {
        return "Proveedor{" + "PK_id_articulo=" + PK_id_articulo + 
                ", nombre_articulo=" +  nombre_articulo + 
                ",talla_articuloXS=" + talla_articuloXS + 
                ",talla_articuloS" + talla_articuloS + 
                ",talla_articuloM" + talla_articuloM + 
                ",talla_articuloL"  + talla_articuloL + 
                ", talla_articuloXL" +talla_articuloXL+ 
                ",color_articulo="  + color_articulo +
                ", nombre_proveedor=" + nombre_proveedor + 
                ", existencia_articulo="  + existencia_articulo +
                ", fecha_ingreso=" + fecha_ingreso + '}';
    }

}
