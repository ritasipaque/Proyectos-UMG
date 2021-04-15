package Finanzas.datos;
import Finanzas.dominio.ClasificacionCuenta;

/**
 *
 * @author Diego Vásquez
 */
public class ClasificacionCuentaDAO extends Conexion {

    private String SQL_INSERT = "INSERT INTO ClasificacionCuenta VALUES(?,?,?)";
    private String SQL_UPDATE = "UPDATE ClasificacionCuenta SET CodigoClasificacion=?, Clasificacion_CuentaNombre = ?, Descripcion_Clasificacion = ?";
    private String SQL_QUERY = "SELECT * FROM ClasificacionCuenta WHERE CodigoClasificacion = ?";
    private String SQL_DELETE = "DELETE FROM ClasificacionCuenta WHERE CodigoClasificacion = ?";
    private String SQL_SELECT = "SELECT * FROM ClasificacionCuenta";
    
    ClasificacionCuenta objetoClasificacion = new ClasificacionCuenta();
}
