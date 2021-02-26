
package seguridad.dominio;

import java.sql.Date;

/**
 *
 * @author OtakuGT
 */
public class Usuario {
    private String id_usuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private String password_usuario;
    private int cambio_password;
    private String ultima_conexion;
    private int estado_usuario;
    
    public Usuario() {
    }
    
    public Usuario(String id_usuario, String nombre_usuario, String apellido_usuario, String password_usuario, int cambio_password, String ultima_conexion, int estado_usuario){
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.password_usuario = password_usuario;
        this.cambio_password = cambio_password;
        this.ultima_conexion = ultima_conexion;
        this.estado_usuario = estado_usuario;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getPassword_usuario() {
        return password_usuario;
    }

    public void setPassword_usuario(String password_usuario) {
        this.password_usuario = password_usuario;
    }

    public int getCambio_password() {
        return cambio_password;
    }

    public void setCambio_password(int cambio_password) {
        this.cambio_password = cambio_password;
    }

    public String getUltima_conexion() {
        return ultima_conexion;
    }

    public void setUltima_conexion(String ultima_conexion) {
        this.ultima_conexion = ultima_conexion;
    }

    public int getEstado_usuario() {
        return estado_usuario;
    }

    public void setEstado_usuario(int estado_usuario) {
        this.estado_usuario = estado_usuario;
    }

    
}
