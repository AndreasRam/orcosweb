package cl.senpai.orcosWeb.beans;

import cl.senpai.orcosEjb.dao.UsuariosDAOLocal;
import cl.senpai.orcosEjb.dto.Usuario;
import cl.senpai.orcosWeb.utils.PasswordUtil;
import cl.senpai.orcosWeb.utils.UtilsConstants;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {

    private String usuario;
    private String clave;
    private Usuario usuarioLogeado;
    @Inject
    private UsuariosDAOLocal usuariosDAO;
    
    public LoginManagedBean() {
        
    }
   
    public void iniciarSesion(ActionEvent e) throws IOException{
        
        String hash = PasswordUtil.generateSecurePassword(clave, UtilsConstants.salt);
        this.usuarioLogeado = this.usuariosDAO.findByCorreoYClave(usuario, hash);
        
        if(this.usuarioLogeado != null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Usuario o contraseña incorrecta"));
        }
        
    }
    
    public void cerrarSesion(ActionEvent e) throws IOException{
        
        this.usuarioLogeado = null;
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Usuario getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(Usuario usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }
    
    
}
