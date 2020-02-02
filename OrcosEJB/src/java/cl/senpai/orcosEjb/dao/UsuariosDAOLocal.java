package cl.senpai.orcosEjb.dao;

import cl.senpai.orcosEjb.dto.Usuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UsuariosDAOLocal {
    
    public void add(Usuario u);
    public List<Usuario> findAll();
    public Usuario findByCorreoYClave(String correo, String clave);
}
