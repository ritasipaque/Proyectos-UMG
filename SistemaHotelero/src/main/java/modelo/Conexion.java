
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

//    public static Connection getConnection() {
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    
//    }
//    private final String base = "Usuarios";
//    private final String user = "root";
//    private final String password = "";
//    private final String url = "jdbc:mysql://localhost:3306/" + base;
//    private Connection con = null;
//    
//    public Connection getConexion()
//    {
//         
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
//            
//        } catch(SQLException e)
//        {
//            System.err.println(e);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//      return con;  
//    }
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/usuarios";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "";
  
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }  
}

