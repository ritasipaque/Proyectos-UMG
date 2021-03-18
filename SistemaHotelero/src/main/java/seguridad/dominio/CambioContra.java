/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.dominio;

/**
 *
 * @author Diana
 */
public class CambioContra {
    
     private String usu;
    private String contra;
    
    
    public String getUser() {
        return usu;
    }

    
    public void setUser(String usu) {
        this.usu = usu;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    @Override
    public String toString() {
<<<<<<< HEAD
        return "Usuario{" + "PK_id_usuario=" + usu  + ", password_login=" + contra + '}';
=======
        return "Usuario{" + "id_usuario=" + usu  + ", password=" + contra + '}';
>>>>>>> 21857b3b70ddf1047e23e82c69e1b3bf355ee96c
    }
}
