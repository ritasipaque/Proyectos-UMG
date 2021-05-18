/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hoteleria.dominio;

/**
 *
 * @author gegmo
 */
public class EntregaHabitaciones {
    private String Pk_id_entrega,No_factura,pk_id_habitaciones,Nombre,No_reserva,fecha,estado;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    

    public String getPk_id_entrega() {
        return Pk_id_entrega;
    }

    public void setPk_id_entrega(String Pk_id_entrega) {
        this.Pk_id_entrega = Pk_id_entrega;
    }

    public String getNo_factura() {
        return No_factura;
    }

    public void setNo_factura(String No_factura) {
        this.No_factura = No_factura;
    }

    public String getPk_id_habitaciones() {
        return pk_id_habitaciones;
    }

    public void setPk_id_habitaciones(String pk_id_habitaciones) {
        this.pk_id_habitaciones = pk_id_habitaciones;
    }

    public String getNo_reserva() {
        return No_reserva;
    }

    public void setNo_reserva(String No_reserva) {
        this.No_reserva = No_reserva;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
