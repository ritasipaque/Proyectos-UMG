/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas.vista;

import Finanzas.datos.MonedaDAO;
import Finanzas.dominio.Moneda;
import java.io.File;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nay Ale
 */
public class Mantenimiento_Moneda extends javax.swing.JInternalFrame {

    /**
     * Creates new form Mantenimiento_Moneda
     */
    public Mantenimiento_Moneda() {
        initComponents();
        llenadodetablas();    // metodo para el llenado de la tabla con los datos automaticamente
    }
        public void limpiar() {   //metodo de Limpiar automaticamente las cajas de textos 
        txt_CodigoMoneda.setText("");
        txt_NombreMoneda.setText("");
        txt_SimboloMoneda.setText("");
        txt_Buscar.setText("");
    }
  public void buscarmoneda(){    ///metodo para buscar moneda ingresada y guardada a la base de datos
    Moneda monedaconsultar = new Moneda();
    MonedaDAO monedaDAO = new MonedaDAO();
    monedaconsultar.setCodigo_Moneda((txt_Buscar.getText().toString()));
    //-------------------------------------------------------------------
    monedaconsultar = monedaDAO.query(monedaconsultar);
    txt_CodigoMoneda.setText((monedaconsultar.getCodigo_Moneda()));
    txt_NombreMoneda.setText(monedaconsultar.getNombre_Moneda());
    txt_SimboloMoneda.setText(monedaconsultar.getSimbolo_Moneda());  
  }
  public void llenadodetablas(){   // metodo de llenado de tablas automaticamente aparecen los datos guardados en bd y se despliega en automatico
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo Moneda");
        modelo.addColumn("Nombre Moneda");
        modelo.addColumn("Simbolo Moneda");
        MonedaDAO monedaDAO = new MonedaDAO();
        List<Moneda> moneda = monedaDAO.listar();
        Tabla_Moneda.setModel(modelo);
        String[] dato = new String[3];
        for (int i = 0; i < moneda.size(); i++) {
            dato[0] = moneda.get(i).getCodigo_Moneda();
            dato[1] = moneda.get(i).getNombre_Moneda();
            dato[2] = moneda.get(i).getSimbolo_Moneda();   
            modelo.addRow(dato);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_SimboloMoneda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_CodigoMoneda = new javax.swing.JTextField();
        txt_NombreMoneda = new javax.swing.JTextField();
        Boton_Guardar = new javax.swing.JButton();
        Boton_Modificar = new javax.swing.JButton();
        Boton_Eliminar = new javax.swing.JButton();
        Boton_Buscar = new javax.swing.JButton();
        Boton_Ayuda = new javax.swing.JButton();
        txt_Buscar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Moneda = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Mantenimiento_Moneda");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("Codigo Moneda:");

        jLabel2.setText("Nombre Moneda:");

        jLabel3.setText("Simbolo Moneda:");

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

        Boton_Buscar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Boton_Buscar.setText("Buscar");
        Boton_Buscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Boton_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_BuscarActionPerformed(evt);
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
                            .addComponent(jLabel2))
                        .addGap(92, 92, 92)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_NombreMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_CodigoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_SimboloMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Boton_Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(Boton_Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Boton_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(Boton_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(Boton_Ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txt_CodigoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_NombreMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_SimboloMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Boton_Buscar)
                    .addComponent(txt_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Boton_Guardar)
                    .addComponent(Boton_Modificar)
                    .addComponent(Boton_Eliminar)
                    .addComponent(Boton_Ayuda))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        Tabla_Moneda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Moneda", "Nombre Moneda", "Simbolo Moneda"
            }
        ));
        jScrollPane1.setViewportView(Tabla_Moneda);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_GuardarActionPerformed
     Moneda monedaInsertar = new Moneda();
     MonedaDAO monedaDAO = new MonedaDAO();
        // Prueba insert
        monedaInsertar.setCodigo_Moneda(txt_CodigoMoneda.getText());
        monedaInsertar.setNombre_Moneda(txt_NombreMoneda.getText());
        monedaInsertar.setSimbolo_Moneda(txt_SimboloMoneda.getText()); 
        {
            JOptionPane.showMessageDialog(null, "Moneda registrada Exitosamente"); 
            monedaDAO.insert(monedaInsertar);
            llenadodetablas();
            limpiar();
        }                  
        
    }//GEN-LAST:event_Boton_GuardarActionPerformed

    private void Boton_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_ModificarActionPerformed
     MonedaDAO monedaDAO = new MonedaDAO();
        Moneda monedaModificar = new Moneda();
        //MONEDA modificar
        monedaModificar.setCodigo_Moneda(txt_CodigoMoneda.getText());
        monedaModificar.setNombre_Moneda(txt_NombreMoneda.getText());
        monedaModificar.setSimbolo_Moneda(txt_SimboloMoneda.getText()); 
        monedaDAO.update(monedaModificar);
        JOptionPane.showMessageDialog(null, "Moneda Modificada Exitosamente");
        llenadodetablas();
        limpiar();
    }//GEN-LAST:event_Boton_ModificarActionPerformed

    private void Boton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_EliminarActionPerformed
        Moneda monedaEliminar = new Moneda();
        MonedaDAO monedaDAO = new MonedaDAO();
        //Prueba delete
        monedaEliminar.setCodigo_Moneda(txt_CodigoMoneda.getText());
        monedaDAO.delete(monedaEliminar);
        JOptionPane.showMessageDialog(null, "Moneda Eliminado.");
        llenadodetablas();
        limpiar(); 
    }//GEN-LAST:event_Boton_EliminarActionPerformed

    private void Boton_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_BuscarActionPerformed
        buscarmoneda();    //metodo que busca la Moneda ingresada en la base de datos
    }//GEN-LAST:event_Boton_BuscarActionPerformed

    private void Boton_AyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_AyudaActionPerformed
        /// metodo para ejecutar la ayuda que es una guia para el mantenimiento MONEDA
          try {
            if ((new File("src\\main\\java\\Finanzas\\ayudas\\MantenimientoMoneda.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\Finanzas\\ayudas\\MantenimientoMoneda.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }    
    }//GEN-LAST:event_Boton_AyudaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_Ayuda;
    private javax.swing.JButton Boton_Buscar;
    private javax.swing.JButton Boton_Eliminar;
    private javax.swing.JButton Boton_Guardar;
    private javax.swing.JButton Boton_Modificar;
    private javax.swing.JTable Tabla_Moneda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_Buscar;
    private javax.swing.JTextField txt_CodigoMoneda;
    private javax.swing.JTextField txt_NombreMoneda;
    private javax.swing.JTextField txt_SimboloMoneda;
    // End of variables declaration//GEN-END:variables
}
