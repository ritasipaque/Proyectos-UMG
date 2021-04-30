package seguridad.vista;

import Finanzas.vista.*;
import Comercial.vista.*;
import Hoteleria.vista.*;
import java.net.UnknownHostException;
import seguridad.dominio.Permisos;

/**
 *
 * @author Diego Vásquez
 */
public class GenerarPermisos {
 
    Permisos ejecutarPermisos = new Permisos();

    public void getPermisos(String modulo, String usuario) {
        try {
            if (modulo == "Seguridad") {

                MDI_Sistema.JMenu_Mantenimientos.setVisible(false);
                MDI_Sistema.JMenuItem_Usuarios.setVisible(false);
                MDI_Sistema.JMenuItem_Aplicaciones.setVisible(false);
                MDI_Sistema.JMenu_Asignaciones.setVisible(false);
                MDI_Sistema.JMenuItem_Perfiles.setVisible(false);
                MDI_Sistema.JMenuItem_Modulos.setVisible(false);
                MDI_Sistema.JMenuItem_AplicacionesUsuario.setVisible(false);
                MDI_Sistema.JMenuItem_Bitacora.setVisible(false);

                ejecutarPermisos.ejecutarBusqueda(usuario);

                for (int i = 0; i < ejecutarPermisos.getAplicaciones().length; i++) {
                    int varApp = Integer.parseInt(ejecutarPermisos.getAplicaciones()[i]);
                    if (varApp >= 10 && varApp <= 99) {
                        MDI_Sistema.JMenu_Mantenimientos.setVisible(true);
                        switch (varApp) {
                            case 10:
                                MDI_Sistema.JMenuItem_Usuarios.setVisible(true);
                                break;
                            case 20:
                                break;
                        }
                    }
                    if (varApp >= 100 && varApp <= 199) {
                        MDI_Sistema.JMenu_Asignaciones.setVisible(true);
                        switch (varApp) {
                            case 100:
                                break;
                            case 200:
                                break;
                        }
                    }

                }
            }
            if (modulo == "Financiero") {

            }
            if (modulo == "Hotelero") {
                MDIHoteleria.menu_archivo.setVisible(false);
                MDIHoteleria.menu_ayuda.setVisible(false);
                MDIHoteleria.menu_catalogos.setVisible(false);
                MDIHoteleria.menu_herramientas.setVisible(false);
                MDIHoteleria.menu_informes.setVisible(false);
                MDIHoteleria.menu_procesos.setVisible(false);
                MDIHoteleria.jMenu1.setVisible(true);
                ejecutarPermisos.ejecutarBusqueda(usuario);
                System.out.println(usuario);
                for (int i = 0; i < ejecutarPermisos.getAplicaciones().length; i++) {
                    int varApp = Integer.parseInt(ejecutarPermisos.getAplicaciones()[i]);System.out.println(varApp);
                    if (varApp >= 2001 && varApp <= 2200) {
                        MDIHoteleria.menu_catalogos.setVisible(true);
                        switch (varApp) {
                            case 2001:
                            case 2100:
                            case 2200:
                                MDIHoteleria.submenu_mantenimientos.setVisible(true);
                                break;
                        }
                    }
                    if (varApp >= 2201 && varApp <= 2400) {
                        MDIHoteleria.menu_procesos.setVisible(true);
                        switch (varApp) {
                            case 2201:
                            case 2300:
                            case 2400:
                                MDIHoteleria.submenu_procesos.setVisible(true);
                                break;
                        }
                    }
                }
            }
            if (modulo == "Comercial") {

            }
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
    }

    public String[] getAccionesAplicacion(int codigoAplicacion, String usuario) {
        ejecutarPermisos.ejecutarBusqueda(usuario);
        String[] matrixPermisos = new String[5];
        for (int i = 0; i < 5; i++) {
            matrixPermisos[i] = ejecutarPermisos.getPermisosApps(codigoAplicacion)[i];
        }
        return matrixPermisos;
    }
}
