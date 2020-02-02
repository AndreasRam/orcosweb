package cl.senpai.orcosWeb.beans;

import cl.senpai.orcosEjb.dao.UsuariosDAOLocal;
import cl.senpai.orcosEjb.dto.Usuario;
import cl.senpai.orcosWeb.utils.PasswordUtil;
import cl.senpai.orcosWeb.utils.UtilsConstants;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "registrarUsuarioManagedBean")
@ViewScoped
public class RegistrarUsuarioManagedBean implements Serializable{

    @Inject
    private UsuariosDAOLocal usuarioDAO;
    private String nombre;
    private String clave;
    private String correo;
    
    public RegistrarUsuarioManagedBean() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public void registrar(ActionEvent e){
        String hash = PasswordUtil.generateSecurePassword(clave, UtilsConstants.salt);
        
        Usuario u = new Usuario();
        u.setNombre(nombre);
        u.setCorreo(correo);
        u.setClave(hash);
        u.setEstado(1);
        
        usuarioDAO.add(u);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario Registrado!"));
    }
}
