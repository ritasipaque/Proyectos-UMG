

package Finanzas.vista;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Finanzas.dominio.Moneda;
import Finanzas.datos.MonedaDAO;
import Finanzas.dominio.TipoPersona;
import Finanzas.datos.TipoPersonaDAO;
import Finanzas.datos.CuentaHabienteDAO;
import Finanzas.dominio.CuentaHabiente;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
import seguridad.datos.BitacoraDao;
import seguridad.dominio.Bitacora;
/**
 *
 * @author Santiago Martinez Diaz
 */
public class FrmCuentaHabiente extends javax.swing.JInternalFrame {
      int codigoAplicacion = 1009;
//Metodo Llenado de Combos consulta los dominios y datos TipoPersonaDAO y TipoPersona para obetner el codigo en el combobox
   public void llenadoDeCombos()  {
       TipoPersonaDAO tipodao = new TipoPersonaDAO();
      List<TipoPersona> tipo = tipodao.listar();
      Cbox_Tipo.addItem("Seleccione una opción");
      for (int i = 0; i < tipo.size(); i++) {
           Cbox_Tipo.addItem(tipo.get(i).getCodigo_TipoPersona());
       }
 }
   
   
   public void llenadoDeTablas() throws SQLException {
       DefaultTableModel modelo = new DefaultTableModel();
       modelo.addColumn("Codigo");
       modelo.addColumn("Nombre");
       modelo.addColumn("Apellido Paterno");
       modelo.addColumn("Apellido Materno");
       modelo.addColumn("Tipo ");
       CuentaHabienteDAO cuentaDao = new CuentaHabienteDAO();
       List<CuentaHabiente> cuenta = cuentaDao.select();
       JTableTransaccion.setModel(modelo);
       String[] dato = new String[5];
       for (int i = 0; i < cuenta.size(); i++) {
           dato[0] = cuenta.get(i).getCodigo_CuentaHabiente();
           dato[1] = cuenta.get(i).getNombre_CuentaHabiente();
           dato[2] = cuenta.get(i).getApellidoP_CuentaHabiente();
           dato[3] = cuenta.get(i).getApellidoM_CuentaHabiente();
           dato[4] = cuenta.get(i).getTipoPersona_CuentaHabiente();
           modelo.addRow(dato);
       }
    }
 
    
    
    
    public FrmCuentaHabiente() throws SQLException {
        initComponents();
        llenadoDeCombos();
        llenadoDeTablas();
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TxtApellidoM = new javax.swing.JTextField();
        label10 = new javax.swing.JLabel();
        label11 = new javax.swing.JLabel();
        Cbox_Tipo = new javax.swing.JComboBox<>();
        TxtApellidoP = new javax.swing.JTextField();
        label8 = new javax.swing.JLabel();
        label9 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        TxtCodigo = new javax.swing.JTextField();
        label7 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        TxtBuscar = new javax.swing.JTextField();
        btnLimpiar3 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        TxtCuenta = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableTransaccion = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Cuenta Habiente");
        setVisible(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        TxtApellidoM.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtApellidoM.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        TxtApellidoM.setOpaque(false);

        label10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label10.setText("Apellido Materno:");

        label11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label11.setText("Tipo Cuenta:");

        TxtApellidoP.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtApellidoP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        TxtApellidoP.setOpaque(false);

        label8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label8.setText("Apellido Paterno:");

        label9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label9.setText("Nombre:");

        TxtNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        TxtNombre.setOpaque(false);

        TxtCodigo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtCodigo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        TxtCodigo.setOpaque(false);

        label7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label7.setText("Codigo De cuenta:");

        btnRegistrar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        TxtBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnLimpiar3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnLimpiar3.setText("Ayuda:");
        btnLimpiar3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar3ActionPerformed(evt);
            }
        });

        jButton3.setText("?");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        TxtCuenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label11)
                            .addComponent(label10)
                            .addComponent(label8)
                            .addComponent(label9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtApellidoP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtApellidoM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cbox_Tipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13)
                .addComponent(jButton3)
                .addGap(9, 9, 9)
                .addComponent(TxtCuenta)
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(Cbox_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addGap(48, 48, 48)
                .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));

        JTableTransaccion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTableTransaccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Apellido Paterno", "Apellido Materno", "Tipo Persona"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTableTransaccion);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
      
        
        CuentaHabienteDAO cuentadao = new CuentaHabienteDAO();
        CuentaHabiente insertarcuenta = new CuentaHabiente();
        insertarcuenta.setCodigo_CuentaHabiente(TxtCodigo.getText());
        insertarcuenta.setNombre_CuentaHabiente(TxtNombre.getText());
          insertarcuenta.setApellidoP_CuentaHabiente(TxtApellidoP.getText());
        insertarcuenta.setApellidoM_CuentaHabiente(TxtApellidoM.getText());
         insertarcuenta.setTipoPersona_CuentaHabiente(Cbox_Tipo.getSelectedItem().toString());
       
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        AInsertar.setId_Usuario("FrmCuentaHabiente");
        AInsertar.setAccion("Registrar");
        AInsertar.setCodigoAplicacion("1009");
        try{
            BitacoraDAO.insert(AInsertar);
            
        } catch (UnknownHostException ex) {
              Logger.getLogger(FrmCuentaHabiente.class.getName()).log(Level.SEVERE, null, ex);
          }
       
         cuentadao.insert(insertarcuenta);
       try {
           llenadoDeTablas();
       } catch (SQLException ex) {
           Logger.getLogger(FrmCuentaHabiente.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       CuentaHabienteDAO cuentadao = new CuentaHabienteDAO();
        CuentaHabiente cuentaeliminar = new CuentaHabiente();
        cuentaeliminar.setCodigo_CuentaHabiente((TxtBuscar.getText()));
        cuentadao.delete(cuentaeliminar);
       try {
           llenadoDeTablas();
       } catch (SQLException ex) {
           Logger.getLogger(FrmCuentaHabiente.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
          BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        AInsertar.setId_Usuario("FrmCuentaHabiente");
        AInsertar.setAccion("Eliminar");
        AInsertar.setCodigoAplicacion("1009");
        try{
            BitacoraDAO.insert(AInsertar);
            
        } catch (UnknownHostException ex) {
              Logger.getLogger(FrmCuentaHabiente.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar3ActionPerformed

        // TODO add your handling code here:
        
                     try {
            if ((new File("src\\main\\java\\Finanzas\\ayudas\\MantenimientoCuentaHabiente.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\Finanzas\\ayudas\\MantenimientoCuentaHabiente.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }    
    }//GEN-LAST:event_btnLimpiar3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String val =Cbox_Tipo.getSelectedItem().toString();
        TipoPersonaDAO perfilDAO = new TipoPersonaDAO();
        TipoPersona consultar = new TipoPersona();
        consultar.setCodigo_TipoPersona(val);
        consultar=perfilDAO.query(consultar);

        TxtCuenta.setText(consultar.getTipoPersona_Nombres());
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cbox_Tipo;
    private javax.swing.JTable JTableTransaccion;
    private javax.swing.JTextField TxtApellidoM;
    private javax.swing.JTextField TxtApellidoP;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JTextField TxtCuenta;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar3;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    // End of variables declaration//GEN-END:variables
}
