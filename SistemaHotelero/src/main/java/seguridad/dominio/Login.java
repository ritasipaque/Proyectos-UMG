package seguridad.dominio;

public class Login {

    public static String getText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
<<<<<<< HEAD
    private int PK_id_usuario;
    private String username_login;
    private String password_login;
=======
    private int id_usuario;
    private String username;
    private String password;
>>>>>>> 21857b3b70ddf1047e23e82c69e1b3bf355ee96c

    public Login() {
    }

    public Login(int id_usuario) {
<<<<<<< HEAD
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
=======
        this.id_usuario = id_usuario;
    }
    
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public Login(int id_usuario, String username, String password) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.password = password;
>>>>>>> 21857b3b70ddf1047e23e82c69e1b3bf355ee96c
    }
    

    public int getId_usuario() {
<<<<<<< HEAD
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
=======
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
>>>>>>> 21857b3b70ddf1047e23e82c69e1b3bf355ee96c
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Usuario{" + "PK_id_usuario=" + PK_id_usuario + ", username_login=" + username_login + ", password_login=" + password_login + '}';
=======
        return "Usuario{" + "id_usuario=" + id_usuario + ", username=" + username + ", password=" + password + '}';
>>>>>>> 21857b3b70ddf1047e23e82c69e1b3bf355ee96c
    }
    
    
}
