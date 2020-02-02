package cl.senpai.orcosEjb.dao;

import cl.senpai.orcosEjb.dto.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
public class UsuariosDAO implements UsuariosDAOLocal {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcosEJBPU");
    
    @Override
    public void add(Usuario u) {
        
        EntityManager em = emf.createEntityManager();
        try {
            em.persist(u);
            em.flush();
        } catch (Exception e) {
        
        }finally{
            em.close();
        }
    }

    @Override
    public List<Usuario> findAll() {
    
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
        } catch (Exception e) {
            return null;
        }finally{
            em.close();
        }
        
    }

    @Override
    public Usuario findByCorreoYClave(String correo, String clave) {
        
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Usuario.findByCorreoYClave", Usuario.class)
                    .setParameter("correo", correo)
                    .setParameter("clave", clave)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }finally{
            
        }
        
    }
    
}
