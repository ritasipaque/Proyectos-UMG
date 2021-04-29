/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hoteleria.vista;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 *
 * @author leone
 */
public class LoginMDI {
    
    public static String getIp() throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        return address.getHostAddress();
    }
    
    public static void validarids(int vid) throws UnknownHostException{
        MDIHoteleria MDI = new MDIHoteleria();
        MDIHoteleria.submenu_mantenimientos.setVisible(false);
        MDIHoteleria.submenu_procesos.setVisible(false);
        MDIHoteleria.mnt_amadellaves.setVisible(false);
        MDIHoteleria.mnt_formasdepago.setVisible(false);
        MDIHoteleria.mnt_habitaciones.setVisible(false);
        MDIHoteleria.mnt_huespedes.setVisible(false);
        MDIHoteleria.mnt_servicios.setVisible(false);
        MDIHoteleria.mnt_pisos.setVisible(false);
        
        if (vid>=2001&&vid<2100) {
            vid=2001;//System.out.println(vid);
        }else if(vid>=2100&&vid<2200){
            vid=2100;//System.out.println(vid);
        }else if(vid>=2200&&vid<2300){
            vid=2200;//System.out.println(vid);
        }else if(vid>=2300&&vid<2400){
            vid=2300;//System.out.println(vid);
        }else if(vid>=2400&&vid<2500){
            vid=2400;//System.out.println(vid);
        }
        
        switch(vid){
            case 2001: 
                MDIHoteleria.submenu_mantenimientos.setVisible(true);
                MDIHoteleria.mnt_amadellaves.setVisible(true);
                break;
            case 2100:
                MDIHoteleria.submenu_mantenimientos.setVisible(true);
                MDIHoteleria.mnt_formasdepago.setVisible(true);
                MDIHoteleria.mnt_habitaciones.setVisible(true);
                break;
            case 2200:
                MDIHoteleria.submenu_mantenimientos.setVisible(true);
                MDIHoteleria.mnt_huespedes.setVisible(true);
                MDIHoteleria.mnt_servicios.setVisible(true);
                break;
            case 2300:
                MDIHoteleria.submenu_mantenimientos.setVisible(true);
                MDIHoteleria.mnt_pisos.setVisible(true);
                break;
            case 2400:
                MDIHoteleria.submenu_procesos.setVisible(true);
                break;
            default:
        }       
                MDI.setTitle("Usuario: " + "[" + Login.usuario + "]" + " \t" + "IP: [" + getIp() + "]");
                MDI.setVisible(true);
                JOptionPane.showMessageDialog(null, "Bienvenido " + Login.usuario,
                "Mensaje de bienvenida", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
}
