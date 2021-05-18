/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.vista;

import Comercial.datos.ClienteDao;
import Comercial.datos.DepositosDAO;
import Comercial.datos.facturaDao;
import Comercial.dominio.Cliente;
import Comercial.dominio.Deposito;
import Comercial.dominio.Factura;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import seguridad.vista.GenerarPermisos;
import seguridad.vista.Login;

/**
 *
 * @author PERSONAL
 */
public class Proceso_Depositos extends javax.swing.JInternalFrame {
  ClienteDao Clientes= new   ClienteDao  ();
  Cliente Buscar = new  Cliente ();
   DepositosDAO C = new   DepositosDAO  ();
    Deposito B = new  Deposito();
    int estadovalidacion;
    
    int variable1;
    /**
     * Creates new form Proceso_Factura
     */
     void habilitarAcciones() {

      int   codigoAplicacion = 3005;
        var usuario = Login.usuarioComercial;

        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnBuscar.setEnabled(false);

        GenerarPermisos permisos = new GenerarPermisos();

        String[] permisosApp = new String[4];

        for (int i = 0; i < 4; i++) {
            permisosApp[i] = permisos.getAccionesAplicacion(codigoAplicacion, usuario)[i];
        }

        if (permisosApp[0].equals("1")) {
            btnAgregar.setEnabled(true);
        }
        if (permisosApp[1].equals("1")) {
            btnBuscar.setEnabled(true);
        }
        if (permisosApp[2].equals("1")) {
            btnModificar.setEnabled(true);
        }
        if (permisosApp[3].equals("1")) {
            btnEliminar.setEnabled(true);
        }
    }
    
     public void llenadoDeCombos() {
        
        List<Cliente> Buscar =  Clientes.select();
        cbox_empleado.addItem("Seleccione un cliente");
        for (int i = 0; i < Buscar.size(); i++) {
            cbox_empleado.addItem(Buscar.get(i).getCliente());
             String valor =  cbox_empleado.getSelectedItem().toString();
   

    }}
     public void validar(){ 
         String valor =  cbox_empleado.getSelectedItem().toString();
       Buscar.setCliente(valor);
       Buscar =   Clientes.query2( Buscar);
      
            estadovalidacion = 1;
            cliente.setText(  Buscar.getCliente());
     
 buscar();         
    

            estadovalidacion = 0;
        }
 
public void llenadoDeTablas() {
    
    /**
 *
 * creaccion de la tabla de de titulos  
 */
        DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("Id_pedido");
        modelo.addColumn("Cliente");
          modelo.addColumn("Cuenta");
            modelo.addColumn("Fecha Inicial");
              modelo.addColumn("Fecha Final");
        modelo.addColumn("Nit");
          modelo.addColumn("Telefono");
          modelo.addColumn("Poducto");
           modelo.addColumn("Detalle");
            modelo.addColumn("Cantidad");
  
   DepositosDAO  ventasDAO = new    DepositosDAO();
      
  


       List<Deposito> ventas = ventasDAO.select();
        JtProductos1.setModel(modelo);
        String[] dato = new String[10];
    for (int i = 0; i < ventas.size(); i++) {
         dato[0] = (ventas.get(i).getId_pedido());
            dato[1] = (ventas.get(i).getCliente());
            dato[2] = ventas.get(i).getCuenta();
             dato[3] = (ventas.get(i).getFecha_inicial());
              dato[4] = (ventas.get(i).getFecha_final());          
              dato[5] = ventas.get(i).getNit();
            dato[6] = (ventas.get(i).getTelefono());
          dato[7] = (ventas.get(i).getProducto());
             dato[8] = (ventas.get(i).getDetalle());
                dato[9] = (ventas.get(i).getCantidad());
           
          
          
          
          
            System.out.println("vendedor:" + ventas);
            modelo.addRow(dato);
        }
     }
 public void buscar() {
  Buscar.setCliente(cliente.getText());
Buscar=Clientes.query2(Buscar);         
nit.setText(Buscar.getNit());
//monto.setText(Buscar.getMonto());
telefono.setText(Buscar.getTelefono());
producto.setText(Buscar.getProducto());
cuenta.setText(Buscar.getCuenta());
  
    }
public void buscarVendedor() {
          
 B.setId_pedido(i.getText());
B=C.query3(B);

nit.setText(B.getNit());
telefono.setText(B.getTelefono());
producto.setText(B.getProducto());
cuenta.setText(B.getCuenta());
detalle.setText(B.getDetalle());
cliente.setText(B.getCliente());
f1.setText(B.getFecha_inicial());
f2.setText(B.getFecha_final());
cantidad.setText(B.getCantidad());

}
    /**
     * Creates new form Proceso_Depositos
     */
    public Proceso_Depositos() {
        initComponents();
        llenadoDeCombos();
        llenadoDeTablas();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cuenta = new javax.swing.JTextField();
        nit = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        producto = new javax.swing.JTextField();
        detalle = new javax.swing.JTextField();
        cantidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtProductos1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        i = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbox_empleado = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        cliente = new javax.swing.JTextField();
        fechai = new com.toedter.calendar.JDateChooser();
        fechaf = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        f1 = new javax.swing.JLabel();
        f2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Procesos Depositos");

        cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuentaActionPerformed(evt);
            }
        });

        JtProductos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(JtProductos1);

        jLabel1.setText("Depositos");

        jLabel2.setText("No de Cuenta");

        jRadioButton1.setText("Depositos");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha Final");

        jRadioButton2.setText("Abono de  debolucion");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha Inicial");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel5.setText("Nit");

        btnAgregar.setText("Guardar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel6.setText("Telefono");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel7.setText(" Producto");

        jLabel8.setText("Cantidad");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel10.setText("Detalle");

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteActionPerformed(evt);
            }
        });

        fechai.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Cliente o Empresas");

        f1.setText("jLabel9");

        f2.setText("jLabel12");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jRadioButton1)
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton2)
                                .addGap(49, 49, 49)
                                .addComponent(jButton1))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btnAgregar)
                        .addGap(36, 36, 36)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(f1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(i, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(102, 102, 102))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(fechaf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fechai, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(detalle, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nit, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(cbox_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 446, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(f2)
                        .addGap(199, 199, 199)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(cbox_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(f2))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(nit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(producto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(detalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(fechaf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificar)
                        .addComponent(btnEliminar)
                        .addComponent(btnBuscar)
                        .addComponent(i, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuentaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
buscarVendedor();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
                DepositosDAO ClienteDAO = new   DepositosDAO  ();
             String fecha1 = new SimpleDateFormat("dd/MM/yyyy").format(fechai.getDate());
              String fecha2 = new SimpleDateFormat("dd/MM/yyyy").format(fechaf.getDate());
                Deposito AInsertar = new  Deposito();
//                AInsertar.(ID.getText());
                AInsertar.setCliente(cliente.getText());
                  AInsertar.setCuenta(cuenta.getText());
                AInsertar.setNit(nit.getText());
                  AInsertar.setFecha_inicial(fecha1);
                AInsertar.setFecha_final(fecha2);         
                AInsertar.setTelefono(telefono.getText());
                AInsertar.setProducto(producto.getText());
                    AInsertar.setDetalle(detalle.getText());
                       AInsertar.setCantidad(cantidad.getText());
                ClienteDAO.insert(AInsertar);
        
                llenadoDeTablas();

                

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
     DepositosDAO D = new   DepositosDAO  ();
             
                Deposito AModificat = new  Deposito();
//               
                AModificat .setId_pedido(i.getText());
                AModificat .setCliente(cliente.getText());
                AModificat .setCuenta(cuenta.getText());
                AModificat .setNit(nit.getText());
                AModificat .setFecha_inicial(f1.getText());
                AModificat .setFecha_final(f2.getText());      
                AModificat .setTelefono(telefono.getText());
                AModificat .setProducto(producto.getText());
                AModificat .setDetalle(detalle.getText());
                AModificat .setCantidad(cantidad.getText());
                D.update(AModificat);
        
                llenadoDeTablas(); 
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
  DepositosDAO DAO = new   DepositosDAO  ();
             
                Deposito AEliminar = new  Deposito();
//               
                AEliminar.setId_pedido(i.getText());
                AEliminar.setCliente(cliente.getText());
                AEliminar.setCuenta(cuenta.getText());
                AEliminar.setNit(nit.getText());
                    AEliminar.setFecha_inicial(f1.getText());
                AEliminar.setFecha_final(f2.getText());      
                AEliminar.setTelefono(telefono.getText());
                AEliminar.setProducto(producto.getText());
                AEliminar.setDetalle(detalle.getText());
                      AEliminar.setCantidad(cantidad.getText());
                DAO.delete(AEliminar);
        
                llenadoDeTablas();     
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 validar();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
detalle.setText("Deposito");
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
detalle.setText("Devolucion");
        
    }//GEN-LAST:event_jRadioButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtProductos1;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JComboBox<String> cbox_empleado;
    private javax.swing.JTextField cliente;
    private javax.swing.JTextField cuenta;
    private javax.swing.JTextField detalle;
    private javax.swing.JLabel f1;
    private javax.swing.JLabel f2;
    private com.toedter.calendar.JDateChooser fechaf;
    private com.toedter.calendar.JDateChooser fechai;
    private javax.swing.JTextField i;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nit;
    private javax.swing.JTextField producto;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
