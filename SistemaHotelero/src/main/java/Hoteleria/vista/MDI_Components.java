/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hoteleria.vista;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author leone
 */
public class MDI_Components {
       public String getIp() throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        return address.getHostAddress();
    }
}
