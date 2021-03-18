/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.datos;
 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rita Sipaque
 */

public class Asignacion_a_modulosDAO {
    static Connection conexion=null;
    static Statement sentencia;
    static ResultSet resultado;
    static ResultSetMetaData resultadometa;
    public static void conectar(){
        String ruta="jdbc:mysql://localhost/umg";
        String user="root";
        String pass="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection(ruta,user,pass); 
            sentencia= conexion.createStatement();
            
        } catch (Exception e) {
            
        }
    }
////    Array que se encarga de traer informacion de la base de datos a la tabla
    public static ArrayList<Object[]> llenar_tabla(){
        ArrayList<Object[]> datos = new ArrayList<Object[]>();
        String q = "SELECT nombre_aplicacion FROM tbl_aplicacion";
        try {
            resultado=sentencia.executeQuery(q);
            resultadometa= resultado.getMetaData();
            
        } catch (Exception e) {
            
        }
        try {
            while(resultado.next()){
                Object[] filas = new Object[resultadometa.getColumnCount()];
                for(int i = 0;i<resultadometa.getColumnCount();i++){
                    filas[i]= resultado.getObject(i+1);
                }
                datos.add(filas);
            }
        } catch (Exception e) {
        }
        return datos;
    
    }
////    Se encarga de traer el id de la aplicacion
 public static ArrayList<Object[]> buscar_tabla(String Nombre){
        ArrayList<Object[]> datos = new ArrayList<Object[]>();
        String q = "SELECT PK_id_aplicacion FROM tbl_aplicacion";
        try {
            resultado=sentencia.executeQuery(q);
            resultadometa= resultado.getMetaData();
            
        } catch (Exception e) {
            
        }
        try {
            while(resultado.next()){
                Object[] filas = new Object[resultadometa.getColumnCount()];
                for(int i = 0;i<resultadometa.getColumnCount();i++){
                    filas[i]= resultado.getObject(i+1);
                }
                datos.add(filas);
            }
        } catch (Exception e) {
        }
        return datos;
    
    }
}
