/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.dominio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import seguridad.datos.Usuario;
import seguridad.datos.UsuarioDAO;
import seguridad.vista.MantenimientoUsuario;

/**
 *
 * @author OtakuGT
 */
public class Controlador implements ActionListener {
    UsuarioDAO dao= new UsuarioDAO();
    Usuario usuario = new Usuario();
    MantenimientoUsuario vista = new MantenimientoUsuario();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Controlador(MantenimientoUsuario v){ 
        this.vista=v;
        this.vista.BtnListar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==vista.BtnListar){
           listar(vista.JTable);
       }
    }
    public void listar(JTable tabla){
        modelo=(DefaultTableModel) tabla.getModel();
        List<Usuario>Usuarios=dao.select();
        Object[]object=new Object[6];
        for (int i = 0; i < Usuarios.size(); i++){
            object[0]=Usuarios.get(i).getId_usuario();
            object[1]=Usuarios.get(i).getNombre_usuario();
            object[2]=Usuarios.get(i).getApellido_usuario();
            object[3]=Usuarios.get(i).getPassword_usuario();
            object[4]=Usuarios.get(i).getCambio_password();
            object[0]=Usuarios.get(i).getEstado_usuario();
            modelo.addRow(object);
            
        }
        vista.JTable.setModel(modelo);
    }
}
