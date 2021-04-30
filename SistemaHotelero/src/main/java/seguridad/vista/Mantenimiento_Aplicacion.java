/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.vista;

import java.io.File;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import seguridad.datos.AplicacionDAO;
import seguridad.datos.BitacoraDao;
import seguridad.dominio.Aplicacion;
import seguridad.dominio.Bitacora;

/**
 *
 * @author Jeff
 */
public class Mantenimiento_Aplicacion extends javax.swing.JInternalFrame {

    AplicacionDAO cargarCombobox = new AplicacionDAO();
    ButtonGroup grupoDeRadios;
    DefaultTableModel modelo1;

    /**
     * Creates new form MantenimientoAplicacion
     */
    int codigoAplicacion = 20;

    public Mantenimiento_Aplicacion() {
        initComponents();
        int codigoAplicacion = 25;
        //cargarCombobox.query2(cbxModulo);
        grupoDeRadios = new ButtonGroup();
        grupoDeRadios.add(btnRadioActivo);
        grupoDeRadios.add(btnRadioInactivo);
        grupoDeRadios.add(btnRadioVacio);
        btnRadioVacio.setVisible(false);
        tabla();
    }

    public void tabla() {
        modelo1 = new DefaultTableModel();
        modelo1.addColumn("ID");
        modelo1.addColumn("Nombre");
        modelo1.addColumn("Descripción");
        modelo1.addColumn("No. Reporte");
        modelo1.addColumn("Estado");
        jTable.setModel(modelo1);
        String datos[] = new String[5];
        AplicacionDAO aplicacionDAO = new AplicacionDAO();
        List<Aplicacion> aplicaciones = aplicacionDAO.select();
        for (Aplicacion aplicacion : aplicaciones) {
            datos[0] = String.valueOf(aplicacion.getId_Aplicacion());
            datos[1] = aplicacion.getNombre_Aplicacion();
            datos[2] = aplicacion.getDescripcion_Aplicacion();
            datos[3] = String.valueOf(aplicacion.getReporteAsociado_Aplicacion());
            datos[4] = String.valueOf(aplicacion.getEstado_Aplicacion());
            modelo1.addRow(datos);
            jTable.setModel(modelo1);
        }
    }

    public void limpiar() {
        txtAplicacion.setText("");
        txtNombre.setText("");
        txtArea.setText("");
        txtReporte.setText("");
        //cbxModulo.setSelectedIndex(0);
        btnRadioActivo.setSelected(false);
        btnRadioInactivo.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblModulo = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAplicacion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtReporte = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnRadioActivo = new javax.swing.JRadioButton();
        btnRadioInactivo = new javax.swing.JRadioButton();
        btnRadioVacio = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        btnAyuda = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Aplicaciones");
        setVisible(true);

        btnAgregar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnAgregar.setText("Guardar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(240, 240, 240));
        jDesktopPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("ID Aplicación:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        txtAplicacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAplicacionKeyTyped(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Descripción:");

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("No. Reporte:");

        txtReporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReporteKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Estado:");

        btnRadioActivo.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnRadioActivo.setText("Activo");

        btnRadioInactivo.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnRadioInactivo.setText("Inactivo");

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtAplicacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtReporte, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnRadioActivo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnRadioInactivo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnRadioVacio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(txtReporte)
                            .addComponent(txtAplicacion, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(29, 29, 29))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(btnRadioActivo)
                        .addGap(18, 18, 18)
                        .addComponent(btnRadioInactivo)
                        .addGap(37, 37, 37)
                        .addComponent(btnRadioVacio)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(btnRadioActivo)
                        .addComponent(btnRadioInactivo))
                    .addComponent(btnRadioVacio))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable);

        btnAyuda.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnAyuda.setText("Ayuda");
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAyuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addComponent(jDesktopPane1))
                .addGap(50, 50, 50)
                .addComponent(lblModulo)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblModulo)
                        .addGap(91, 91, 91))
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnAyuda))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        Aplicacion aplicacionInsertar = new Aplicacion();
        AplicacionDAO aplicacionDAO = new AplicacionDAO();
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        //String cbx_Modulo = cbxModulo.getSelectedItem().toString();
        //int txt_Estado = Integer.parseInt(txtAplicacion.getText());
        //lbl_Modulo = cbxModulo.getSelectedItem().toString();

        if (txtAplicacion.getText().length() != 0 && /*cbx_Modulo != "Seleccionar..." &&*/ txtNombre.getText().length() != 0
                && txtArea.getText().length() != 0 && txtReporte.getText().length() != 0 && btnRadioActivo.isSelected()
                || btnRadioInactivo.isSelected()) {
            {
                aplicacionInsertar.setId_Aplicacion(Integer.parseInt(txtAplicacion.getText()));
                //aplicacionInsertar.setId_Modulo(Integer.parseInt(cbxModulo.getSelectedItem().toString()));
                aplicacionInsertar.setNombre_Aplicacion(txtNombre.getText());
                aplicacionInsertar.setDescripcion_Aplicacion(txtArea.getText());
                aplicacionInsertar.setReporteAsociado_Aplicacion(Integer.parseInt(txtReporte.getText()));
                if (btnRadioActivo.isSelected()) {
                    aplicacionInsertar.setEstado_Aplicacion(1);
                }
                if (btnRadioInactivo.isSelected()) {
                    aplicacionInsertar.setEstado_Aplicacion(0);
                }

                btnRadioVacio.setSelected(true);

                AInsertar.setId_Usuario("Aplicacion");
                AInsertar.setAccion("Inserción");
                AInsertar.setCodigoAplicacion(String.valueOf(codigoAplicacion));

                try {
                    BitacoraDAO.insert(AInsertar);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
                }

                limpiar();
                aplicacionDAO.insert(aplicacionInsertar);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos tienen que estar llenos");
        }

        tabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        Aplicacion aplicacionModificar = new Aplicacion();
        AplicacionDAO aplicacionDAO = new AplicacionDAO();
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();

        aplicacionModificar.setId_Aplicacion(Integer.parseInt(txtAplicacion.getText()));
        //aplicacionModificar.setId_Modulo(Integer.parseInt(cbxModulo.getSelectedItem().toString()));
        aplicacionModificar.setNombre_Aplicacion(txtNombre.getText());
        aplicacionModificar.setDescripcion_Aplicacion(txtArea.getText());
        aplicacionModificar.setReporteAsociado_Aplicacion(Integer.parseInt(txtReporte.getText()));
        if (btnRadioActivo.isSelected()) {
            aplicacionModificar.setEstado_Aplicacion(1);
        }
        if (btnRadioInactivo.isSelected()) {
            aplicacionModificar.setEstado_Aplicacion(0);
        }

        aplicacionDAO.update(aplicacionModificar);
        JOptionPane.showMessageDialog(null, "Modificación Exitosa.");
        btnRadioVacio.setSelected(true);

        AInsertar.setId_Usuario("Aplicacion");
        AInsertar.setAccion("Modificación");
        AInsertar.setCodigoAplicacion(String.valueOf(codigoAplicacion));

        try {
            BitacoraDAO.insert(AInsertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }

        tabla();
        limpiar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        Aplicacion aplicacionEliminar = new Aplicacion();
        AplicacionDAO aplicacionDAO = new AplicacionDAO();
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();

        aplicacionEliminar.setId_Aplicacion(Integer.parseInt(txtAplicacion.getText()));
        aplicacionDAO.delete(aplicacionEliminar);
        JOptionPane.showMessageDialog(null, "Registro Eliminado.");
        btnRadioVacio.setSelected(true);
        
        AInsertar.setId_Usuario("Aplicacion");
        AInsertar.setAccion("Eliminación");
        AInsertar.setCodigoAplicacion(String.valueOf(codigoAplicacion));

        try {
            BitacoraDAO.insert(AInsertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }

        tabla();
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        Aplicacion aplicacionBuscar = new Aplicacion();
        AplicacionDAO aplicacionDAO = new AplicacionDAO();
        aplicacionBuscar.setId_Aplicacion(Integer.parseInt(txtAplicacion.getText()));

        aplicacionBuscar = aplicacionDAO.query(aplicacionBuscar);

        //cbxModulo.setSelectedItem(aplicacionBuscar.getId_Modulo());
        txtNombre.setText(String.valueOf(aplicacionBuscar.getNombre_Aplicacion()));
        txtArea.setText(String.valueOf(aplicacionBuscar.getDescripcion_Aplicacion()));
        txtReporte.setText(String.valueOf(aplicacionBuscar.getReporteAsociado_Aplicacion()));
        if (aplicacionBuscar.getEstado_Aplicacion() == 1) {
            btnRadioActivo.setSelected(true);
        }
        if (aplicacionBuscar.getEstado_Aplicacion() == 0) {
            btnRadioInactivo.setSelected(true);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        btnRadioVacio.setSelected(true);
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtAplicacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAplicacionKeyTyped

        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo números.");
        }
    }//GEN-LAST:event_txtAplicacionKeyTyped

    private void txtReporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReporteKeyTyped

        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo números.");
        }
    }//GEN-LAST:event_txtReporteKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped

        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo letras.");
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed

        try {
            if ((new File("src\\main\\java\\seguridad\\ayuda\\AyudaMantenimientoAplicación.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\seguridad\\ayuda\\AyudaMantenimientoAplicación.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAyudaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JRadioButton btnRadioActivo;
    private javax.swing.JRadioButton btnRadioInactivo;
    private javax.swing.JRadioButton btnRadioVacio;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel lblModulo;
    private javax.swing.JTextField txtAplicacion;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtReporte;
    // End of variables declaration//GEN-END:variables
}
