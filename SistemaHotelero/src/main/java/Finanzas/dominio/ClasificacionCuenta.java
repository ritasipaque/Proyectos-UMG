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

    public void Insertar(ClasificacionCuenta objClasificacion) {
        if (objClasificacion.getCodigoClasificacion().equals("") || objClasificacion.getCodigoClasificacion().equals("") || objClasificacion.getDescripcionClasificacion().equals("")) {

            JOptionPane.showMessageDialog(null, "¡NO PUEDEN HABER CAMPOS VACÍOS!", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else {
            int respuesta = clasificarDAO.Insertar(objClasificacion);

            if (respuesta == 1) {
                JOptionPane.showMessageDialog(null, "¡REGISTRO EXITOSO!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "¡REGISTRO ERRÓNEO!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void Actualizar(ClasificacionCuenta objClasificacion) {
        if (objClasificacion.getCodigoClasificacion().equals("") || objClasificacion.getCodigoClasificacion().equals("") || objClasificacion.getDescripcionClasificacion().equals("")) {

            JOptionPane.showMessageDialog(null, "¡NO PUEDEN HABER CAMPOS VACÍOS!", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else {
            int respuesta = clasificarDAO.Actualizar(objClasificacion);

            if (respuesta == 1) {
                JOptionPane.showMessageDialog(null, "¡ACTUALIZACIÓN EXITOSA!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "¡ACTUALIZACIÓN ERRÓNEA!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void Eliminar(ClasificacionCuenta objClasificacion) {
        if (objClasificacion.getCodigoClasificacion().equals("")) {

            JOptionPane.showMessageDialog(null, "¡CAMPO CÓDIGO NO PUEDE ESTAR VACÍO!", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else {
            int respuesta = clasificarDAO.Eliminar(objClasificacion);

            if (respuesta == 1) {
                JOptionPane.showMessageDialog(null, "¡ELIMINACIÓN EXITOSA!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "¡ELIMINACIÓN ERRÓNEA!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public ClasificacionCuenta Buscar(ClasificacionCuenta objClasificacion) {
        if (objClasificacion.getCodigoClasificacion().equals("")) {

            JOptionPane.showMessageDialog(null, "¡CAMPO CÓDIGO NO PUEDE ESTAR VACÍO!", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else {
            objClasificacion = new ClasificacionCuenta();
            clasificarDAO.Buscar(objClasificacion);
            
            objClasificacion.setCodigoClasificacion(clasificarDAO.Buscar(objClasificacion).getCodigoClasificacion());
            objClasificacion.setClasificacionCuenta(clasificarDAO.Buscar(objClasificacion).getClasificacionCuenta());
            objClasificacion.setDescripcionClasificacion(clasificarDAO.Buscar(objClasificacion).getDescripcionClasificacion());

            if (objClasificacion.getCodigoClasificacion().equals("") || objClasificacion.getClasificacionCuenta().equals("") || objClasificacion.getDescripcionClasificacion().equals("")) {
                
                JOptionPane.showMessageDialog(null, "¡REGISTRO NO ENCONTRADO!", "ERROR", JOptionPane.ERROR_MESSAGE);
                
            } else {
                JOptionPane.showMessageDialog(null, "¡REGISTRO ENCONTRADO!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return objClasificacion;
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
