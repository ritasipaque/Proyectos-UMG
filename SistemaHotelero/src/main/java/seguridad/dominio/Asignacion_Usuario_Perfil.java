/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.dominio;

/**
 *
 * @author Santiago Martinez
 */
public class Asignacion_Usuario_Perfil {
    
     
   private String PK_id_usuario;
   private int PK_id_perfil;

    public Asignacion_Usuario_Perfil() {
    }

    public Asignacion_Usuario_Perfil(String PK_id_usuario, int PK_id_perfil) {
        this.PK_id_usuario = PK_id_usuario;
        this.PK_id_perfil = PK_id_perfil;
    }

    public String getPK_id_usuario() {
        return PK_id_usuario;
    }

    public void setPK_id_usuario(String PK_id_usuario) {
        this.PK_id_usuario = PK_id_usuario;
    }

    public int getPK_id_perfil() {
        return PK_id_perfil;
    }

    public void setPK_id_perfil(int PK_id_perfil) {
        this.PK_id_perfil = PK_id_perfil;
    }

    @Override
    public String toString() {
        return "Asignacion_Usuario_Perfil{" + "PK_id_usuario=" + PK_id_usuario + ", PK_id_perfil=" + PK_id_perfil + '}';
    }
   
   
    
}
