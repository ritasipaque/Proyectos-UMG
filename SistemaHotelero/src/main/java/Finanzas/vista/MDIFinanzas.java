package Finanzas.vista;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

/*
    @author Diego Vásquez
 */
public class MDIFinanzas extends javax.swing.JFrame {
  private FrmTipoTransaccion fmTipo;
  private Mantenimiento_Banco formMantenimiento_Banco;//llamado a la ventana Mantenimiento Banco
  private Mantenimiento_TipoPersona formMantenimiento_TipoPersona;//llamado a la ventana Mantenimiento Tipo Persona
  private Mantenimiento_Moneda formMantenimiento_Moneda;//llamado a la ventana Mantenimiento Moneda 
  private FrmCuentaBancaria FrmBancaria;
  private FrmCuentaHabiente FrmHabiente;
 
    public MDIFinanzas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDesktopFinanzas = new javax.swing.JDesktopPane()
        ;
        JMenuBarFinanzas = new javax.swing.JMenuBar();
        JMenuArchivo = new javax.swing.JMenu();
        JMenuCatalogos = new javax.swing.JMenu();
        JMenuCatalogoContabilidad = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        JMenuCatalogoBancos = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        JMenuProcesos = new javax.swing.JMenu();
        JMenuInformes = new javax.swing.JMenu();
        JMenuHerramientas = new javax.swing.JMenu();
        JMenuAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modulo Finanzas [ip] [user]");
        setResizable(false);

        JDesktopFinanzas.setBackground(new java.awt.Color(60, 80, 40));

        javax.swing.GroupLayout JDesktopFinanzasLayout = new javax.swing.GroupLayout(JDesktopFinanzas);
        JDesktopFinanzas.setLayout(JDesktopFinanzasLayout);
        JDesktopFinanzasLayout.setHorizontalGroup(
            JDesktopFinanzasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1350, Short.MAX_VALUE)
        );
        JDesktopFinanzasLayout.setVerticalGroup(
            JDesktopFinanzasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
        );

        JMenuArchivo.setText("Archivo");
        JMenuArchivo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        JMenuBarFinanzas.add(JMenuArchivo);

        JMenuCatalogos.setText("Catálogos");
        JMenuCatalogos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        JMenuCatalogoContabilidad.setText("Catálogos Contabilidad");

        jMenuItem1.setText("Mantenimiento de Clasificación de Cuentas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        JMenuCatalogoContabilidad.add(jMenuItem1);

        jMenuItem3.setText("Mantenimiento de Cuentas Contables");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        JMenuCatalogoContabilidad.add(jMenuItem3);

        jMenuItem2.setText("Mantenimiento de Periodo Fiscal");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        JMenuCatalogoContabilidad.add(jMenuItem2);

        jMenuItem4.setText("Mantenimiento de Tipo de Asiento Contable");
        JMenuCatalogoContabilidad.add(jMenuItem4);

        JMenuCatalogos.add(JMenuCatalogoContabilidad);

        JMenuCatalogoBancos.setText("Catálogos Bancos");

        jMenuItem5.setText("Mantenimiento de Tipo de Transacción");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        JMenuCatalogoBancos.add(jMenuItem5);

        jMenuItem6.setText("Mantenimiento de Cuentas Bancarias");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        JMenuCatalogoBancos.add(jMenuItem6);

        jMenuItem7.setText("Mantenimiento de Cuentahabientes");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        JMenuCatalogoBancos.add(jMenuItem7);

        jMenuItem8.setText("Mantenimiento de Bancos");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        JMenuCatalogoBancos.add(jMenuItem8);

        jMenuItem9.setText("Mantenimiento de Divisas");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        JMenuCatalogoBancos.add(jMenuItem9);

        jMenuItem10.setText("Mantenimiento de Persona Bancaria");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        JMenuCatalogoBancos.add(jMenuItem10);

        JMenuCatalogos.add(JMenuCatalogoBancos);

        JMenuBarFinanzas.add(JMenuCatalogos);

        JMenuProcesos.setText("Procesos");
        JMenuProcesos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        JMenuBarFinanzas.add(JMenuProcesos);

        JMenuInformes.setText("Informes");
        JMenuInformes.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        JMenuBarFinanzas.add(JMenuInformes);

        JMenuHerramientas.setText("Herramientas");
        JMenuHerramientas.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        JMenuBarFinanzas.add(JMenuHerramientas);

        JMenuAyuda.setText("Ayuda");
        JMenuAyuda.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        JMenuBarFinanzas.add(JMenuAyuda);

        setJMenuBar(JMenuBarFinanzas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDesktopFinanzas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDesktopFinanzas)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

<<<<<<< HEAD
<<<<<<< HEAD
=======

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        FrmMantCuentaContable frmMantCuentaContable = new FrmMantCuentaContable();
        JDesktopFinanzas.add(frmMantCuentaContable);
        frmMantCuentaContable.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FrmMantClasificacionCuentas frmMantClasificacionCuentas = new FrmMantClasificacionCuentas();
        JDesktopFinanzas.add(frmMantClasificacionCuentas);
        frmMantClasificacionCuentas.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Mantenimiento_PeriodoFiscal frm_mantPerFis = new Mantenimiento_PeriodoFiscal();
        frm_mantPerFis.setVisible(true);
        JDesktopFinanzas.add(frm_mantPerFis);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

>>>>>>> CastilloC
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
                fmTipo = new FrmTipoTransaccion();
        JDesktopFinanzas.add(fmTipo);
    }//GEN-LAST:event_jMenuItem5ActionPerformed
<<<<<<< HEAD
=======
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Mantenimiento_PeriodoFiscal frm_mantPerFis = new Mantenimiento_PeriodoFiscal();
        frm_mantPerFis.setVisible(true);
        JDesktopFinanzas.add(frm_mantPerFis);
    }//GEN-LAST:event_jMenuItem2ActionPerformed
>>>>>>> CastilloC
=======


    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
    //Banco
        formMantenimiento_Banco = new Mantenimiento_Banco();
        JDesktopFinanzas.add(formMantenimiento_Banco);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // Moneda
        formMantenimiento_Moneda = new Mantenimiento_Moneda();
        JDesktopFinanzas.add(formMantenimiento_Moneda);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
    //Tipo de persona 
        formMantenimiento_TipoPersona = new Mantenimiento_TipoPersona();
        JDesktopFinanzas.add(formMantenimiento_TipoPersona);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

<<<<<<< HEAD
>>>>>>> CastilloC
=======
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
      try {
          // TODO add your handling code here:
          FrmBancaria = new FrmCuentaBancaria();
      } catch (SQLException ex) {
          Logger.getLogger(MDIFinanzas.class.getName()).log(Level.SEVERE, null, ex);
      }
        JDesktopFinanzas.add(FrmBancaria);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
      try {
          // TODO add your handling code here:
          FrmHabiente = new FrmCuentaHabiente();
      } catch (SQLException ex) {
          Logger.getLogger(MDIFinanzas.class.getName()).log(Level.SEVERE, null, ex);
      }
        JDesktopFinanzas.add(FrmHabiente);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

>>>>>>> 2a6f8a70b0b40255f3502969812bcff8b86de0d8

    public static void main(String args[]) {
       
        //FLATLAF
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.out.println(ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDIFinanzas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane JDesktopFinanzas;
    private javax.swing.JMenu JMenuArchivo;
    private javax.swing.JMenu JMenuAyuda;
    private javax.swing.JMenuBar JMenuBarFinanzas;
    private javax.swing.JMenu JMenuCatalogoBancos;
    private javax.swing.JMenu JMenuCatalogoContabilidad;
    private javax.swing.JMenu JMenuCatalogos;
    private javax.swing.JMenu JMenuHerramientas;
    private javax.swing.JMenu JMenuInformes;
    private javax.swing.JMenu JMenuProcesos;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
