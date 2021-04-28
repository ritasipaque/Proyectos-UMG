
package Finanzas.dominio;

/**
 * 
 * @author Santiago Martinez Diaz
 */
public class TransaccionBancaria {
private String Codigo_Transaccion;
private String Fecha_Transaccion;
private String Beneficiario; 
private String Cuenta_Bancaria;
private String Tipo_Transaccion;
private String Monto_Transaccion;
private String Concepto_Transaccion; 

    public TransaccionBancaria() {
    }

    public TransaccionBancaria(String Codigo_Transaccion, String Fecha_Transaccion, String Beneficiario, String Cuenta_Bancaria, String Tipo_Transaccion, String Monto_Transaccion, String Concepto_Transaccion) {
        this.Codigo_Transaccion = Codigo_Transaccion;
        this.Fecha_Transaccion = Fecha_Transaccion;
        this.Beneficiario = Beneficiario;
        this.Cuenta_Bancaria = Cuenta_Bancaria;
        this.Tipo_Transaccion = Tipo_Transaccion;
        this.Monto_Transaccion = Monto_Transaccion;
        this.Concepto_Transaccion = Concepto_Transaccion;
    }

    public String getCodigo_Transaccion() {
        return Codigo_Transaccion;
    }

    public void setCodigo_Transaccion(String Codigo_Transaccion) {
        this.Codigo_Transaccion = Codigo_Transaccion;
    }

    public String getFecha_Transaccion() {
        return Fecha_Transaccion;
    }

    public void setFecha_Transaccion(String Fecha_Transaccion) {
        this.Fecha_Transaccion = Fecha_Transaccion;
    }

    public String getBeneficiario() {
        return Beneficiario;
    }

    public void setBeneficiario(String Beneficiario) {
        this.Beneficiario = Beneficiario;
    }

    public String getCuenta_Bancaria() {
        return Cuenta_Bancaria;
    }

    public void setCuenta_Bancaria(String Cuenta_Bancaria) {
        this.Cuenta_Bancaria = Cuenta_Bancaria;
    }

    public String getTipo_Transaccion() {
        return Tipo_Transaccion;
    }

    public void setTipo_Transaccion(String Tipo_Transaccion) {
        this.Tipo_Transaccion = Tipo_Transaccion;
    }

    public String getMonto_Transaccion() {
        return Monto_Transaccion;
    }

    public void setMonto_Transaccion(String Monto_Transaccion) {
        this.Monto_Transaccion = Monto_Transaccion;
    }

    public String getConcepto_Transaccion() {
        return Concepto_Transaccion;
    }

    public void setConcepto_Transaccion(String Concepto_Transaccion) {
        this.Concepto_Transaccion = Concepto_Transaccion;
    }

    @Override
    public String toString() {
        return "TransaccionBancaria{" + "Codigo_Transaccion=" + Codigo_Transaccion + ", Fecha_Transaccion=" + Fecha_Transaccion + ", Beneficiario=" + Beneficiario + ", Cuenta_Bancaria=" + Cuenta_Bancaria + ", Tipo_Transaccion=" + Tipo_Transaccion + ", Monto_Transaccion=" + Monto_Transaccion + ", Concepto_Transaccion=" + Concepto_Transaccion + '}';
    }




    

}
