/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.vista;

import seguridad.dominio.Permisos;

/**
 *
 * @author Diego Vásquez
 */
public class ClasePruebaSeguridad {

    public static void main(String[] args) {

        /*Permisos ejecutarPermisos = new Permisos();

        ejecutarPermisos.ejecutarBusqueda("carloscastillo1");
        

        for (int i = 0; i < ejecutarPermisos.getAplicaciones().length; i++) {
            System.out.println(ejecutarPermisos.getAplicaciones()[i]);
        }
        
        for(int i = 0; i< ejecutarPermisos.getPermisosApps(10).length; i++){
            System.out.println(ejecutarPermisos.getPermisosApps(10)[i]);
        }*/
        
        GenerarPermisos permisos = new GenerarPermisos();
        
       // permisos.
        //boolean imprimir

    }
}
