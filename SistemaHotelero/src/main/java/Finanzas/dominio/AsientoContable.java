package Finanzas.dominio;

import Finanzas.datos.AsientoContableDAO;

/**
 *
 * @author Diego Vásquez
 */
public class AsientoContable {

    AsientoContableDAO asientoContableDAO = new AsientoContableDAO();

    public String CodigoAsientoContable() {

        String CodigoRegistroAux = "";
        String CodigoRegistro = "";
        CodigoRegistroAux = asientoContableDAO.NroAsiento();

        if (CodigoRegistroAux == null) {
            CodigoRegistro = "0000001";
        } else {
            int incremento = Integer.parseInt(CodigoRegistroAux);
            incremento = incremento + 1;

            if (incremento >= 2 && incremento <= 9) {
                CodigoRegistro = "000000" + String.valueOf(incremento);
            }
            if (incremento >= 10 && incremento <= 99) {
                CodigoRegistro = "00000" + String.valueOf(incremento);
            }
            if (incremento >= 100 && incremento <= 999) {
                CodigoRegistro = "0000" + String.valueOf(incremento);
            }
            if (incremento >= 1000 && incremento <= 9999) {
                CodigoRegistro = "000" + String.valueOf(incremento);
            }
            if (incremento >= 10000 && incremento <= 99999) {
                CodigoRegistro = "00" + String.valueOf(incremento);
            }
            if (incremento >= 100000 && incremento <= 999999) {
                CodigoRegistro = "0" + String.valueOf(incremento);
            }
        }
        return CodigoRegistro;
    }

    public String[][] getRegistrosEncabezado() {
        String[][] matrixRegistros;

        asientoContableDAO.getCantidadEncabezados();

        matrixRegistros = new String[asientoContableDAO.RegistrosEncabezado().length][1];

        for (int i = 0; i < asientoContableDAO.RegistrosEncabezado().length; i++) {
            for (int j = 0; j < 1; j++) {
                matrixRegistros[i][j] = asientoContableDAO.RegistrosEncabezado()[i][j];
            }
        }
        return matrixRegistros;
    }

    public String[][] getRegistrosPeriodos() {
        String[][] matrixRegistros;

        asientoContableDAO.getCantidadPeriodos();

        matrixRegistros = new String[asientoContableDAO.RegistrosPeriodos().length][1];

        for (int i = 0; i < asientoContableDAO.RegistrosPeriodos().length; i++) {
            for (int j = 0; j < 1; j++) {
                matrixRegistros[i][j] = asientoContableDAO.RegistrosPeriodos()[i][j];
            }
        }
        return matrixRegistros;
    }

    public String[] getTipoAsientos() {
        String[] matrixRegistros;

        asientoContableDAO.getCantidadTipoAsiento();

        matrixRegistros = new String[asientoContableDAO.RegistrosTipoAsiento().length];

        for (int i = 0; i < asientoContableDAO.RegistrosTipoAsiento().length; i++) {

            matrixRegistros[i] = asientoContableDAO.RegistrosTipoAsiento()[i];

        }
        return matrixRegistros;
    }
}
