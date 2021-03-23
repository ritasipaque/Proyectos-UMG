package seguridad.dominio;

public class Login {

    public static String getText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int PK_id_usuario;
    private String username_login;
    private String password_login;

    public Login() {
    }

    public Login(int id_usuario) {
        this.PK_id_usuario = id_usuario;
    }
    
    public Login(String username, String password) {
        this.username_login = username;
        this.password_login = password;
    }
    
    public Login(int id_usuario, String username, String password) {
        this.PK_id_usuario = id_usuario;
        this.username_login = username;
        this.password_login = password;
    }
    

    public int getId_usuario() {
        return PK_id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.PK_id_usuario = id_usuario;
    }

    public String getUsername() {
        return username_login;
    }

    public void setUsername(String username) {
        this.username_login = username;
    }

    public String getPassword() {
        return password_login;
    }

    public void setPassword(String password) {
        this.password_login = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "PK_id_usuario=" + PK_id_usuario + ", username_login=" + username_login + ", password_login=" + password_login + '}';
    }
    
    
}
