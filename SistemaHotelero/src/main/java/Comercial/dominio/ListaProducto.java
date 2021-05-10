/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.dominio;

import java.util.Vector;

/**
 *
 * @author SipaqueRitaMaria
 */
public class ListaProducto {
    private static Vector datos = new Vector();

    public static void agregar(Object obj) {
        datos.addElement(obj);
    }

    public static void eliminar(int pos) {
        datos.removeElementAt(pos);
    }

    public static Vector mostrar() {
        return datos;
    }
}
