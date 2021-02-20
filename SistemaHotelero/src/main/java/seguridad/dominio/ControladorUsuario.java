package seguridad.dominio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import seguridad.datos.Usuario;
import seguridad.datos.UsuarioDAO;
import seguridad.vista.FrmCrudUsuarios;

/**
 *
 * @author OtakuGT
 */
public class ControladorUsuario implements ActionListener{
    
    UsuarioDAO dao = new UsuarioDAO();
    Usuario usr = new Usuario();
    FrmCrudUsuarios vista = new FrmCrudUsuarios();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public ControladorUsuario (FrmCrudUsuarios v){
        this.vista=v;
        this.vista.BtnBus.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==vista.BtnBus){
            listar(vista.Tabla);
        }
    }
    public void listar(JTable Tabla){
        modelo=(DefaultTableModel)Tabla.getModel();
        List<Usuario>lista=dao.listar();
        Object[]object=new Object[7];
        for (int i = 0; i < lista.size(); i++){
            object[0]=lista.get(i).getId_usuario();
            object[1]=lista.get(i).getNombre_usuario();
            object[2]=lista.get(i).getApellido_usuario();
            object[3]=lista.get(i).getPassword_usuario();
            object[4]=lista.get(i).getCambio_password();
            object[5]=lista.get(i).getUltima_conexion();
            object[6]=lista.get(i).getEstado_usuario();
            modelo.addRow(object);
            
        }
        vista.Tabla.setModel(modelo);
    }
}
