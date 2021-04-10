package seguridad.dominio;
import seguridad.datos.PermisosDAO;

public class Permisos {

    PermisosDAO permisosDAO = new PermisosDAO();
    
    public void ejecutarBusqueda(String nombreUsuario) {
        permisosDAO.setNombreUsuario(nombreUsuario);
        permisosDAO.getCodigoUsuario();
        permisosDAO.getCantidadApps();
    }
    
    public String[] getAplicaciones(){
        String[] appsDeUsuario;
        appsDeUsuario = new String[permisosDAO.AppsdeUsuario().length];
        
        for(int i=0; i<appsDeUsuario.length; i++){
            appsDeUsuario[i] = permisosDAO.AppsdeUsuario()[i];
        }
        return appsDeUsuario;
    }
}
