package Comercial.vista;

import static Hoteleria.vista.MDIHoteleria.jDesktopPane1;
import static Hoteleria.vista.MDIHoteleria.logo;
import Hoteleria.vista.ReservaDeHabitacion;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import seguridad.vista.GenerarPermisos;
import seguridad.vista.Login;
import seguridad.vista.MDI_Components;

/*
    @author Diego Vásquez
 */
public class MDIComercial1 extends javax.swing.JFrame {
 private MantenimientoProductos formModulos;
  private Mantenimiento_Cliente Mantenimiento_Cliente ;
  private Mantenimiento_Deudores  Mantenimiento_Acreedor;
    private  FmrBitacora FmrBitacora;
   
    public MDIComercial1() throws UnknownHostException {
        initComponents();
             Icon icon = new ImageIcon("C:src/main/java/Imagen/2.jpg");
           jLabel1.setIcon(new ImageIcon("src\\main\\java\\Imagen\\2.jpg"));
           jLabel1.setVisible(true);
            
       
          GenerarPermisos permisos = new GenerarPermisos();
    MDI_Components mdi_Components = new MDI_Components();
       
         String modulo_nombre = "Comercial";
        initComponents();
        this.setTitle("Usuario: " + "[" + Login.usuarioComercial + "]" + " \t" + "IP: [" + mdi_Components.getIp() + "]");
        permisos.getPermisos(modulo_nombre, Login.usuarioComercial);
  
    }
 
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane()
        ;
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        M_ccompras = new javax.swing.JMenu();
        M_venta = new javax.swing.JMenu();
        M_cliente = new javax.swing.JMenuItem();
        M_deudor = new javax.swing.JMenuItem();
        M_compras = new javax.swing.JMenu();
        M_producto = new javax.swing.JMenuItem();
        M_proveedor = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        cerrar_sesion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modulo Comercial [ip] [user]");
        setResizable(false);

        jDesktopPane1.setBackground(new java.awt.Color(255, 200, 23));

        jLabel1.setIcon(new ImageIcon("src\\main\\java\\Imagen\\2.png"));

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(822, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(339, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));

        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        jMenu3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        M_ccompras.setText("Catalogos");
        M_ccompras.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        M_venta.setText("Mantenimientos Ventas");

        M_cliente.setText("Mantenimineto Cliente");
        M_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_clienteActionPerformed(evt);
            }
        });
        M_venta.add(M_cliente);

        M_deudor.setText("Mantenimiento Deudor");
        M_deudor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_deudorActionPerformed(evt);
            }
        });
        M_venta.add(M_deudor);

        M_ccompras.add(M_venta);

        M_compras.setText("Mantenimientos Compras");

        M_producto.setText("Mantenimiento Producto");
        M_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_productoActionPerformed(evt);
            }
        });
        M_compras.add(M_producto);

        M_proveedor.setText("Mantenimiento Proveedor");
        M_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_proveedorActionPerformed(evt);
            }
        });
        M_compras.add(M_proveedor);

        M_ccompras.add(M_compras);

        jMenu10.setText("Mantenimientos Inventarios");
        M_ccompras.add(jMenu10);

        jMenuBar1.add(M_ccompras);

        jMenu4.setText("Procesos");
        jMenu4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu4);

        jMenu12.setText("Informes");
        jMenu12.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        jMenu13.setText("Historial");

        jMenuItem1.setText("Bitacora Comercial");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem1);

        jMenu12.add(jMenu13);

        jMenuBar1.add(jMenu12);

        jMenu6.setText("Herramientas");
        jMenu6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu6);

        jMenu7.setText("Ayuda");
        jMenu7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        jMenu11.setText("Ayuda");
        jMenu11.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jMenuItem7.setText("Ayuda Menu");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem7);

        jMenu7.add(jMenu11);

        jMenuBar1.add(jMenu7);

        cerrar_sesion.setText("Cerrar Sesión");
        cerrar_sesion.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        cerrar_sesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrar_sesionMouseClicked(evt);
            }
        });
        jMenuBar1.add(cerrar_sesion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void M_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_clienteActionPerformed
     
        Mantenimiento_Cliente= new Mantenimiento_Cliente();
    
        jDesktopPane1.add(Mantenimiento_Cliente);
       
      
 Mantenimiento_Cliente.setVisible(true);
 jLabel1.setVisible(true);
    
     
  
    }//GEN-LAST:event_M_clienteActionPerformed

    private void M_deudorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_deudorActionPerformed
        Mantenimiento_Acreedor= new Mantenimiento_Deudores();
        Mantenimiento_Acreedor.setVisible(true);
        jDesktopPane1.add(Mantenimiento_Acreedor);
     
        // TODO add your handling code here:
    }//GEN-LAST:event_M_deudorActionPerformed

    private void M_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_productoActionPerformed
        MantenimientoProductos ventana = new MantenimientoProductos();
        jDesktopPane1.add(ventana);
 
        // TODO add your handling code here:
    }//GEN-LAST:event_M_productoActionPerformed

    private void M_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_proveedorActionPerformed
        MantenimientoProveedor ventana = new MantenimientoProveedor();
        jDesktopPane1.add(ventana);
  
        // TODO add your handling code here:
    }//GEN-LAST:event_M_proveedorActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FmrBitacora = new FmrBitacora();
        FmrBitacora.setVisible(true);

        jDesktopPane1.add(FmrBitacora );


        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        try {
            if ((new File("src\\main\\java\\Comercial\\reportes\\menu.chm")).exists()) {
                Process p = Runtime
                .getRuntime()
                .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\Comercial\\reportes\\menu.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void cerrar_sesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrar_sesionMouseClicked
        int respuesta_cs = JOptionPane.showConfirmDialog(this, "¿Desea Cerrar Sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION);

        if (respuesta_cs == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_cerrar_sesionMouseClicked

    public static void main(String args[]) {
       
        //FLATLAF
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.out.println(ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MDIComercial1().setVisible(true);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(MDIComercial1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu M_ccompras;
    public static javax.swing.JMenuItem M_cliente;
    public static javax.swing.JMenu M_compras;
    public static javax.swing.JMenuItem M_deudor;
    public static javax.swing.JMenuItem M_producto;
    public static javax.swing.JMenuItem M_proveedor;
    public static javax.swing.JMenu M_venta;
    public static javax.swing.JMenu cerrar_sesion;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    public static javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem7;
    // End of variables declaration//GEN-END:variables
}
