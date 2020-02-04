package cl.senpai.orcosWeb.beans;

import cl.senpai.orcosEjb.dao.UsuariosDAOLocal;
import cl.senpai.orcosEjb.dto.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;


@Named(value = "verUsuariosManagedBean")
@ViewScoped
public class VerUsuariosManagedBean implements Serializable{

    @Inject
    private UsuariosDAOLocal usuariosDAO;
    private List<Usuario> usuarios;
    
    @PostConstruct
    public void init(){
        this.usuarios = this.usuariosDAO.findAll();
    }

    public VerUsuariosManagedBean() {
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
}
