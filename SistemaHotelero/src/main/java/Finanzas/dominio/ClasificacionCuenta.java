package Finanzas.dominio;

import Finanzas.datos.ClasificacionCuentaDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Vásquez
 */
public class ClasificacionCuenta {

    private String codigoClasificacion = "";
    private String clasificacionCuenta = "";
    private String descripcionClasificacion = "";

    /**
     * @return the codigoClasificacion
     */
    public String getCodigoClasificacion() {
        return codigoClasificacion;
    }

    /**
     * @param codigoClasificacion the codigoClasificacion to set
     */
    public void setCodigoClasificacion(String codigoClasificacion) {
        this.codigoClasificacion = codigoClasificacion;
    }

    /**
     * @return the clasificacionCuenta
     */
    public String getClasificacionCuenta() {
        return clasificacionCuenta;
    }

    /**
     * @param clasificacionCuenta the clasificacionCuenta to set
     */
    public void setClasificacionCuenta(String clasificacionCuenta) {
        this.clasificacionCuenta = clasificacionCuenta;
    }

    /**
     * @return the descripcionClasificacion
     */
    public String getDescripcionClasificacion() {
        return descripcionClasificacion;
    }

    /**
     * @param descripcionClasificacion the descripcionClasificacion to set
     */
    public void setDescripcionClasificacion(String descripcionClasificacion) {
        this.descripcionClasificacion = descripcionClasificacion;
    }

    ClasificacionCuentaDAO clasificarDAO = new ClasificacionCuentaDAO();

    public void Registrar(ClasificacionCuenta objClasificacion) {
        clasificarDAO.Insertar(objClasificacion);
    }

    /*public String[][] getTablaRegistros() {
        String[][] matrixRegistros;
        clasificarDAO.TablaDespliegue();
        matrixRegistros = new String[clasificarDAO.TablaDespliegue().length][3];

        for (int i = 0; i < clasificarDAO.TablaDespliegue().length; i++) {
            for (int j = 0; j < 3; j++) {
                matrixRegistros[i][j] = clasificarDAO.TablaDespliegue()[i][j];
            }
        }
        return matrixRegistros;
    }*/

}
