package Finanzas.vista;

import Finanzas.datos.BancoDAO;
import Finanzas.datos.CuentaBancariaDAO;
import Finanzas.datos.CuentaHabienteDAO;
import Finanzas.datos.EmisionChequeDAO;
import Finanzas.dominio.EmisionCheque;
import Finanzas.dominio.Banco;
import Finanzas.dominio.CuentaBancaria;
import Finanzas.dominio.CuentaHabiente;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nay Ale
 */
public class Emision_Cheque extends javax.swing.JInternalFrame {
    int codigoAplicacion = 1105;

    public void llenadoDeCombos1() throws SQLException  {
       BancoDAO bancoDAO = new BancoDAO();
      List<Banco> banco = bancoDAO.listar();
      ComboBanco.addItem("Seleccione una opción");
      for (int i = 0; i < banco.size(); i++) {
           ComboBanco.addItem(banco.get(i).getCodigo_Banco());
       }
 }
     
      public void llenadoDeCombos2() throws SQLException  {
       CuentaBancariaDAO cuentabancariaDAO = new CuentaBancariaDAO();
      List<CuentaBancaria> cuentabancaria = cuentabancariaDAO.listar();
      ComboCuenta.addItem("Seleccione una opción");
      for (int i = 0; i < cuentabancaria.size(); i++) {
           ComboCuenta.addItem(cuentabancaria.get(i).getNumero_CuentaBancaria());
       }
      }
      
      public void llenadoDeCombos3() throws SQLException  {
       CuentaHabienteDAO cuentadao = new CuentaHabienteDAO();
      List<CuentaHabiente> cuenta = cuentadao.listar();
      ComboPaguese.addItem("Seleccione una opción");
      for (int i = 0; i < cuenta.size(); i++) {
           ComboPaguese.addItem(cuenta.get(i).getCodigo_CuentaHabiente());
       }
      }
          
 public void llenadodetablas() { // metodo de llenado de tablas automaticamente aparecen los datos guardados en bd y se despliega en automatico en el jtable
    
          DefaultTableModel modelo = new DefaultTableModel();
          modelo.addColumn("Numero Cheque");
          modelo.addColumn("Fecha");
          modelo.addColumn("Banco");
          modelo.addColumn("Cuenta");
          modelo.addColumn("Paguese a"); 
          modelo.addColumn("Monto");
          
          EmisionChequeDAO emisionchequeDAO = new EmisionChequeDAO();
          List<EmisionCheque> echeque = emisionchequeDAO.listar();
          TablaECheque.setModel(modelo);
          String[] dato = new String[5];
          for (int i = 0; i < echeque.size(); i++) {
              dato[0] = echeque.get(i).getNumero_Cheque();
              dato[1] = echeque.get(i).getFecha_Cheque();
              dato[2] = echeque.get(i).getFK_Banco();
              dato[3] = echeque.get(i).getFK_Cuenta();
              dato[4] = echeque.get(i).getFK_Cuentahabiente();
              dato[5] = echeque.get(i).getMonto_Cheque();
              modelo.addRow(dato);
          }
    }
    public void buscarCheque(){    ///metodo para buscar un cheque ingresado y guardado a la base de datos
    EmisionCheque chequeconsultar = new EmisionCheque();
    EmisionChequeDAO emisionchequeDAO = new EmisionChequeDAO();
    chequeconsultar.setNumero_Cheque((txt_Buscar.getText()));
    //-------------------------------------------------------------------
    chequeconsultar = emisionchequeDAO.query(chequeconsultar);
    txtNoCheque.setText((chequeconsultar.getNumero_Cheque()));
    Fecha.setDateFormatString(chequeconsultar.getFecha_Cheque());
    ComboBanco.setSelectedItem(chequeconsultar.getFK_Banco());
    ComboCuenta.setSelectedItem(chequeconsultar.getFK_Cuenta());
    ComboPaguese.setSelectedItem(chequeconsultar.getFK_Cuentahabiente());
    txtMonto.setText(chequeconsultar.getMonto_Cheque());
  }
    public void bitacora (){
        
    }
    /**
     * Creates new form EmisionCheque
     */
    public Emision_Cheque() throws SQLException {
        initComponents();
        llenadodetablas();
        llenadoDeCombos1();
        llenadoDeCombos2();
        llenadoDeCombos3();
        int codigoAplicacion = 1105; // numero de asignacion para perfiles para bitacora.
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Boton_Buscar = new javax.swing.JButton();
        txt_Buscar = new javax.swing.JTextField();
        Boton_Guardar = new javax.swing.JButton();
        Boton_Modificar = new javax.swing.JButton();
        Boton_Eliminar = new javax.swing.JButton();
        Boton_Ayuda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNoCheque = new javax.swing.JTextField();
        ComboBanco = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        Fecha = new com.toedter.calendar.JDateChooser();
        ComboPaguese = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        ComboCuenta = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaECheque = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Emision_Cheque");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        Boton_Buscar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Boton_Buscar.setText("Buscar");
        Boton_Buscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Boton_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_BuscarActionPerformed(evt);
            }
        });

        Boton_Guardar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Boton_Guardar.setText("Guardar");
        Boton_Guardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Boton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_GuardarActionPerformed(evt);
            }
        });

        Boton_Modificar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Boton_Modificar.setText("Modificar");
        Boton_Modificar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Boton_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_ModificarActionPerformed(evt);
            }
        });

        Boton_Eliminar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Boton_Eliminar.setText("Eliminar");
        Boton_Eliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Boton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_EliminarActionPerformed(evt);
            }
        });

        Boton_Ayuda.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Boton_Ayuda.setText("Ayuda");
        Boton_Ayuda.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Boton_Ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_AyudaActionPerformed(evt);
            }
        });

        jLabel1.setText("Numero Cheque:");

        jLabel2.setText("Fecha:");

        jLabel3.setText("Banco:");

        jLabel4.setText("Paguese a :");

        ComboBanco.setMaximumRowCount(20);

        jLabel5.setText("Monto:");

        ComboPaguese.setMaximumRowCount(20);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Reporte");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText("Cuenta:");

        ComboCuenta.setMaximumRowCount(20);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(Boton_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Boton_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Boton_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ComboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNoCheque)
                                    .addComponent(ComboBanco, 0, 233, Short.MAX_VALUE))))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 22, Short.MAX_VALUE)
                                .addComponent(Boton_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(Boton_Ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(46, 46, 46)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(ComboPaguese, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNoCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(ComboPaguese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ComboBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ComboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel2)
                    .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Buscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Boton_Buscar)
                        .addComponent(Boton_Guardar)
                        .addComponent(Boton_Modificar)
                        .addComponent(Boton_Eliminar)
                        .addComponent(Boton_Ayuda)
                        .addComponent(jButton1))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle:"));

        TablaECheque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Cheque", "Fecha ", "Banco", "Cuenta", "Paguese a", "Monto"
            }
        ));
        jScrollPane1.setViewportView(TablaECheque);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_BuscarActionPerformed
    buscarCheque();
    }//GEN-LAST:event_Boton_BuscarActionPerformed

    private void Boton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_GuardarActionPerformed
   EmisionChequeDAO emisionchequeDAO = new EmisionChequeDAO();
    EmisionCheque insertar = new EmisionCheque();
        
    String Inicio = new SimpleDateFormat("dd/MM/yyyy").format(Fecha.getDate());
   
       insertar.setNumero_Cheque(txtNoCheque.getText());
       insertar.setFecha_Cheque(Inicio);
       insertar.setFK_Banco(ComboBanco.getSelectedItem().toString());
       insertar.setFK_Cuenta(ComboCuenta.getSelectedItem().toString());
       insertar.setFK_Cuentahabiente(ComboPaguese.getSelectedItem().toString());
       insertar.setMonto_Cheque(txtMonto.getText());
       
       JOptionPane.showMessageDialog(null, "Cheque registrado Exitosamente");
       //BitacoraDao BitacoraDAO = new BitacoraDao();
       // Bitacora AInsertar = new Bitacora();
       // AInsertar.setId_Usuario("EmisionCheque");
       // AInsertar.setAccion("Insertar");
       // AInsertar.setCodigoAplicacion("1105");
       // try{
       //     BitacoraDAO.insert(AInsertar);   
       // }   catch (UnknownHostException ex) {
       //     Logger.getLogger(Emision_Cheque.class.getName()).log(Level.SEVERE, null, ex);
       // }
       emisionchequeDAO.insert(insertar);
       llenadodetablas();
    }//GEN-LAST:event_Boton_GuardarActionPerformed

    private void Boton_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_ModificarActionPerformed
    EmisionChequeDAO emisionchequeDAO = new EmisionChequeDAO();
    EmisionCheque modificarcheque = new EmisionCheque();
        
    String Inicio = new SimpleDateFormat("dd/MM/yyyy").format(Fecha.getDate());
   
       modificarcheque.setNumero_Cheque(txtNoCheque.getText());
       modificarcheque.setFecha_Cheque(Inicio);
       modificarcheque.setFK_Banco(ComboBanco.getSelectedItem().toString());
       modificarcheque.setFK_Cuenta(ComboCuenta.getSelectedItem().toString());
       modificarcheque.setFK_Cuentahabiente(ComboPaguese.getSelectedItem().toString());
       modificarcheque.setMonto_Cheque(txtMonto.getText());
       
       JOptionPane.showMessageDialog(null, "Cheque Modificado Exitosamente");
       emisionchequeDAO.insert(modificarcheque);
       llenadodetablas();   
    }//GEN-LAST:event_Boton_ModificarActionPerformed

    private void Boton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_EliminarActionPerformed
    EmisionChequeDAO emisionchequeDAO = new EmisionChequeDAO();
    EmisionCheque chequeeliminar = new EmisionCheque();
        //Metodo Para Eliminar con el Numero de Cuenta Bancaria
        chequeeliminar.setNumero_Cheque((txt_Buscar.getText()));
        JOptionPane.showMessageDialog(null, "Cheque Eliminado Exitosamente");
        emisionchequeDAO.delete(chequeeliminar);
           llenadodetablas();   
    }//GEN-LAST:event_Boton_EliminarActionPerformed

    private void Boton_AyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_AyudaActionPerformed
        
    }//GEN-LAST:event_Boton_AyudaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_Ayuda;
    private javax.swing.JButton Boton_Buscar;
    private javax.swing.JButton Boton_Eliminar;
    private javax.swing.JButton Boton_Guardar;
    private javax.swing.JButton Boton_Modificar;
    private javax.swing.JComboBox<String> ComboBanco;
    private javax.swing.JComboBox<String> ComboCuenta;
    private javax.swing.JComboBox<String> ComboPaguese;
    private com.toedter.calendar.JDateChooser Fecha;
    private javax.swing.JTable TablaECheque;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNoCheque;
    private javax.swing.JTextField txt_Buscar;
    // End of variables declaration//GEN-END:variables
}
