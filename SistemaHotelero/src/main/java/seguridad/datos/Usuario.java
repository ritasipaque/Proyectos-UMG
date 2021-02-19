package seguridad.datos;

import java.sql.Date;

public class Usuario {

    private int id_usuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private String password_usuario;
    private Date ultima_conexion;
    private int estado_usuario;

    public Date getUltima_conexion() {
        return ultima_conexion;
    }

    public void setUltima_conexion(Date ultima_conexion) {
        this.ultima_conexion = ultima_conexion;
    }
    private int cambio_password;

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
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

    public int getEstado_usuario() {
        return estado_usuario;
    }

    public void setEstado_usuario(int estado_usuario) {
        this.estado_usuario = estado_usuario;
    }

    public Usuario() {
    }

    public Usuario(int id_usuario, int cambio_password, int estado_usuario) {
        this.id_usuario = id_usuario;
        this.cambio_password = cambio_password;
        this.estado_usuario = estado_usuario;
    }

    public Usuario(String nombre_usuario, String password_usuario, String apellido_usuario) {
        this.nombre_usuario = nombre_usuario;
        this.password_usuario = password_usuario;
        this.apellido_usuario = apellido_usuario;
    }

    public Usuario (Date ultima_conexion){
        this.ultima_conexion = ultima_conexion;
    }
    
    public Usuario(int id_usuario, int cambio_password, int estado_usuario, Date ultima_conexion, String nombre_usuario, String apellido_usuario, String password_usuario ) {
        this.id_usuario = id_usuario;
        this.cambio_password = cambio_password;
        this.estado_usuario = estado_usuario;
        this.ultima_conexion = ultima_conexion;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.password_usuario = password_usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nombre_usuario=" + nombre_usuario + ", apellido_usuario=" + apellido_usuario + 
                ", password_usuario=" + password_usuario + ", cambio_password=" + cambio_password + ", ultima_conexion" + ultima_conexion + 
                ", estado_usuario=" + estado_usuario + '}';
        
    }

}
